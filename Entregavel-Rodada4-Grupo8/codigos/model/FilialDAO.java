package br.model;

public class FilialDAO extends AbstractDAO
{
	public FilialDAO()
	{
		criarEntityManager("Filial");
	}

	public Filial recuperarFilialPorNumero(String num)
	{
		String query = "select * from Filial "
						+ "where num_filial = :num";
		
		Filial filial = (Filial) entityManager.createNativeQuery(query, Filial.class).setParameter("num", num).getSingleResult();
		
		return filial;
	}
}
