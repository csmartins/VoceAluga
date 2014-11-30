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
		
		controladorPagamento.venderCarro(veiculo, null);
		
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
		
		controladorPagamento.venderCarro(veiculo, null);
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("IND-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		Assert.assertEquals(veiculo.getVendido(), "true");
		
		veiculo.setVendido("false");
		carroDAO.atualizarVeiculo(veiculo);
	}
	
	@Test
	public void testControladorPagamento_VenderCarro_FormaPagamentoDinheiro_DeveSetarFormaDePagamentoParaDinheiro()
	{
		controladorPagamento = new ControladorPagamento();
		
		carroDAO = new CarroDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertNull(veiculo.getFormaPagamento());
		
		controladorPagamento.venderCarro(veiculo, "Dinheiro");
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getFormaPagamento(), "Dinheiro");
		
		veiculo.setVendido("false");
		veiculo.setDisponivel("true");
		veiculo.setFormaPagamento(null);
		carroDAO.atualizarVeiculo(veiculo);
	}
	
	@Test
	public void testControladorPagamento_VenderCarro_FormaPagamentoDebito_DeveSetarFormaDePagamentoParaDinheiro()
	{
		controladorPagamento = new ControladorPagamento();
		
		carroDAO = new CarroDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertNull(veiculo.getFormaPagamento());
		
		controladorPagamento.venderCarro(veiculo, "Débito À Vista");
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getFormaPagamento(), "Débito À Vista");
		
		veiculo.setVendido("false");
		veiculo.setDisponivel("true");
		veiculo.setFormaPagamento(null);
		carroDAO.atualizarVeiculo(veiculo);
	}
	
	@Test
	public void testControladorPagamento_VenderCarro_FormaPagamentoCreditoEmXVezes_DeveSetarFormaDePagamentoParaDinheiro()
	{
		controladorPagamento = new ControladorPagamento();
		
		carroDAO = new CarroDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertNull(veiculo.getFormaPagamento());
		
		controladorPagamento.venderCarroCredito(veiculo, "X");
		
		carroDAO = new CarroDAO();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getFormaPagamento(), "Crédito em X vezes");
		
		veiculo.setVendido("false");
		veiculo.setDisponivel("true");
		veiculo.setFormaPagamento(null);
		carroDAO.atualizarVeiculo(veiculo);
	}
}
