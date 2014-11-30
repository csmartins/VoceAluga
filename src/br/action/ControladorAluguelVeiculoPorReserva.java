package br.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.model.Aluguel;
import br.model.AluguelDAO;
import br.model.CarroDAO;
import br.model.Reserva;

public class ControladorAluguelVeiculoPorReserva {
	
	private Aluguel aluguel;
	private Reserva reserva;
	
	public ControladorAluguelVeiculoPorReserva(Reserva reserva)
	{
		this.reserva = reserva;
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
	
	public void alugar()
	{
		if (!reservaPodeSerAlugada())
		{
			return;
		}
		
		AluguelDAO aluguelDAO = new AluguelDAO();
		
		aluguel = new Aluguel(reserva.getPessoa(), reserva.getCarro(), reserva, reserva.getDataInicio(), reserva.getDataFim(), reserva.isPagoAntecipado());
		
		aluguelDAO.persistirAluguel(aluguel);
	}
}
