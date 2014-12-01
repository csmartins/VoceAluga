package br.model;

import java.util.List;

import javax.persistence.EntityTransaction;


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
	
	@SuppressWarnings("unchecked")
	public List<Aluguel> recuperarAluguelPorReserva(Reserva reserva)
	{
		String query = "select * from Aluguel "
							+ "where reserva_oid = "
								+ "(select reserva_oid from Reserva where reserva_oid = :reserva_oid)";
		
		List<Aluguel> aluguel = entityManager.createNativeQuery(query, Reserva.class).setParameter("reserva_oid", reserva.getReservaOid())
																					 .getResultList();
		
		
		return aluguel;
	}

	public void atualizarAluguel(Aluguel aluguel)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.merge(aluguel);
		
		transaction.commit();
		
	}
	
}
