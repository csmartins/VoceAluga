package br.model;

// Generated 16/09/2014 16:15:30 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Carro generated by hbm2java
 */
@Entity
@Table(name = "Carro", catalog = "VoceAluga")
public class Carro implements java.io.Serializable
{

	private String carroOid;
	private String modelo;
	private String placa;
	private int ano;
	private Date ultimaManutencao;
	private String marca;
	private String disponivel;
	private BigDecimal preco;
	private BigDecimal diaria;
	private Set reservas = new HashSet(0);
	private Set manutencaos = new HashSet(0);
	private Set aluguels = new HashSet(0);

	public Carro()
	{
	}

	public Carro(String carroOid, String modelo, String placa, int ano,
			String marca, String disponivel)
	{
		this.carroOid = carroOid;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.marca = marca;
		this.disponivel = disponivel;
	}

	public Carro(String modelo, String placa, int ano,
			Date ultimaManutencao, String marca, String disponivel,
			BigDecimal preco, BigDecimal diaria)
	{
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.ultimaManutencao = ultimaManutencao;
		this.marca = marca;
		this.disponivel = disponivel;
		this.preco = preco;
		this.diaria = diaria;
	}
	
	public Carro(String modelo, String placa, int ano,
			Date ultimaManutencao, String marca, String disponivel)
	{
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.ultimaManutencao = ultimaManutencao;
		this.marca = marca;
		this.disponivel = disponivel;
	}

	@Id
	@Column(name = "carro_oid", unique = true, nullable = false, length = 45)
	public String getCarroOid()
	{
		return this.carroOid;
	}

	public void setCarroOid(String carroOid)
	{
		this.carroOid = carroOid;
	}

	@Column(name = "modelo", nullable = false, length = 45)
	public String getModelo()
	{
		return this.modelo;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	@Column(name = "placa", nullable = false, length = 45)
	public String getPlaca()
	{
		return this.placa;
	}

	public void setPlaca(String placa)
	{
		this.placa = placa;
	}

	@Column(name = "ano", nullable = false)
	public int getAno()
	{
		return this.ano;
	}

	public void setAno(int ano)
	{
		this.ano = ano;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ultimaManutencao", length = 10)
	public Date getUltimaManutencao()
	{
		return this.ultimaManutencao;
	}

	public void setUltimaManutencao(Date ultimaManutencao)
	{
		this.ultimaManutencao = ultimaManutencao;
	}

	@Column(name = "marca", nullable = false, length = 45)
	public String getMarca()
	{
		return this.marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	@Column(name = "disponivel", nullable = false, length = 45)
	public String getDisponivel()
	{
		return this.disponivel;
	}

	public void setDisponivel(String disponivel)
	{
		this.disponivel = disponivel;
	}

	@Column(name = "preco", precision = 10)
	public BigDecimal getPreco()
	{
		return this.preco;
	}

	public void setPreco(BigDecimal preco)
	{
		this.preco = preco;
	}

	@Column(name = "diaria", precision = 6)
	public BigDecimal getDiaria()
	{
		return this.diaria;
	}

	public void setDiaria(BigDecimal diaria)
	{
		this.diaria = diaria;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro")
	public Set getReservas()
	{
		return this.reservas;
	}

	public void setReservas(Set reservas)
	{
		this.reservas = reservas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro")
	public Set getManutencaos()
	{
		return this.manutencaos;
	}

	public void setManutencaos(Set manutencaos)
	{
		this.manutencaos = manutencaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro")
	public Set getAluguels()
	{
		return this.aluguels;
	}

	public void setAluguels(Set aluguels)
	{
		this.aluguels = aluguels;
	}

}