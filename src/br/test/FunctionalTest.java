package br.test;

import br.model.CarroDAO;

public class FunctionalTest
{
	
	private CarroDAO carroDAO;
	
	public void limparCarroAdicionadoPorPlaca(String placa)
	{
		carroDAO = new CarroDAO();
		
		carroDAO.apagarCarroAdicionadoNoTestePorPlaca(placa);
	}
}
