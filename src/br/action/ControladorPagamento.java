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
	
	public void venderCarro(Carro veiculo, String formaPagamento)
	{
		veiculo.setDisponivel("false");
		veiculo.setVendido("true");
		veiculo.setFormaPagamento(formaPagamento);
		
		carroDAO.atualizarVeiculo(veiculo);
	}

	public void venderCarroCredito(Carro veiculo, String parcelas)
	{
		String formaPagamento = "Crédito em " + parcelas + " vezes";
		
		venderCarro(veiculo, formaPagamento);
	}

}
