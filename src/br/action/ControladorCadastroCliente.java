package br.action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.model.Pessoa;
import br.model.PessoaDAO;

public class ControladorCadastroCliente
{
	private ValidadorDadosCadastroCliente validadorDadosCadastro = new ValidadorDadosCadastroCliente();
	
	private PessoaDAO pessoaDAO = new PessoaDAO();

	private boolean cadastroValido = true;
	
	private ArrayList<String> mensagensCadastro;

	public ControladorCadastroCliente()
	{
		pessoaDAO = new PessoaDAO();
		
		cadastroValido = true;
		
		mensagensCadastro = new ArrayList<String>();
	}
	
	public void validarNome(String nome)
	{
		if (!validadorDadosCadastro.validarNome(nome))
		{
			mensagensCadastro.add("Nome deve mais de 3 letras");
			cadastroValido = false;
		}

	}

	public void validarCpf(String cpf)
	{
		if(!verificarCPF(cpf))
		{
			mensagensCadastro.add("\nJá existe um usuário com esse cpf");
			cadastroValido = false;
			return;
		}
		
		if (!validadorDadosCadastro.validarCpf(cpf))
		{
			mensagensCadastro.add("\nCPF deve conter apenas digitos e tamanho máximo de 11 caracteres");
			cadastroValido = false;
		}

	}

	public void validarRg(String rg)
	{
		if (!validadorDadosCadastro.validarRG(rg))
		{
			mensagensCadastro.add("\nRG deve conter apenas números");
			cadastroValido = false;
		}
	}

	public void validarTelefone(String telefone)
	{
		if (!validadorDadosCadastro.validarTelefone(telefone))
		{
			mensagensCadastro.add("\nTelefone inválido, o telefone deve ser da forma 99999999");
			cadastroValido = false;
		}

	}

	public void validarEmail(String email)
	{
		if (!validadorDadosCadastro.validarEmail(email))
		{
			mensagensCadastro.add("\nEmail inválido, email deve ser da forma 'exemplo@exemplo.com'");
			cadastroValido = false;
		}

	}

	public void validarCarteira(String carteira)
	{
		if (!validadorDadosCadastro.validarCarteira(carteira))
		{
			mensagensCadastro.add("\nInsira uma carteira de motorista");
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
		Pessoa cliente = new Pessoa(nome, cpf, rg, carteira,
				categoriaCarteira.toCharArray()[0], telefone, email);
		
		pessoaDAO.persistirPessoa(cliente);
	}

	public boolean verificarCPF(String cpf)
	{
		List<Pessoa> listaPessoas = pessoaDAO.recuperarPessoasPorCPF(cpf);
		
		if(listaPessoas.isEmpty())
			return true;
		
		else
			return false;
	}

	public ArrayList<String> getMensagensCadastro()
	{
		return mensagensCadastro;
	}

	public void setMensagensCadastro(ArrayList<String> mensagensCadastro)
	{
		this.mensagensCadastro = mensagensCadastro;
	}
}
