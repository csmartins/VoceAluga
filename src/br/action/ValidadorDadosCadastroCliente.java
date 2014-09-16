package br.action;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class ValidadorDadosCadastroCliente
{

	private static final int TAMANHO_MAXIMO_NOME = 3;

	public boolean validarNome(String nome)
	{
		if(nome == null)
			return false;
		
		if((nome.length() < TAMANHO_MAXIMO_NOME) || !nome.matches("[A-Z][a-z]+( [A-Z][a-z]+)?"))
			return false;
		else
			return true;
	}

	public boolean validarCpf(String cpf)
	{
		boolean valido = false;
		
		if(cpf == null)
			return false;
		
		if(cpf.matches("[0-9]+") && (cpf.length() <= 11))
			valido = true;
		
		return valido;
	}
	
	public boolean validarRG(String rg)
	{
		
		if(rg == null)
			return false;
		
		if(rg.matches("[0-9]+"))
			return true;
		else
			return false;
		
	}

	public boolean validarTelefone(String telefone)
	{
		if(telefone == null)
			return false;
		
		if(telefone.matches("[0-9]+") && (telefone.length() <= 8))
			return true;
		else
			return false;
	}

	public boolean validarEmail(String email)
	{
		try
		{
			InternetAddress internetAddress = new InternetAddress(email);

			internetAddress.validate();
			return true;
		} catch (AddressException e)
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean validarCarteira(String carteira)
	{
		if(carteira == null)
			return false;
		
		if(!(carteira.matches("[0-9]+")))
			return false;
		else
			return true;
	}
	
}
