package br.test;

import java.util.Date;

import org.testng.annotations.Test;

import br.action.ControladorCadastroVeiculo;

public class ControladorCadastroVeiculoFunctionalTest
{
	ControladorCadastroVeiculo controladorCadastroVeiculo = new ControladorCadastroVeiculo();
	
	@Test
	public void testCadastrarVeiculo_DeveCadastrarComSucesso()
	{
		String marca = "Ford";
		String modelo = "Fusion";
		String placa = "ABC-1234";
		int ano = 2014;
		Date ultimaManutencao = new Date();
		boolean disponivel = true;
		
		controladorCadastroVeiculo.cadastrar(marca, placa, modelo, ano, ultimaManutencao, disponivel);
		
	}
}
