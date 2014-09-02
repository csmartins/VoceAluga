package br.action;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.model.Pessoa;

public class ControladorCadastroCliente
{
	ValidadorDadosCadastro validadorDadosCadastro = new ValidadorDadosCadastro();

	private boolean cadastroValido = true;
	
	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	
	public void validarNome(String nome)
	{
		if(!validadorDadosCadastro.validarNome(nome))
		{
			JOptionPane.showMessageDialog(null, "Nome deve mais de 3 letras.");
			cadastroValido = false;
		}
		
	}

	public void validarCpf(String cpf)
	{
		if(!validadorDadosCadastro.validarCpf(cpf))
		{
			JOptionPane.showMessageDialog(null, "CPF deve conter apenas digitos e tamanho máximo de 11 caracteres.");
			cadastroValido = false;
		}
		
	}
	
	public void validarRg(String rg)
	{
		if(!validadorDadosCadastro.validarRG(rg))
		{
			JOptionPane.showMessageDialog(null, "RG deve conter apenas números.");
			cadastroValido = false;
		}
	}

	public void validarTelefone(String telefone)
	{
		if(!validadorDadosCadastro.validarTelefone(telefone))
		{
			JOptionPane.showMessageDialog(null, "Telefone inválido, o telefone deve ser da forma 99999999.");
			cadastroValido = false;
		}
		
	}

	public void validarEmail(String email)
	{
		if(!validadorDadosCadastro.validarEmail(email))
		{
			JOptionPane.showMessageDialog(null, "Email inválido, email deve ser da forma 'exemplo@exemplo.com'.");
			cadastroValido = false;
		}
		
	}

	public void validarCarteira(String carteira)
	{
		if(!validadorDadosCadastro.validarCarteira(carteira))
		{
			JOptionPane.showMessageDialog(null, "Insira uma carteira de motorista.");
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

	public void cadastrar(String nome, String cpf, String rg,
			String carteira, String categoriaCarteira, String telefone, String email)
	{
		int oid = new Random().nextInt();
		
		if(oid < 0)
			oid = oid * (-1);
		
		
		Pessoa cliente = new Pessoa(oid, nome, cpf, rg, carteira, categoriaCarteira.toCharArray()[0], telefone, email);
		
		entityManagerFactory = Persistence.createEntityManagerFactory("Pessoa");
		entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
}
