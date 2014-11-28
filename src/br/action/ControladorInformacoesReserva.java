package br.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.model.Aluguel;
import br.model.AluguelDAO;
import br.model.CarroDAO;
import br.model.Reserva;
import br.model.ReservaDAO;

public class ControladorInformacoesReserva
{
	private Reserva reserva;
	private Aluguel aluguel;
	private SimpleDateFormat formatoData;
	
	public ControladorInformacoesReserva(Reserva reserva)
	{
		this.reserva = reserva;
		formatoData = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public String getNomeCliente()
	{
		return reserva.getPessoa().getNome();
	}
	
	public String getCpfCliente()
	{
		return reserva.getPessoa().getCpf();
	}
	
	public String getCarteiraCliente()
	{
		return reserva.getPessoa().getCarteira() + " (Tipo " + reserva.getPessoa().getCategoriaCarteira() + ")";
	}
	
	public String getMarcaCarro()
	{
		return reserva.getCarro().getMarca();
	}
	
	public String getModeloCarro()
	{
		return reserva.getCarro().getModelo();
	}
	
	public String getDiariaCarro()
	{
		return "R$" + reserva.getCarro().getDiaria();
	}
	
	public String getDataInicio()
	{
		return formatoData.format(reserva.getDataInicio());
	}
	
	public String getDataFim()
	{
		return formatoData.format(reserva.getDataFim());
	}
	
	public String getValor()
	{
		return "R$" + reserva.getCarro().getDiaria().multiply(BigDecimal.valueOf(calculaDiasReserva())).toString();
	}
	
	public String getPagoAntecipadamente()
	{
		return reserva.isPagoAntecipado() ? "Sim" : "Não";
	}
	
	private int calculaIntervaloDias(Date d1, Date d2)
	{
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24) );
	}
	
	private int calculaDiasReserva()
	{
		return calculaIntervaloDias(reserva.getDataInicio(), reserva.getDataFim());
	}
	
	public boolean reservaPodeSerCancelada()
	{
		if (reserva.getDataInicio().before(new Date()))
		{
			return false;
		} 
		else
		{
			return true;
		}
	}
	
	public boolean reservaPodeSerAlugada()
	{
		if (reserva.getDataFim().before(new Date()) && reserva.getCarro().getDisponivel().equals(true) )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void cancelar()
	{
		if (!reservaPodeSerCancelada())
		{
			return;
		}
	
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.removerReserva(reserva);
		
		//reserva.getCarro().setDisponivel("true");
		//CarroDAO carroDAO = new CarroDAO();
		//carroDAO.disponibilizarCarro(reserva.getCarro());
	}
	
	public void alugar()
	{
		if (!reservaPodeSerAlugada())
		{
			return;
		}
		
		AluguelDAO aluguelDAO = new AluguelDAO();
		CarroDAO carroDAO = new CarroDAO();
		
		aluguel = new Aluguel(reserva.getPessoa(), reserva.getCarro(), reserva, reserva.getDataInicio(), reserva.getDataFim(), reserva.isPagoAntecipado());
		reserva.getCarro().setDisponivel("false");
		
		carroDAO.atualizarVeiculo(reserva.getCarro());
		aluguelDAO.persistirAluguel(aluguel);
	}
}
