package br.test;

import org.junit.Assert;
import org.junit.Test;

import br.action.ControladorCadastroVeiculo;

public class ControladorCadastroVeiculoUnitTest
{
	private ControladorCadastroVeiculo controladorCadastroVeiculo = new ControladorCadastroVeiculo();
	
	@Test
	public void testControladorCadastroVeiculo_DadosNaoNulos_CadastroValidoDeveSerTrue()
	{
		String marca = "Ford";
		String modelo = "Fusion";
		String placa = "ABC-1234";
		
		controladorCadastroVeiculo.validarMarca(marca);
		controladorCadastroVeiculo.validarModelo(modelo);
		controladorCadastroVeiculo.validarPlaca(placa);
		
		Assert.assertTrue(controladorCadastroVeiculo.isCadastroValido());
	}
	
	@Test
	public void testControladorCadastroVeiculo_MarcaNula_CadastroValidoDeveSerFalse()
	{
		String marca = null;
		String modelo = "Fusion";
		String placa = "ABC-1234";
		
		controladorCadastroVeiculo.validarMarca(marca);
		controladorCadastroVeiculo.validarModelo(modelo);
		controladorCadastroVeiculo.validarPlaca(placa);
		
		Assert.assertFalse(controladorCadastroVeiculo.isCadastroValido());
	}
	
	@Test
	public void testControladorCadastroVeiculo_ModeloNula_CadastroValidoDeveSerFalse()
	{
		String marca = "Ford";
		String modelo = null;
		String placa = "ABC-1234";
		
		controladorCadastroVeiculo.validarMarca(marca);
		controladorCadastroVeiculo.validarModelo(modelo);
		controladorCadastroVeiculo.validarPlaca(placa);
		
		Assert.assertFalse(controladorCadastroVeiculo.isCadastroValido());
	}
	
	@Test
	public void testControladorCadastroVeiculo_PlacaNula_CadastroValidoDeveSerFalse()
	{
		String marca = "Ford";
		String modelo = "Fusion";
		String placa = null;
		
		controladorCadastroVeiculo.validarMarca(marca);
		controladorCadastroVeiculo.validarModelo(modelo);
		controladorCadastroVeiculo.validarPlaca(placa);
		
		Assert.assertFalse(controladorCadastroVeiculo.isCadastroValido());
	}
}
