package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ValidadorDadosCadastroCliente;

public class ValidadorDadosCadastroClienteUnitTest
{
	private ValidadorDadosCadastroCliente validadorDadosCadastroCliente = new ValidadorDadosCadastroCliente();

	@Test
	public void testValidarNome_NomeComMaisDe3Letras_DeveRetornarTrue()
	{
		String nome = "Carlos";

		Assert.assertTrue(validadorDadosCadastroCliente.validarNome(nome));
	}

	@Test
	public void testValidarNome_NomeComMenosDe3Letras_DeveRetornarFalse()
	{
		String nome = "Ca";

		Assert.assertFalse(validadorDadosCadastroCliente.validarNome(nome));
	}

	@Test
	public void testValidarNome_NomeNaoPodeTerNumeros_DeveRetornarFalse()
	{
		String nome = "Carlos123";

		Assert.assertFalse(validadorDadosCadastroCliente.validarNome(nome));
	}

	@Test
	public void testValidarNome_NomeNulo_DeveRetornarFalse()
	{
		String nome = null;

		Assert.assertFalse(validadorDadosCadastroCliente.validarNome(nome));
	}

	@Test
	public void testValidarCPF_CPFComLetras_DeveRetornarFalse()
	{
		String cpf = "abc123";

		Assert.assertFalse(validadorDadosCadastroCliente.validarCpf(cpf));
	}

	@Test
	public void testValidarCPF_CPFSemLetras_DeveRetornarTrue()
	{
		String cpf = "123456";

		Assert.assertTrue(validadorDadosCadastroCliente.validarCpf(cpf));
	}

	@Test
	public void testValidarCPF_CPFNulo_DeveRetornarFalse()
	{
		String cpf = null;

		Assert.assertFalse(validadorDadosCadastroCliente.validarCpf(cpf));
	}

	@Test
	public void testValidarCPF_CPFComMaisDe11Caracteres_DeveRetornarFalse()
	{
		String cpf = "111111111111";

		Assert.assertFalse(validadorDadosCadastroCliente.validarCpf(cpf));
	}

	@Test
	public void testValidarRG_RGComLetras_DeveRetornarFalse()
	{
		String rg = "abc123";

		Assert.assertFalse(validadorDadosCadastroCliente.validarRG(rg));
	}

	@Test
	public void testValidarRG_RGSemLetras_DeveRetornarTrue()
	{
		String rg = "123456";

		Assert.assertTrue(validadorDadosCadastroCliente.validarRG(rg));
	}

	@Test
	public void testValidarRG_RGNulo_DeveRetornarFalse()
	{
		String rg = null;

		Assert.assertFalse(validadorDadosCadastroCliente.validarRG(rg));
	}

	@Test
	public void testValidarTelefone_TelefoneComLetras_DeveRetornarFalse()
	{
		String telefone = "abc123";

		Assert.assertFalse(validadorDadosCadastroCliente
				.validarTelefone(telefone));
	}

	@Test
	public void testValidarTelefone_TelefoneSemLetras_DeveRetornarTrue()
	{
		String telefone = "12345678";

		Assert.assertTrue(validadorDadosCadastroCliente
				.validarTelefone(telefone));
	}

	@Test
	public void testValidarTelefone_TelefoneNulo_DeveRetornarFalse()
	{
		String telefone = null;

		Assert.assertFalse(validadorDadosCadastroCliente
				.validarTelefone(telefone));
	}

	@Test
	public void testValidarTelefone_TelefoneComMaisDe8Caracteres_DeveRetornarFalse()
	{
		String telefone = "111111111111";

		Assert.assertFalse(validadorDadosCadastroCliente
				.validarTelefone(telefone));
	}

	@Test
	public void testValidarEmail_EmailCorreto_DeveRetornarTrue()
	{
		String email = "carlos@email.com";

		Assert.assertTrue(validadorDadosCadastroCliente.validarEmail(email));
	}

	@Test
	public void testValidarEmail_EmailInvalido_DeveRetornarFalse()
	{
		String email = "blablabla";

		Assert.assertFalse(validadorDadosCadastroCliente.validarEmail(email));
	}
	
	@Test
	public void testValidarCarteira_CarteiraComLetras_DeveRetornarFalse()
	{
		String carteira = "abc123";

		Assert.assertFalse(validadorDadosCadastroCliente.validarCarteira(carteira));
	}

	@Test
	public void testValidarCarteira_CarteiraSemLetras_DeveRetornarTrue()
	{
		String carteira = "123456";

		Assert.assertTrue(validadorDadosCadastroCliente.validarCarteira(carteira));
	}

	@Test
	public void testValidarCarteira_CarteiraNulo_DeveRetornarFalse()
	{
		String carteira = null;

		Assert.assertFalse(validadorDadosCadastroCliente.validarCarteira(carteira));
	}
}
