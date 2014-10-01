package br.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pela leitura de um  SQL em um arquivo para que possa ser utilizado.
 * 
 * @author zotte
 *
 */
public class SQLScriptReader implements Serializable
{
  private static final long serialVersionUID = -2797578054965809618L;

  /**
   * Lê um arquivo, tanto um {@link InputStream} ou {@link File}
   * 
   * @param input
   * @return a representação String do arquivo.
   */
  public static <T> String read(T input)
  {
    StringBuffer buffer = new StringBuffer();
    Reader reader = null;
    
    try
    {
      if ( input instanceof File )
      {
        reader = new FileReader((File) input);
      }
      else if ( input instanceof InputStream )
      {
        reader = new InputStreamReader((InputStream) input, "UTF-8");
      }
      else 
      {
        return null;
      }
      
      List<String> lines = readLines(reader);
      for ( String line : lines )
      { 
        buffer.append(SQLParser.parseLine(line));
      }
      
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
    
    return buffer.toString();
  }
  
  private static List<String> readLines(Reader reader) throws IOException
  {
    List<String> lines = new ArrayList<String>();
    String line;
    
    BufferedReader br = new BufferedReader(reader);
    while ( (line = br.readLine()) != null )
    {
      lines.add(line);
    }
    
    return lines;
  }
}
