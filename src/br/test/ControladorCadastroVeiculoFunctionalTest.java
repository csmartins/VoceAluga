package br.test;

import java.util.Date;

import static org.mockito.Mockito.*;
import org.testng.annotations.Test;

import br.action.ControladorCadastroVeiculo;
import br.model.AbstractDAO;

public class ControladorCadastroVeiculoFunctionalTest
{
	private ControladorCadastroVeiculo controladorCadastroVeiculo = new ControladorCadastroVeiculo();
	
	@Test
	public void testCadastrarVeiculo_DeveCadastrarComSucesso()
	{
		String marca = "Ford";
		String modelo = "Fusion";
		String placa = "ABC-1234";
		int ano = 2014;
		Date ultimaManutencao = new Date();
		boolean disponivel = true;
		
		AbstractDAO mockAbstractDAO = mock(AbstractDAO.class);
		when(mockAbstractDAO.criarOid()).thenReturn("00000000-0000-0000-0000-000000000001");
		controladorCadastroVeiculo.cadastrar(marca, placa, modelo, ano, ultimaManutencao, disponivel);
		
	}
}
