package br.model;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;



public class CarroDAO extends AbstractDAO
{

	public CarroDAO()
	{
		criarEntityManager("Carro");
	}
	
	public void persistirVeiculo(Carro veiculo)
	{
		veiculo.setCarroOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
	public Carro recuperarCarroPorPlaca(String placa)
	{
		
		String query = "select * from Carro c where c.placa = :placa";
		Carro carro = (Carro) entityManager.createNativeQuery(query, Carro.class).setParameter("placa", placa).getSingleResult();
		
		return carro;
	}
	
	public void apagarCarroAdicionadoNoTestePorPlaca(String placa)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		String query = "delete from Carro where placa = :placa";
		entityManager.createNativeQuery(query, Carro.class).setParameter("placa", placa).executeUpdate();
		
		transaction.commit();
	}

	public List<Object> recuperarCarrosDisponiveisPorGrupo()
	{
		String query = "select * from Carro";
		List<Object> listaCarro = entityManager.createNativeQuery(query).getResultList();
		return listaCarro;
	}

	public Carro recuperarCarroDisponivelPorMarcaEModelo(String marca, String modelo)
	{
		String query = "select * from Carro c where c.marca = :marca and c.modelo = :modelo and c.disponivel = 'true' limit 1";
		
		Carro veiculo = (Carro) entityManager.createNativeQuery(query, Carro.class).setParameter("marca", marca).setParameter("modelo", modelo).getSingleResult();
		
		return veiculo;
		
	}
	
	public List<Carro> recuperarTodosCarros()
	{
		List<Carro> resultado;
		
		TypedQuery<Carro> query = entityManager.createQuery("select c from Carro c", Carro.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public List<Carro> recuperarCarrosDisponiveis()
	{
		List<Carro> resultado;
		
		TypedQuery<Carro> query = entityManager.createQuery("select c from Carro c where c.disponivel = 'true'", Carro.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public List<Carro> recuperarCarrosPorModelo(String modelo)
	{
		List<Carro> resultado;
		
		String queryString = "select c from Carro c where c.modelo = '" + modelo + "'";
		
		TypedQuery<Carro> query = entityManager.createQuery(queryString, Carro.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public List<Carro> recuperarCarrosDisponiveisPorModelo(String modelo)
	{
		List<Carro> resultado;
		
		String queryString = "select c from Carro c where c.modelo = '" + modelo + "' and c.disponivel = 'true'";
		
		TypedQuery<Carro> query = entityManager.createQuery(queryString, Carro.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public void atualizarVeiculo(Carro veiculo)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.merge(veiculo);
		
		transaction.commit();
	}

	public void disponibilizarCarro(Carro veiculo)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.merge(veiculo);
		
		transaction.commit();
	}
}
