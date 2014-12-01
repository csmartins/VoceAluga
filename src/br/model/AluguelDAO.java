package br.model;

import java.util.List;

import javax.persistence.TypedQuery;


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
	
	public void removerAluguel(Aluguel aluguel)
	{
		entityManager.getTransaction().begin();
		
		Aluguel a = entityManager.merge(aluguel);
		entityManager.remove(a);
		
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

	public List<Aluguel> recuperarTodosAlugueis()
	{
		List<Aluguel> resultado;
		
		TypedQuery<Aluguel> query = entityManager.createQuery("select a from Aluguel a", Aluguel.class);
		resultado = query.getResultList();
		
		return resultado;
	}
	
	public List<Aluguel> recuperarAlugueisPorCpfCliente(String cpf)
	{
		List<Aluguel> resultado;
		
		String consulta = "select a from Aluguel a where a.pessoa.cpf = ";
		
		TypedQuery<Aluguel> query = entityManager.createQuery( consulta + cpf, Aluguel.class);
		resultado = query.getResultList();
		
		return resultado;
	}

}