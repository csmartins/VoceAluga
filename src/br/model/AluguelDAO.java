package br.model;

public class AluguelDAO extends AbstractDAO 
{
	public AluguelDAO()
	{
		criarEntityManager("Aluguel");
	}
	
	public void persistirAluguel(Aluguel aluguel)
	{
		aluguel.setAluguelOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(aluguel);
		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
	
}
