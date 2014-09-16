package br.action;

import java.util.Date;

public class ValidadorDadosCadastroVeiculo
{

	public boolean validarModelo(String modelo)
	{
		if(modelo == null)
			return false;
		else
			return true;
	}

	public boolean validarMarca(String marca)
	{
		if(marca == null)
			return false;
		else
			return true;
	}

	public boolean validarPlaca(String placa)
	{
		if(placa == null)
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

}
