package br.model;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


public class PessoaDAO extends AbstractDAO
{
	public PessoaDAO()
	{
		criarEntityManager("Pessoa");
	}
	
	public void persistirPessoa(Pessoa pessoa)
	{
		pessoa.setPessoaOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();

		entityManager.close();
	}

	public Pessoa recuperarPessoaPorCPF(String cpf)
	{
		String query = "select * from Pessoa where cpf = :cpf";
		
		Pessoa pessoa = (Pessoa) entityManager.createNativeQuery(query, Pessoa.class).setParameter("cpf", cpf).getSingleResult();
		
		return pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> recuperarPessoasPorCPF(String cpf)
	{
		String query = "select * from Pessoa where cpf = :cpf";
		
		List<Pessoa> listaPessoas = entityManager.createNativeQuery(query, Pessoa.class).setParameter("cpf", cpf).getResultList();
		
		return listaPessoas;
				
	}
	
	public List<Pessoa> recuperarTodasPessoas()
	{
		List<Pessoa> resultado;
		
		TypedQuery<Pessoa> query = entityManager.createQuery("select p from Pessoa p", Pessoa.class);
		resultado = query.getResultList();
		
		return resultado;
	}

	public void apagarPessoaAdicinadaNoTestePorCPF(String cpf)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		String query = "delete from Pessoa where cpf = :cpf";
		entityManager.createNativeQuery(query, Pessoa.class).setParameter("cpf", cpf).executeUpdate();
		
		transaction.commit();
	}
	
	
}
