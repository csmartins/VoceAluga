package br.action;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import br.model.Carro;
import br.model.CarroDAO;

public class ValidadorDadosReservaVeiculo
{

	public boolean validarCPF(String cpf)
	{
		if(cpf == null || cpf.equals(""))
			return false;
		else
			return true;
	}

	public boolean validarModelo(String modelo)
	{
		if(modelo == null || modelo.equals(""))
			return false;
		else
			return true;
	}

	public boolean validarMarca(String marca)
	{
		if(marca == null || marca.equals(""))
			return false;
		else
			return true;
	}

	public boolean validarDataFim(Date dataFim)
	{
		if(dataFim != null)
			return true;
		
		else
			try
			{
				if(dataFim.before(new Date()))
					return false;
			}
			catch (NullPointerException e) 
			{
				return false;
			}
			
			return false;
	}
	
	public boolean validarDataInicio(Date dataInicio)
	{
		if(dataInicio != null)
			return true;
		
		else
			try
			{
				if(dataInicio.before(new Date()))
					return false;
			}
			catch (NullPointerException e) 
			{
				return false;
			}
			
			return false;
	}
	
	public boolean validarDataFimDepoisDataInicio(Date dataInicio, Date dataFim)
	{
		if (dataFim != null && dataInicio != null &&
				dataFim.before(dataInicio))
		{
			return false;
		}
		
		return true;
	}

	public boolean validarExistenciaDeVeiculoParaMarcaEModelo(String marca, String modelo)
	{
		CarroDAO carroDAO = new CarroDAO();
		
		try
		{
			Carro veiculo = carroDAO.recuperarCarroDisponivelPorMarcaEModelo(marca, modelo);
			
			return true;
		}
		catch(NoResultException e)
		{
			return false;
		}
		
		
	}
}
