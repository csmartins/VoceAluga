package br.test;

import static org.testng.Assert.*;

import java.util.Date;

import org.testng.annotations.Test;

import br.action.ControladorReservaVeiculoPorModelo;
import br.model.Carro;
import br.model.CarroDAO;

public class ControladorReservaVeiculoPorModeloFunctionalTest extends FunctionalTest
{
	private ControladorReservaVeiculoPorModelo controladorReservaVeiculoPorModelo;
	
	private CarroDAO carroDAO;
	
	@Test
	public void testControladorReservaVeiculoPorModelo_PopularVeiculo_MaisDeUmVeiculoDaMesmaMarcaEModelo_DeveEscolherQualquerUm()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();

		String marca = "Fiat";
		String modelo = "Doblo";
		
		controladorReservaVeiculoPorModelo.popularVeiculo(marca, modelo);
		
		Carro veiculo = controladorReservaVeiculoPorModelo.getVeiculo();
		
		assertNotNull(veiculo);
		assertEquals(marca, veiculo.getMarca());
	}
	
	@Test
	public void testControladorReservaVeiculoPorModelo_Cadastrar_VeiculoNaoDeveEstarDisponivelDepoisDeEfetuarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		carroDAO = new CarroDAO();
		
		String marca = "Marca Teste";
		String modelo = "Teste";
		String placa = "TST-1234";
		String cpf = "444444";
		
		controladorReservaVeiculoPorModelo.cadastrar(cpf, marca, modelo, new Date(), new Date());
		
		Carro carro = carroDAO.recuperarCarroPorPlaca(placa);
		
		assertEquals(carro.getDisponivel(), "false");
		
		limparReservaPorCPFMarcaEModelo(cpf, marca, modelo);
		
		carro.setDisponivel("true");
		
		carroDAO.atualizarVeiculo(carro);
	}
	
	@Test
	public void testControladorReservaVeiculoPorModelo_NenhumCarroDisponivelParaMarcaEModelo_NaoDeveFazerReserva()
	{
		
	}
}