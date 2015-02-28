package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaCliente;
import br.model.Pessoa;

public class ControladorConsultaClienteUnitTest
{
	private ControladorConsultaCliente controladorConsultaCliente;
	
	@Test
	public void testControladorConsultaCliente_FormatarInformacoesCliente_DeveFormatarCPFENome()
	{
		controladorConsultaCliente = new ControladorConsultaCliente();
		
		Pessoa cliente = new Pessoa();
		cliente.setNome("Bla");
		cliente.setCpf("11111");
		
		String informacoesFormatadas = controladorConsultaCliente.formatarInformacoesCliente(cliente);
		
		Assert.assertEquals(informacoesFormatadas, "CPF: 11111 | Nome: Bla");
	}
	
}
