package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ValidadorDadosReservaVeiculo;

public class ValidadorDadosReservaVeiculoFunctionalTest extends FunctionalTest
{
	private ValidadorDadosReservaVeiculo validadorDadosReservaVeiculo = new ValidadorDadosReservaVeiculo();
	
	@Test
	public void testValidadorDadosReservaVeiculo_ValidarMarcaEModelo_DadosCorretos_DeveRetornarTrue()
	{
		String marca = "Marca Teste";
		String modelo = "Teste";
		
		Assert.assertTrue(validadorDadosReservaVeiculo.validarExistenciaDeVeiculoParaMarcaEModelo(marca, modelo));
	}
	
	@Test
	public void testValidadorDadosReservaVeiculo_ValidarMarcaEModelo_DadosIncorretos_DeveRetornarFalse()
	{
		String marca = "Fiat";
		String modelo = "Golf";
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarExistenciaDeVeiculoParaMarcaEModelo(marca, modelo));
	}
}
