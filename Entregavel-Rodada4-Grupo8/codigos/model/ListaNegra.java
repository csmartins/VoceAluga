package br.model;

// Generated 01/12/2014 10:10:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ListaNegra generated by hbm2java
 */
@Entity
@Table(name = "ListaNegra", catalog = "VoceAluga")
public class ListaNegra implements java.io.Serializable
{

	private String listaNegraOid;
	private Pessoa pessoa;
	private String justificativa;

	public ListaNegra()
	{
	}

	public ListaNegra(String listaNegraOid, Pessoa pessoa)
	{
		this.listaNegraOid = listaNegraOid;
		this.pessoa = pessoa;
	}

	public ListaNegra(String listaNegraOid, Pessoa pessoa, String justificativa)
	{
		this.listaNegraOid = listaNegraOid;
		this.pessoa = pessoa;
		this.justificativa = justificativa;
	}

	@Id
	@Column(name = "listaNegra_oid", unique = true, nullable = false, length = 45)
	public String getListaNegraOid()
	{
		return this.listaNegraOid;
	}

	public void setListaNegraOid(String listaNegraOid)
	{
		this.listaNegraOid = listaNegraOid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_oid", nullable = false)
	public Pessoa getPessoa()
	{
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa)
	{
		this.pessoa = pessoa;
	}

	@Column(name = "justificativa", length = 300)
	public String getJustificativa()
	{
		return this.justificativa;
	}

	public void setJustificativa(String justificativa)
	{
		this.justificativa = justificativa;
	}

}