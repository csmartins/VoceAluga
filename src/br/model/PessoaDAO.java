package br.model;


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
	
	
}
