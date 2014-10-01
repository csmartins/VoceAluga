package br.test;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.testng.annotations.Test;

import br.action.ControladorCadastroVeiculo;
import br.model.Carro;
import br.model.CarroDAO;

public class ControladorCadastroVeiculoFunctionalTest extends FunctionalTest
{
	private ControladorCadastroVeiculo controladorCadastroVeiculo;
	
	private CarroDAO carroDAO;
	
	@Test
	public void testCadastrarVeiculo_DeveCadastrarComSucesso() throws ParseException
	{
		controladorCadastroVeiculo = new ControladorCadastroVeiculo();
		carroDAO = new CarroDAO();
		String marca = "Fiat";
		String modelo = "Doblo";
		String placa = "PPP-1111";
		int ano = 2014;
		Date ultimaManutencao = new Date();
		boolean disponivel = true;
		String preco = "50000.00";
		String diaria = "100.00";
		
		controladorCadastroVeiculo.cadastrar(marca, placa, modelo, ano, ultimaManutencao, disponivel, preco, diaria);
		
		Carro carro = carroDAO.recuperarCarroPorPlaca(placa);
		
		assertEquals(marca, carro.getMarca());
		assertEquals(modelo, carro.getModelo());
		assertEquals(placa, carro.getPlaca());
		assertEquals(ano, carro.getAno());
		//assertEquals(ultimaManutencao, carro.getUltimaManutencao());
		assertEquals("true", carro.getDisponivel());
		assertEquals(diaria, carro.getDiaria().toString());
		assertEquals(preco, carro.getPreco().toString());
		
		limparCarroAdicionadoPorPlaca(placa);
	}
}
