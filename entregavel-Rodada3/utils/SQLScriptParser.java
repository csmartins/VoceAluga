package br.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

	


/**
 * Executa as transformacoes necessárias na consulta para que 
 * esta esteja apta a ser executada via JDBC. 
 * 
 * @author zotte
 *
 */
class SQLParser implements Serializable
{
  private static final long serialVersionUID = 7131947835869270176L;

  protected static final String QUERY_PARAMETER = "?";
  
  protected static final String TAB             = "\t";
  protected static final String LINE_FEED       = "\n";
  protected static final String CARRIAGE_RETURN = "\r";
  protected static final String COMMENT         = "--";
  
  /**
   * Prepara os parametros da consulta.
   * 
   * @param query
   * @param parameters
   * @return a consulta com os devidos numeros de parametros.
   */
  @SuppressWarnings("rawtypes")
  protected static String prepareParameterizedQuery(String query, List<?> parameters)
  {
    List<Integer> parametersIndex = new ArrayList<Integer>();
    int extraChars = 0;
    int parameterIndex = query.indexOf(QUERY_PARAMETER);
    
    while ( parameterIndex != -1 )
    {
      parametersIndex.add(parameterIndex);
      parameterIndex = query.indexOf(QUERY_PARAMETER, parameterIndex + 1);
    }
    
    for ( int i = 1; i < parameters.size(); i++ )
    {
      Object parameter = parameters.get(i);
      
      if ( parameter instanceof Collection )
      {
        int size = ((Collection) parameter).size();
        
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < size; j++)
        {
          buffer.append(QUERY_PARAMETER + ",");
        }
        query = StringUtils.overlay(query, StringUtils.chop(buffer.toString()), parametersIndex.get(i-1) + extraChars, parametersIndex.get(i-1) + extraChars + 1);
        
        extraChars += 2 * size - 2; // 2 caracteres('?' e ',') vezes(tamanho) - 2 ('?' e ',')
      }
    }
    
    return query;
  }
  
  /**
   * Realiza as transformações necessárias para que a consulta
   * seja executada via JDBC
   * 
   * @param line a ser transformada
   * @return a linha transformada
   */
  protected static String parseLine(String line)
  {
    if ( !isCommentedLine(line) )
    {
      line = line.trim();
      line = removeControlChars(line);
      line = removeComments(line);
      line = line.endsWith(" ") ? line : line + " ";
      
      return line.replaceAll("\\s{1,}", " ");
    }
    
    return "";
  }

  /**
   * Verifica se uma linha é um cmentario ou nao.
   * 
   * @param line
   * @return
   */
  private static boolean isCommentedLine(String line)
  {
    return Pattern.matches("\\s{0,}" + COMMENT + ".*", line);
  }

  /**
   * Remove os caracters de controle.
   * 
   * @param line
   * @return
   */
  private static String removeControlChars(String line)
  {
    return line.replaceAll(CARRIAGE_RETURN, "").replaceAll(LINE_FEED, "").replaceAll(TAB, "");
  }

  /**
   * Remove qualquer comentario naquela linha.
   * 
   * @param line
   * @return
   */
  private static String removeComments(String line)
  {
    return line.contains(COMMENT) ? line.substring(0, line.indexOf(COMMENT)) : line;
  }
  
}
