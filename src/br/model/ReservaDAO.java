package br.model;

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
}
