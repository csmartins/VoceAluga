package br.model;

public class CarroDAO extends AbstractDAO
{

	public void persistirVeiculo(Carro veiculo)
	{
		veiculo.setCarroOid(criarOid());
		
		criarEntityManager("Carro");
		
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
