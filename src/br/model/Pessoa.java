package br.model;

// Generated 24/11/2014 10:19:15 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pessoa generated by hbm2java
 */
@Entity
@Table(name = "Pessoa", catalog = "VoceAluga")
public class Pessoa implements java.io.Serializable
{

	private String pessoaOid;
	private String nome;
	private String cpf;
	private String rg;
	private String carteira;
	private Character categoriaCarteira;
	private String telefone;
	private String email;
	private Set aluguels = new HashSet(0);
	private Set reservas = new HashSet(0);
	private Set filials = new HashSet(0);
	private Set listaNegras = new HashSet(0);

	public Pessoa()
	{
	}

	public Pessoa(String pessoaOid, String nome, String cpf, String rg)
	{
		this.pessoaOid = pessoaOid;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Pessoa(String pessoaOid, String nome, String cpf, String rg,
			String carteira, Character categoriaCarteira, String telefone,
			String email, Set aluguels, Set reservas, Set filials,
			Set listaNegras)
	{
		this.pessoaOid = pessoaOid;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.carteira = carteira;
		this.categoriaCarteira = categoriaCarteira;
		this.telefone = telefone;
		this.email = email;
		this.aluguels = aluguels;
		this.reservas = reservas;
		this.filials = filials;
		this.listaNegras = listaNegras;
	}

	public Pessoa(String nome, String cpf, String rg, String carteira,
			char categoriaCarteira, String telefone, String email)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.carteira = carteira;
		this.categoriaCarteira = categoriaCarteira;
		this.telefone = telefone;
		this.email = email;
	}

	@Id
	@Column(name = "pessoa_oid", unique = true, nullable = false, length = 45)
	public String getPessoaOid()
	{
		return this.pessoaOid;
	}

	public void setPessoaOid(String pessoaOid)
	{
		this.pessoaOid = pessoaOid;
	}

	@Column(name = "nome", nullable = false)
	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	@Column(name = "cpf", nullable = false, length = 12)
	public String getCpf()
	{
		return this.cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	@Column(name = "rg", nullable = false, length = 10)
	public String getRg()
	{
		return this.rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	@Column(name = "carteira", length = 10)
	public String getCarteira()
	{
		return this.carteira;
	}

	public void setCarteira(String carteira)
	{
		this.carteira = carteira;
	}

	@Column(name = "categoriaCarteira", length = 1)
	public Character getCategoriaCarteira()
	{
		return this.categoriaCarteira;
	}

	public void setCategoriaCarteira(Character categoriaCarteira)
	{
		this.categoriaCarteira = categoriaCarteira;
	}

	@Column(name = "telefone", length = 8)
	public String getTelefone()
	{
		return this.telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	@Column(name = "email", length = 45)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set getAluguels()
	{
		return this.aluguels;
	}

	public void setAluguels(Set aluguels)
	{
		this.aluguels = aluguels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set getReservas()
	{
		return this.reservas;
	}

	public void setReservas(Set reservas)
	{
		this.reservas = reservas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set getFilials()
	{
		return this.filials;
	}

	public void setFilials(Set filials)
	{
		this.filials = filials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set getListaNegras()
	{
		return this.listaNegras;
	}

	public void setListaNegras(Set listaNegras)
	{
		this.listaNegras = listaNegras;
	}

}
