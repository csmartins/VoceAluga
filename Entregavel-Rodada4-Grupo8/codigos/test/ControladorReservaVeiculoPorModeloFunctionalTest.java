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
	public void testControladorReservaVeiculoPorModelo_Cadastrar_VeiculoDeveEstarDisponivelDepoisDeEfetuarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		carroDAO = new CarroDAO();
		
		String marca = "Marca Teste";
		String modelo = "Teste";
		String placa = "TST-1234";
		String cpf = "444444";
		
		controladorReservaVeiculoPorModelo.cadastrar(cpf, marca, modelo, new Date(), new Date());
		
		Carro carro = carroDAO.recuperarCarroPorPlaca(placa);
		
		assertEquals(carro.getDisponivel(), "true");
		
		limparReservaPorCPFMarcaEModelo(cpf, marca, modelo);
	}
	
	@Test
	public void testControladorReservaVeiculoPorModelo_NenhumCarroDisponivelParaMarcaEModelo_NaoDeveFazerReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String marca = "Marca Inexistente";
		String modelo = "Veiculo Inexistente";
		
		controladorReservaVeiculoPorModelo.validarMarcaEModelo(marca, modelo);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nNão existe um carro disponivel para essa marca e modelo. Entre em contato com outra filial"));
	}
	
	@Test
	public void testValidarCPF_CPFNaoInserido_DeveInvalidarReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String cpf = "";
		
		controladorReservaVeiculoPorModelo.validarCPF(cpf);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nDigite o cpf do cliente que está reservando este veículo"));
	}
	
	@Test
	public void testValidarModelo_ModeloNaoInserido_DeveInvalidarReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String modelo = "";
		
		controladorReservaVeiculoPorModelo.validarModelo(modelo);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nDigite o modelo do veículo a ser reservado"));
	}
	
	@Test
	public void testValidarMarca_MarcaNaoInserida_DeveInvalidarReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String marca = "";
		
		controladorReservaVeiculoPorModelo.validarMarca(marca);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nDigite a marca do veículo a ser reservado"));
	}
	
	@Test
	public void testControladorReservaVeiculo_VerificarClienteCadastrado_ClienteNaoCadastrado_DeveInvalidarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String cpf = "111";
		
		controladorReservaVeiculoPorModelo.verificarClienteCadastrado(cpf);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nEsse CPF não está cadastrado, por favor cadastre-o."));
	}
	
	@Test
	public void testControladorReservaVeiculo_VerificarClienteCadastrado_ClienteCadastrado_DeveValidarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String cpf = "444444";
		
		controladorReservaVeiculoPorModelo.verificarClienteCadastrado(cpf);
		
		assertTrue(controladorReservaVeiculoPorModelo.isReservaValida());
		
		assertFalse(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nEsse CPF não está cadastrado, por favor cadastre-o."));
	}
	
	@Test
	public void testControladorReservaVeiculo_VerificarClienteListaNegra_ClienteEstaNaListaNegra_DeveInvalidarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String cpf = "0809809";
		
		controladorReservaVeiculoPorModelo.verificarClienteNaListaNegra(cpf);
		
		assertFalse(controladorReservaVeiculoPorModelo.isReservaValida());
		
		assertTrue(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nEsse cliente possui irregularidades e está na Lista Negra, por favor resolva as irregularidades antes de efetuar uma reserva"));
	}
	
	@Test
	public void testControladorReservaVeiculo_VerificarClienteListaNegra_ClienteNaoEstaNaListaNegra_DeveValidarAReserva()
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		String cpf = "444444";
		
		controladorReservaVeiculoPorModelo.verificarClienteNaListaNegra(cpf);
		
		assertTrue(controladorReservaVeiculoPorModelo.isReservaValida());
		
		assertFalse(controladorReservaVeiculoPorModelo.getMensagensReserva().contains("\nEsse cliente possui irregularidades e está na Lista Negra, por favor resolva as irregularidades antes de efetuar uma reserva"));
	}

}