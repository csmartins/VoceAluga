package br.action;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class ValidadorDadosCadastro
{

	private static final int TAMANHO_MAXIMO_NOME = 3;

	public boolean validarNome(String nome)
	{
		if(nome.length() < TAMANHO_MAXIMO_NOME)
			return false;
		else
			return true;
	}

	public boolean validarCpf(String cpf)
	{
		boolean valido = false;
		
		if(cpf.matches("[0-9]+") && (cpf.length() <= 11))
			valido = true;
		
		return valido;
	}
	
	public boolean validarRG(String rg)
	{
		boolean valido = false;
		
		if(rg.matches("[0-9]+"))
			valido = true;
		
		return valido;
	}

	public boolean validarTelefone(String telefone)
	{
		boolean valido = false;
		
		if(telefone.matches("[0-9]+") && (telefone.length() <= 8))
			valido = true;
		
		return valido;
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
		if(carteira.isEmpty() || !(carteira.matches("[0-9]+")))
			return false;
		else
			return true;
	}
	
}
