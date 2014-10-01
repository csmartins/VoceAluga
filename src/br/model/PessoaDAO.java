package br.model;


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
	
	
}
