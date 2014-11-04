package br.action;

import java.util.Date;

public class ValidadorDadosCadastroVeiculo
{

	public boolean validarModelo(String modelo)
	{
		if(modelo == null)
			return false;
		
		if(modelo.equals(""))
			return false;
		else
			return true;
	}

	public boolean validarMarca(String marca)
	{
		if(marca == null)
			return false;
		
		if(marca.equals(""))
			return false;
		else
			return true;
	}

	public boolean validarPlaca(String placa)
	{
		if(placa == null)
			return false;
		
		if(placa.equals(""))
			return false;
		else
			return true;
	}
	
	public boolean validarUltimaManutencao(Date ultimaManutencao)
	{
		if(ultimaManutencao.after(new Date()))
			return false;
		else
			return true;
	}
	
	public boolean validarPreco(String preco)
	{
		if(preco.equals("") || !preco.matches("[0-9]+"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean validarDiaria(String diaria)
	{
		if(diaria.equals("") || !diaria.matches("[0-9]+"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
