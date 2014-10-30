package br.test;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import br.action.ControladorCadastroCliente;
import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorCadastroClienteFunctionalTest extends FunctionalTest
{
	private ControladorCadastroCliente controladorCadastroCliente;
	
	private PessoaDAO pessoaDAO;
	
	@Test
	public void testCadastrarCliente_CadastrarComSucesso_ClienteDeveEstarNoBanco()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		pessoaDAO = new PessoaDAO();
		
		controladorCadastroCliente.cadastrar("Ana Mel da Cohab", "12345678", "11111111", "11111", "A", "11111111", "emaildaanamel@email.com");
		
		Pessoa pessoa = pessoaDAO.recuperarPessoaPorCPF("12345678");
		
		assertEquals(pessoa.getNome(), "Ana Mel da Cohab");
		assertEquals(pessoa.getCpf(), "12345678");
		assertEquals(pessoa.getRg(), "11111111");
		assertEquals(pessoa.getCarteira(), "11111");
		assertEquals(pessoa.getCategoriaCarteira().toString(), "A");
		assertEquals(pessoa.getTelefone(), "11111111");
		assertEquals(pessoa.getEmail(), "emaildaanamel@email.com");
		
		limparPessoaAdicionadaPorCPF("12345678");
	}
	
	@Test
	public void testVerificarCPF_CPFNaoExisteNoBanco_DeveRetornarTrue()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		
		assertTrue(controladorCadastroCliente.verificarCPF("123123123"));
	}
	
	@Test
	public void testVerificarCPF_CPFExisteNoBanco_DeveRetornarFalse()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		
		assertFalse(controladorCadastroCliente.verificarCPF("11111111111"));
	}
	
	@Test
	public void testValidarCPF_CPFExisteNoBanco_DeveInserirUmaMensagemNoBundle()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		
		controladorCadastroCliente.validarCpf("11111111111");
		
		assertTrue(controladorCadastroCliente.getMensagensCadastro().contains("\nJá existe um usuário com esse cpf"));
		
		assertFalse(controladorCadastroCliente.isCadastroValido());
	}
	
	@Test
	public void testValidarCPF_CPFNaoExisteNoBanco_NaoDeveInserirUmaMensagemNoBundle()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		
		controladorCadastroCliente.validarCpf("123123123");
		
		assertFalse(controladorCadastroCliente.getMensagensCadastro().contains("\nJá existe um usuário com esse cpf"));
		
		assertTrue(controladorCadastroCliente.isCadastroValido());
	}
}
