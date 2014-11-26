package br.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorInformacoesReserva;
import br.model.Reserva;
import br.utils.Utils;

public class ControladorInformacoesReservaUnitTest
{
	private ControladorInformacoesReserva controladorInformacoesReserva;
	
	@Test
	public void ControladorInformacoesReserva_ReservaPodeSerCancelada_DataInicioNoFuturo_ReservaPodeSerCancelada()
	{
		Reserva reserva = new Reserva();
		reserva.setDataInicio(Utils.criarDataNoFuturo(1));
		
		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		Assert.assertTrue(controladorInformacoesReserva.reservaPodeSerCancelada());
	}
	
	@Test
	public void ControladorInformacoesReserva_ReservaPodeSerCancelada_DataInicioNoPassado_ReservaNaoPodeSerCancelada()
	{
		Reserva reserva = new Reserva();
		reserva.setDataInicio(Utils.criarDataNoFuturo(-1));
		
		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		Assert.assertFalse(controladorInformacoesReserva.reservaPodeSerCancelada());
	}
	
	@Test
	public void ControladorInformacoesReserva_ReservaPodeSerCancelada_DataInicioNoPresente_ReservaPodeSerCancelada()
	{
		Reserva reserva = new Reserva();
		reserva.setDataInicio(new Date());
		
		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		Assert.assertTrue(controladorInformacoesReserva.reservaPodeSerCancelada());
	}
}
