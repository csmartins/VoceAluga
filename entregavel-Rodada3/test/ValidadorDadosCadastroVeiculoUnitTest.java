package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ValidadorDadosCadastroVeiculo;

public class ValidadorDadosCadastroVeiculoUnitTest
{

	private ValidadorDadosCadastroVeiculo validadorDadosCadastroVeiculo = new ValidadorDadosCadastroVeiculo();
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarModelo_ModeloNaoNulo_DeveRetornarTrue()
	{
		String modelo = "Fusion";
		
		Assert.assertTrue(validadorDadosCadastroVeiculo.validarModelo(modelo));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarModelo_ModeloNulo_DeveRetornarFalse()
	{
		String modelo = null;
		
		Assert.assertFalse(validadorDadosCadastroVeiculo.validarModelo(modelo));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarMarca_MarcaNaoNula_DeveRetornarTrue()
	{
		String marca = "Ford";
		
		Assert.assertTrue(validadorDadosCadastroVeiculo.validarMarca(marca));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarMarca_MarcaNula_DeveRetornarFalse()
	{
		String marca = null;
		
		Assert.assertFalse(validadorDadosCadastroVeiculo.validarMarca(marca));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarPlaca_PlacaNaoNUla_DeveRetornarTrue()
	{
		String placa = "ABC-1234";
		
		Assert.assertTrue(validadorDadosCadastroVeiculo.validarPlaca(placa));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarPlaca_PlacaNUla_DeveRetornarFalse()
	{
		String placa = null;
		
		Assert.assertFalse(validadorDadosCadastroVeiculo.validarPlaca(placa));
	}
	
	@Test
	public void testValidadorDadosCadastroVeiculo_ValidarDataUltimaManutencao_DataNoFuturo_DeveRetornarFalse()
	{
	}
	
}
