package br.model;

// Generated 24/11/2014 10:19:15 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reserva generated by hbm2java
 */
@Entity
@Table(name = "Reserva", catalog = "VoceAluga")
public class Reserva implements java.io.Serializable
{

	private String reservaOid;
	private Pessoa pessoa;
	private Carro carro;
	private Date dataInicio;
	private Date dataFim;
	private boolean pagoAntecipado;
	private Set aluguels = new HashSet(0);

	public Reserva()
	{
	}

	public Reserva(String reservaOid, Pessoa pessoa, Carro carro,
			Date dataInicio, Date dataFim, boolean pagoAntecipado)
	{
		this.reservaOid = reservaOid;
		this.pessoa = pessoa;
		this.carro = carro;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.pagoAntecipado = pagoAntecipado;
	}

	public Reserva(String reservaOid, Pessoa pessoa, Carro carro,
			Date dataInicio, Date dataFim, boolean pagoAntecipado, Set aluguels)
	{
		this.reservaOid = reservaOid;
		this.pessoa = pessoa;
		this.carro = carro;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.pagoAntecipado = pagoAntecipado;
		this.aluguels = aluguels;
	}

	public Reserva(Pessoa cliente, Carro veiculo, Date dataInicio,
			Date dataFim, boolean pagoAntecipado)
	{
		this.pessoa = cliente;
		this.carro = veiculo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.pagoAntecipado = pagoAntecipado;
	}

	@Id
	@Column(name = "reserva_oid", unique = true, nullable = false, length = 45)
	public String getReservaOid()
	{
		return this.reservaOid;
	}

	public void setReservaOid(String reservaOid)
	{
		this.reservaOid = reservaOid;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carro_oid", nullable = false)
	public Carro getCarro()
	{
		return this.carro;
	}

	public void setCarro(Carro carro)
	{
		this.carro = carro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataInicio", nullable = false, length = 10)
	public Date getDataInicio()
	{
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio)
	{
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataFim", nullable = false, length = 10)
	public Date getDataFim()
	{
		return this.dataFim;
	}

	public void setDataFim(Date dataFim)
	{
		this.dataFim = dataFim;
	}

	@Column(name = "pagoAntecipado", nullable = false)
	public boolean isPagoAntecipado()
	{
		return this.pagoAntecipado;
	}

	public void setPagoAntecipado(boolean pagoAntecipado)
	{
		this.pagoAntecipado = pagoAntecipado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	public Set getAluguels()
	{
		return this.aluguels;
	}

	public void setAluguels(Set aluguels)
	{
		this.aluguels = aluguels;
	}

}
