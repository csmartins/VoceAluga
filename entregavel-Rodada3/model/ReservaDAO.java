package br.model;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ReservaDAO extends AbstractDAO
{
	
	public ReservaDAO()
	{
		criarEntityManager("Reserva");
	}
	
	public void persistirReserva(Reserva reserva)
	{
		reserva.setReservaOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(reserva);
		entityManager.getTransaction().commit();

		entityManager.close();
	}
	
	public void removerReserva(Reserva reserva)
	{
		entityManager.getTransaction().begin();
		
		Reserva r = entityManager.merge(reserva);
		entityManager.remove(r);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Reserva> recuperarTodasReservas()
	{
		List<Reserva> resultado;
		
		TypedQuery<Reserva> query = entityManager.createQuery("select r from Reserva r", Reserva.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public List<Reserva> recuperarReservasPorCpfCliente(String cpf)
	{
		List<Reserva> resultado;
		
		String consulta = "select r from Reserva r where r.pessoa.cpf = ";
		
		TypedQuery<Reserva> query = entityManager.createQuery( consulta + cpf, Reserva.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> recuperarReservasPorMarcaEModelo(String marca,
			String modelo)
	{
		String query = "select * from Reserva "
							+ "where carro_oid = "
								+ "(select c.carro_oid from Carro c "
									+ "where c.modelo = :modelo and c.marca = :marca)";
		
		List<Reserva> listaReservas = entityManager.createNativeQuery(query, Reserva.class).setParameter("modelo", modelo).setParameter("marca", marca).getResultList();
		
		return listaReservas;
	}
	
	public void refresh()
	{
		entityManager.close();
		criarEntityManager("Reserva");
	}
	
	public void apagarReservaAdicionadaNoTeste(String cpf, String marca,
			String modelo)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		String query = "delete from Reserva"
							+ "where carro_oid = "
								+ "(select c.carro_oid from Carro c "
									+ "where c.modelo = :modelo and c.marca = :marca)"
							+ "and pessoa_oid = "
								+ "(select p.pessoa_oid from Pessoa p "
									+ "where p.cpf = :cpf)";
		
		entityManager.createNativeQuery(query, Reserva.class).setParameter("modelo", modelo)
															 .setParameter("marca", marca)
															 .setParameter("cpf", cpf).executeUpdate();
		
		transaction.commit();
	}

	
}
