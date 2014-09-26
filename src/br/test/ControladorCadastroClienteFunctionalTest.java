package br.test;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.testng.annotations.Test;

import br.action.ControladorCadastroCliente;
import br.model.AbstractDAO;
import br.model.PessoaDAO;

public class ControladorCadastroClienteFunctionalTest extends FunctionalTest
{
	private ControladorCadastroCliente controladorCadastroCliente;
	
	private PessoaDAO pessoaDAO;
	
	@Test
	public void testCadastrarCliente_CadastrarComSucesso_ClienteDeveEstarNoBanco()
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		AbstractDAO mockAbstractDAO = mock(AbstractDAO.class);
		when(mockAbstractDAO.criarOid()).thenReturn("00000000-0000-0000-0000-000000000001");
		doCallRealMethod().when(mockAbstractDAO).criarEntityManager("Pessoa");
		
		controladorCadastroCliente.cadastrar("Ana Mel da Cohab", "12345678", "11111111", "11111", "A", "11111111", "emaildaanamel@email.com");
		
		//TODO implementar classe FunctionalTest como fazemos no siga para usar o find do entityManager
	}
}
