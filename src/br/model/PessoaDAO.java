package br.model;

import java.util.Random;

public class PessoaDAO extends AbstractDAO
{
	
	public void persistirPessoa(Pessoa pessoa)
	{
		pessoa.setPessoaOid(criarOid());
		
		criarEntityManager("Pessoa");

		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
	private int criarOid()
	{
		int oid = new Random().nextInt();

		if (oid < 0)
			oid = oid * (-1);
		
		return oid;
	}
}
