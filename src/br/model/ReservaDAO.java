package br.model;

import java.util.List;

import javax.persistence.Persistence;
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
		
		TypedQuery<Reserva> query = entityManager.createQuery("select r from Reserva r where r.pessoa.cpf = " + cpf, Reserva.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public void refresh()
	{
		entityManager.close();
		criarEntityManager("Reserva");
	}
}
