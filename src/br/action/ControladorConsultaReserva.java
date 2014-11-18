package br.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.model.Reserva;
import br.model.ReservaDAO;

public class ControladorConsultaReserva
{
	private ReservaDAO reservaDAO;
	private ArrayList<Reserva> reservas;
	private ArrayList<String> textoReservas;
	private SimpleDateFormat formatoData;
	
	public ControladorConsultaReserva()
	{
		reservaDAO = new ReservaDAO();
		reservas = new ArrayList<Reserva>();
		textoReservas = new ArrayList<String>();
		formatoData = new SimpleDateFormat("dd/MM/yyyy");
		
		prepopular();
	}
	
	public void prepopular()
	{
		reservas.addAll(reservaDAO.recuperarTodasReservas());
		popularTextoReservas();
	}
	
	public void atualizarListadeReservas()
	{
		reservaDAO.refresh("Reserva");
		reservas.clear();
		prepopular();
	}
	
	public void filtrarReservas(String cpf)
	{
		reservas.clear();
		
		if (cpf == null || cpf.equals(""))
		{
			reservas.addAll(reservaDAO.recuperarTodasReservas());
		}
		else
		{
			reservas.addAll(reservaDAO.recuperarReservasPorCpfCliente(cpf));
		}
		
		popularTextoReservas();
	}

	private void popularTextoReservas()
	{
		textoReservas.clear();
		
		for (Reserva r : reservas)
		{
			textoReservas.add(formatarReserva(r));
		}
	}
	
	private String formatarReserva(Reserva r)
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append("Carro: ");
		buf.append(r.getCarro().getMarca());
		buf.append(" ");
		buf.append(r.getCarro().getModelo());
		
		buf.append(" | ");
		
		buf.append("Cliente: ");
		buf.append(r.getPessoa().getNome());
		
		buf.append(" | ");
		
		buf.append("Duração: ");
		buf.append(formatoData.format(r.getDataInicio()));
		buf.append(" a ");
		buf.append(formatoData.format(r.getDataFim()));
		
		return buf.toString();
	}

	public ArrayList<String> getTextoReservas()
	{
		return textoReservas;
	}
	
	public Reserva getReserva(int index)
	{
		return reservas.get(index);
	}
}
