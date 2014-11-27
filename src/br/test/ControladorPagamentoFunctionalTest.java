package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorPagamento;
import br.model.Carro;
import br.model.CarroDAO;

public class ControladorPagamentoFunctionalTest extends FunctionalTest
{
	private ControladorPagamento controladorPagamento;
	
	private CarroDAO carroDAO;
	
	@Test
	public void testControladorPagamento_VenderCarro_VeiculoDisponivel_DeveSetarVendidoParaTrueEDisponivelParaFalse()
	{
		controladorPagamento = new ControladorPagamento();
		
		carroDAO = new CarroDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "true");
		Assert.assertEquals(veiculo.getVendido(), "false");
		
		controladorPagamento.venderCarro(veiculo);
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		Assert.assertEquals(veiculo.getVendido(), "true");
		
		veiculo.setDisponivel("true");
		veiculo.setVendido("false");
		carroDAO.atualizarVeiculo(veiculo);
	}
	
	@Test
	public void testControladorPagamento_VenderCarro_VeiculoIndisponivel_DeveSetarVendidoParaTrue()
	{
		controladorPagamento = new ControladorPagamento();
		
		carroDAO = new CarroDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("IND-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		Assert.assertEquals(veiculo.getVendido(), "false");
		
		controladorPagamento.venderCarro(veiculo);
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("IND-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		Assert.assertEquals(veiculo.getVendido(), "true");
		
		veiculo.setVendido("false");
		carroDAO.atualizarVeiculo(veiculo);
	}
	
}
