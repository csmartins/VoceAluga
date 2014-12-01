package br.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.model.Aluguel;
import br.model.AluguelDAO;

public class ControladorConsultaAluguel
{
	private AluguelDAO aluguelDAO;
	private ArrayList<Aluguel> alugueis;
	private ArrayList<String> textoAlugueis;
	private SimpleDateFormat formatoData;
	
	public ControladorConsultaAluguel()
	{
		aluguelDAO = new AluguelDAO();
		alugueis = new ArrayList<Aluguel>();
		textoAlugueis = new ArrayList<String>();
		formatoData = new SimpleDateFormat("dd/MM/yyyy");
		
		prepopular();
	}
	
	public void prepopular()
	{
		alugueis.addAll(aluguelDAO.recuperarTodosAlugueis());
		popularTextoAlugueis();
	}
	
	public void atualizarListadeAlugueis()
	{
		aluguelDAO.refresh("Aluguel");
		alugueis.clear();
		prepopular();
	}
	
	public void filtrarAlugueis(String cpf)
	{
		alugueis.clear();
		
		if (cpf == null || cpf.equals(""))
		{
			alugueis.addAll(aluguelDAO.recuperarTodosAlugueis());
		}
		else
		{
			alugueis.addAll(aluguelDAO.recuperarAlugueisPorCpfCliente(cpf));
		}
		
		popularTextoAlugueis();
	}

	private void popularTextoAlugueis()
	{
		textoAlugueis.clear();
		
		for (Aluguel a : alugueis)
		{
			textoAlugueis.add(formatarAluguel(a));
		}
	}
	
	public String formatarAluguel(Aluguel a)
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append("Carro: ");
		buf.append(a.getCarro().getMarca());
		buf.append(" ");
		buf.append(a.getCarro().getModelo());
		
		buf.append(" | ");
		
		buf.append("Cliente: ");
		buf.append(a.getPessoa().getNome());
		
		buf.append(" | ");
		
		buf.append("Duração: ");
		buf.append(formatoData.format(a.getDataInicio()));
		buf.append(" a ");
		buf.append(formatoData.format(a.getDataFim()));
		
		return buf.toString();
	}

	public ArrayList<String> getTextoAlugueis()
	{
		return textoAlugueis;
	}
	
	public Aluguel getAluguel(int index)
	{
		return alugueis.get(index);
	}
	
	public ArrayList<Aluguel> getAlugueis()
	{
		return alugueis;
	}
}
