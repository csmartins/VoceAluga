package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorInformacoesCliente;
import br.model.ListaNegraDAO;
import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorInformacoesClienteFunctionalTest extends FunctionalTest
{
	private ControladorInformacoesCliente controladorInformacoesCliente;
	private PessoaDAO pessoaDAO;
	private ListaNegraDAO listaNegraDAO;
	
	@Test
	public void testControladorInformacoesCliente_AdicionarListaNegra_ClienteDeveAparecerNaListaNegra()
	{
		pessoaDAO = new PessoaDAO();
		listaNegraDAO = new ListaNegraDAO();
		
		Pessoa cliente = pessoaDAO.recuperarPessoaPorCPF("444444");
		
		controladorInformacoesCliente = new ControladorInformacoesCliente(cliente);
		
		Assert.assertFalse(listaNegraDAO.isPessoaNaListaNegra(cliente));
		
		controladorInformacoesCliente.adicionarListaNegra();
		
		listaNegraDAO = new ListaNegraDAO();
		
		Assert.assertTrue(listaNegraDAO.isPessoaNaListaNegra(cliente));
		
		controladorInformacoesCliente.removerClienteListaNegra();
	}
	
	@Test
	public void testControladorInformacoesCliente_RemoverListaNegra_ClienteNaoDeveAparecerNaListaNegra()
	{
		pessoaDAO = new PessoaDAO();
		listaNegraDAO = new ListaNegraDAO();
		
		Pessoa cliente = pessoaDAO.recuperarPessoaPorCPF("444444");
		
		controladorInformacoesCliente = new ControladorInformacoesCliente(cliente);
		
		controladorInformacoesCliente.adicionarListaNegra();
		
		Assert.assertTrue(listaNegraDAO.isPessoaNaListaNegra(cliente));
		
		controladorInformacoesCliente.removerClienteListaNegra();

		listaNegraDAO = new ListaNegraDAO();
		
		Assert.assertFalse(listaNegraDAO.isPessoaNaListaNegra(cliente));
	}
	
}
