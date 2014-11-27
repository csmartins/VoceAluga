package br.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaCliente;
import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorConsultaClienteFunctionalTest extends FunctionalTest
{
	private ControladorConsultaCliente controladorConsultaCliente;
	private PessoaDAO pessoaDAO;
	
	@Test
	public void testControladorConsultaCliente_FiltrarClientes_CPFNulo()
	{
		controladorConsultaCliente = new ControladorConsultaCliente();
		pessoaDAO = new PessoaDAO();
		
		String cpf = null;
		
		List<Pessoa> listaPessoas = pessoaDAO.recuperarTodasPessoas();
		int totalPessoas = listaPessoas.size();
		
		controladorConsultaCliente.filtrarClientes(cpf);
		
		Assert.assertEquals(controladorConsultaCliente.getTextoClientes().size(), totalPessoas);
		
	}
	
	@Test
	public void testControladorConsultaCliente_FiltrarClientes_CPFNaoNulo()
	{
		controladorConsultaCliente = new ControladorConsultaCliente();
		pessoaDAO = new PessoaDAO();
		
		String cpf = "444444";
		
		List<Pessoa> listaPessoas = pessoaDAO.recuperarPessoasPorCPF(cpf);
		int totalPessoas = listaPessoas.size();
		
		controladorConsultaCliente.filtrarClientes(cpf);
		
		Assert.assertEquals(controladorConsultaCliente.getPessoas().size(), totalPessoas);
		
	}
	
	
}
