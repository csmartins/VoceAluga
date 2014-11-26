package br.model;

import javax.persistence.EntityTransaction;

public class ManutencaoDAO extends AbstractDAO
{
	public ManutencaoDAO()
	{
		criarEntityManager("Manutencao");
	}

	public void persistirManutencao(Manutencao manutencao)
	{
		manutencao.setManutencaoOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(manutencao);
		entityManager.getTransaction().commit();

		refresh("Manutencao");
		
		entityManager.close();
		
	}

	public void removerManutencao(String carroOid)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		String query = "delete from Manutencao where carro_oid = :carro";
		entityManager.createNativeQuery(query, Carro.class).setParameter("carro", carroOid).executeUpdate();
		
		transaction.commit();
	}
	
	public Manutencao recuperarManutencaoPorCarro(String carroOid)
	{
		String query = "select * from Manutencao where carro_oid = :carro";
		Manutencao manutencao = (Manutencao) entityManager.createNativeQuery(query, Manutencao.class).setParameter("carro", carroOid).getSingleResult();
		
		return manutencao;
	}
}
