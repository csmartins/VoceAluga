package br.model;


public class ListaNegraDAO extends AbstractDAO
{
	public ListaNegraDAO()
	{
		criarEntityManager("ListaNegra");
	}
	
	public ListaNegra recuperarListaNegraPorCPF(String cpf)
	{
		String query = "select * from ListaNegra "
								+ "where pessoa_oid = ("
										+ "select pessoa_oid from Pessoa "
												+ "where cpf = :cpf) limit 1";
		ListaNegra listaNegra =  (ListaNegra) entityManager.createNativeQuery(query, ListaNegra.class).setParameter("cpf", cpf).getSingleResult();
		
		return listaNegra;
	}

	public void persistirListaNegra(ListaNegra listaNegra)
	{
		listaNegra.setListaNegraOid(criarOid());
		
		entityManager.getTransaction().begin();
		entityManager.persist(listaNegra);
		entityManager.getTransaction().commit();

		entityManager.close();
		
	}

}
