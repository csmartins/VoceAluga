package br.model;

// Generated 01/12/2014 10:10:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Perfil generated by hbm2java
 */
@Entity
@Table(name = "Perfil", catalog = "VoceAluga")
public class Perfil implements java.io.Serializable
{

	private String perfilOid;
	private String descricao;
	private String nome;

	public Perfil()
	{
	}

	public Perfil(String perfilOid, String descricao, String nome)
	{
		this.perfilOid = perfilOid;
		this.descricao = descricao;
		this.nome = nome;
	}

	@Id
	@Column(name = "perfil_oid", unique = true, nullable = false, length = 45)
	public String getPerfilOid()
	{
		return this.perfilOid;
	}

	public void setPerfilOid(String perfilOid)
	{
		this.perfilOid = perfilOid;
	}

	@Column(name = "descricao", nullable = false)
	public String getDescricao()
	{
		return this.descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@Column(name = "nome", nullable = false, length = 45)
	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

}
