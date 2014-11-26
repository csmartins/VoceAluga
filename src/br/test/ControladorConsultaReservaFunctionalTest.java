package br.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaReserva;
import br.model.ReservaDAO;

public class ControladorConsultaReservaFunctionalTest extends FunctionalTest
{
	private ControladorConsultaReserva controladorConsultaReserva;
	private ReservaDAO reservaDAO;
	
	@Test
	public void testControladorConsultaReserva_FiltrarReservas_CPFNulo_DeveTrazerTodasAsReservas()
	{
		controladorConsultaReserva = new ControladorConsultaReserva();
		reservaDAO = new ReservaDAO();
		
		String cpf = null;
		int totalReservas = reservaDAO.recuperarTodasReservas().size();
		
		controladorConsultaReserva.filtrarReservas(cpf);
		
		Assert.assertEquals(controladorConsultaReserva.getReservas().size(), totalReservas);
	}
	
	@Test
	public void testControladorConsultaReserva_FiltrarReservas_CPFNaoNulo_DeveTrazerTodasAsReservasDoCliente()
	{
		controladorConsultaReserva = new ControladorConsultaReserva();
		reservaDAO = new ReservaDAO();
		
		String cpf = "123456";
		int totalReservas = reservaDAO.recuperarReservasPorCpfCliente(cpf).size();
		
		controladorConsultaReserva.filtrarReservas(cpf);
		
		Assert.assertEquals(controladorConsultaReserva.getReservas().size(), totalReservas);
	}
}
