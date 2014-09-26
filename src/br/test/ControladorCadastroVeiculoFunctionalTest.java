package br.test;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.testng.annotations.Test;

import br.action.ControladorCadastroVeiculo;
import br.model.AbstractDAO;

public class ControladorCadastroVeiculoFunctionalTest extends FunctionalTest
{
	private ControladorCadastroVeiculo controladorCadastroVeiculo;
	
	@Test
	public void testCadastrarVeiculo_DeveCadastrarComSucesso()
	{
		controladorCadastroVeiculo = new ControladorCadastroVeiculo();
		String marca = "Fiat";
		String modelo = "Doblo";
		String placa = "ABC-1234";
		int ano = 2014;
		Date ultimaManutencao = new Date();
		boolean disponivel = true;
		String preco = "50000.00";
		String diaria = "100.00";
		
		AbstractDAO mockAbstractDAO = mock(AbstractDAO.class);
		when(mockAbstractDAO.criarOid()).thenReturn("00000000-0000-0000-0000-000000000001");
		doCallRealMethod().when(mockAbstractDAO).criarEntityManager("Carro");
		
		controladorCadastroVeiculo.cadastrar(marca, placa, modelo, ano, ultimaManutencao, disponivel, preco, diaria);
		
		//TODO implementar classe FunctionalTest como fazemos no siga para usar o find do entityManager

	}
}
