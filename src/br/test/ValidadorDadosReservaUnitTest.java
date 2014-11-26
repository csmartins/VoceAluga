package br.test;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ValidadorDadosReservaVeiculo;

public class ValidadorDadosReservaUnitTest
{
	ValidadorDadosReservaVeiculo validadorDadosReservaVeiculo = new ValidadorDadosReservaVeiculo();
	
	@Test
	public void testValidarCPF_CPFNulo_DeveRetornarFalse()
	{
		String cpf = null;
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarCPF(cpf));
	}
	
	@Test
	public void testValidarCPF_CPFNaoInserido_DeveRetornarFalse()
	{
		String cpf = "";
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarCPF(cpf));
	}
	
	@Test
	public void testValidarModelo_ModeloNulo_DeveRetornarFalse()
	{
		String modelo = null;
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarModelo(modelo));
	}
	
	@Test
	public void testValidarModelo_ModeloNaoInserido_DeveRetornarFalse()
	{
		String modelo = "";
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarModelo(modelo));
	}
	
	@Test
	public void testValidarMarca_MarcaNulo_DeveRetornarFalse()
	{
		String marca = null;
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarMarca(marca));
	}
	
	@Test
	public void testValidarMarca_MarcaNaoInserida_DeveRetornarFalse()
	{
		String marca = "";
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarMarca(marca));
	}
	
	@Test
	public void testValidarDataFim_DataFimNula_DeveRetornarFalse()
	{
		Date dataFim = null;
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarDataFim(dataFim));
	}
	
	@Test
	public void testValidarDataFim_DataInicioNula_DeveRetornarFalse()
	{
		Date dataInicio = null;
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarDataInicio(dataInicio));
	}
	
	@Test
	public void testValidarDataFim_DataFimAntesDaDataInicio_DeveRetornarFalse()
	{
		Date dataFim = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFim);
		calendar.add(Calendar.DATE, -1);
		
		dataFim = calendar.getTime();
		
		Assert.assertFalse(validadorDadosReservaVeiculo.validarDataFimDepoisDataInicio(new Date(), dataFim));
	}
	
	@Test
	public void testValidarDataFim_DataFimDepoisDaDataInicio_DeveRetornarFalse()
	{
		Date dataFim = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFim);
		calendar.add(Calendar.DATE, 1);
		
		dataFim = calendar.getTime();
		
		Assert.assertTrue(validadorDadosReservaVeiculo.validarDataFimDepoisDataInicio(new Date(), dataFim));
	}
	
}
