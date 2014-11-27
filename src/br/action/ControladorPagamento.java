package br.action;

import br.model.Carro;
import br.model.CarroDAO;

public class ControladorPagamento
{
	private CarroDAO carroDAO;
	
	public ControladorPagamento()
	{
		carroDAO = new CarroDAO();
	}
	
	public void venderCarro(Carro veiculo)
	{
		veiculo.setDisponivel("false");
		veiculo.setVendido("true");
		
		carroDAO.atualizarVeiculo(veiculo);
	}

}
