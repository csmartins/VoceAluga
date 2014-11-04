package br.action;

import java.util.ArrayList;

import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorConsultaCliente
{
	private PessoaDAO pessoaDAO;
	private ArrayList<Pessoa> pessoas;
	private ArrayList<String> textoClientes;
	
	public ControladorConsultaCliente()
	{
		pessoaDAO = new PessoaDAO();
		pessoas = new ArrayList<Pessoa>();
		textoClientes = new ArrayList<String>();
		
		prepopular();
	}
	
	public void prepopular()
	{
		pessoas.addAll(pessoaDAO.recuperarTodasPessoas());
		popularTextoClientes();
	}
	
	public void filtrarClientes(String cpf)
	{
		pessoas.clear();
		
		if (cpf == null || cpf.equals(""))
		{
			pessoas.addAll(pessoaDAO.recuperarTodasPessoas());
		}
		else
		{
			pessoas.addAll(pessoaDAO.recuperarPessoasPorCPF(cpf));
		}
		
		popularTextoClientes();
	}

	private void popularTextoClientes()
	{
		textoClientes.clear();
		
		for (Pessoa p : pessoas)
		{
			textoClientes.add(formatarInformacoesCliente(p));
		}
	}
	
	private String formatarInformacoesCliente(Pessoa p)
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append("CPF: ");
		buf.append(p.getCpf());
		
		buf.append(" | ");
		
		buf.append("Nome: ");
		buf.append(p.getNome());
		
		return buf.toString();
	}

	public ArrayList<String> getTextoClientes()
	{
		return textoClientes;
	}
	
	public Pessoa getCliente(int index)
	{
		return pessoas.get(index);
	}
}
