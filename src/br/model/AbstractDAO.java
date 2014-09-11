package br.model;

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
}
