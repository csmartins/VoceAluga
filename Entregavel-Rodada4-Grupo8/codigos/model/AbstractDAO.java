package br.model;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO
{
	public EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;

	public void criarEntityManager(String entidade)
	{
		entityManagerFactory = Persistence.createEntityManagerFactory(entidade);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public String criarOid()
	{
		UUID oid = UUID.randomUUID();
		
		return oid.toString();
	}
	
	public void refresh(String entidade)
	{
		entityManager.close();
		criarEntityManager(entidade);
	}
}
