package br.action;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorCadastroCliente
{
	ValidadorDadosCadastro validadorDadosCadastro = new ValidadorDadosCadastro();
	
	PessoaDAO pessoaDAO = new PessoaDAO();

	private boolean cadastroValido = true;

	public void validarNome(String nome)
	{
		if (!validadorDadosCadastro.validarNome(nome))
		{
			JOptionPane.showMessageDialog(null, "Nome deve mais de 3 letras.");
			cadastroValido = false;
		}

	}

	public void validarCpf(String cpf)
	{
		if (!validadorDadosCadastro.validarCpf(cpf))
		{
			JOptionPane
					.showMessageDialog(null,
							"CPF deve conter apenas digitos e tamanho máximo de 11 caracteres.");
			cadastroValido = false;
		}

	}

	public void validarRg(String rg)
	{
		if (!validadorDadosCadastro.validarRG(rg))
		{
			JOptionPane.showMessageDialog(null,
					"RG deve conter apenas números.");
			cadastroValido = false;
		}
	}

	public void validarTelefone(String telefone)
	{
		if (!validadorDadosCadastro.validarTelefone(telefone))
		{
			JOptionPane
					.showMessageDialog(null,
							"Telefone inválido, o telefone deve ser da forma 99999999.");
			cadastroValido = false;
		}

	}

	public void validarEmail(String email)
	{
		if (!validadorDadosCadastro.validarEmail(email))
		{
			JOptionPane
					.showMessageDialog(null,
							"Email inválido, email deve ser da forma 'exemplo@exemplo.com'.");
			cadastroValido = false;
		}

	}

	public void validarCarteira(String carteira)
	{
		if (!validadorDadosCadastro.validarCarteira(carteira))
		{
			JOptionPane.showMessageDialog(null,
					"Insira uma carteira de motorista.");
			cadastroValido = false;
		}

	}

	public boolean isCadastroValido()
	{
		return cadastroValido;
	}

	public void setCadastroValido(boolean cadastroValido)
	{
		this.cadastroValido = cadastroValido;
	}

	public void cadastrar(String nome, String cpf, String rg, String carteira,
			String categoriaCarteira, String telefone, String email)
	{
		Pessoa cliente = new Pessoa(0, nome, cpf, rg, carteira,
				categoriaCarteira.toCharArray()[0], telefone, email);
		
		pessoaDAO.persistirPessoa(cliente);
	}
}
