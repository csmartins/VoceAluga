package br.model;

import java.util.List;


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

		refresh("ListaNegra");
		
		entityManager.close();
		
	}

	public boolean isPessoaNaListaNegra(Pessoa cliente)
	{
		String query = "select * from ListaNegra where pessoa_oid = :pessoa";
		
		List<ListaNegra> listaNegra = entityManager.createNativeQuery(query, ListaNegra.class).setParameter("pessoa", cliente.getPessoaOid()).getResultList();
		
		return !listaNegra.isEmpty();
	}
}
