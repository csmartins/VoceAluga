package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorReservaVeiculoPorModelo;
import br.model.Carro;

public class ControladorReservaVeiculoPorModeloFunctionalTest extends FunctionalTest
{
	private ControladorReservaVeiculoPorModelo controladorReservaVeiculoPorModelo;
	
	@Test
	public void testControladorReservaVeiculoPorModelo_PopularVeiculo_MaisDeUmVeiculoDaMesmaMarcaEModelo_DeveEscolherQualquerUm()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();

		String marca = "Fiat";
		String modelo = "Doblo";
		
		controladorReservaVeiculoPorModelo.popularVeiculo(marca, modelo);
		
		Carro veiculo = controladorReservaVeiculoPorModelo.getVeiculo();
		
		Assert.assertNotNull(veiculo);
		Assert.assertEquals(marca, veiculo.getMarca());
	}
	
	@Test
	public void testControladorReservaVeiculoPorModelo_NenhumCarroDisponivelParaMarcaEModelo_NaoDeveFazerReserva()
	{
		
	}
}