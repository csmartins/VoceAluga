package br.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaReserva;
import br.action.ControladorInformacoesReserva;
import br.action.ControladorReservaVeiculoPorModelo;
import br.model.Reserva;
import br.model.ReservaDAO;
import br.utils.Utils;

public class ControladorInformacoesReservaFunctionalTest extends FunctionalTest
{
	private ControladorInformacoesReserva controladorInformacoesReserva;
	private ControladorReservaVeiculoPorModelo controladorReservaVeiculoPorModelo;
	private ReservaDAO reservaDAO;
	
	@Test
	public void testControladorInformacoesReserva_Cancelar_ReservaPodeSerCancelada_DeveRemoverAReserva()
	{
		String cpfPessoaTeste = "444444";
		String marcaCarroTeste = "Marca Teste";
		String modeloCarroTeste = "Teste";
		Date dataInicio = Utils.criarDataNoFuturo(10);
		Date dataFim = Utils.criarDataNoFuturo(11);
		
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		controladorReservaVeiculoPorModelo.cadastrar(cpfPessoaTeste, marcaCarroTeste, modeloCarroTeste, dataInicio, dataFim);
		
		Reserva reserva = controladorReservaVeiculoPorModelo.getReserva();
		
		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		try
		{
			controladorInformacoesReserva.cancelar();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testControladorInformacoesReserva_Cancelar_ReservaNaoPodeSerCancelada_NaoDeveRemoverAReserva()
	{
		String cpfPessoaTeste = "444444";
		String marcaCarroTeste = "Marca Teste";
		String modeloCarroTeste = "Teste";
		Date dataInicio = Utils.criarDataNoFuturo(-2);
		Date dataFim = Utils.criarDataNoFuturo(-1);
		
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		reservaDAO = new ReservaDAO();
		
		controladorReservaVeiculoPorModelo.cadastrar(cpfPessoaTeste, marcaCarroTeste, modeloCarroTeste, dataInicio, dataFim);
		
		Reserva reserva = controladorReservaVeiculoPorModelo.getReserva();
		
		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		int qtdeReservasAntes = reservaDAO.recuperarTodasReservas().size();
		
		controladorInformacoesReserva.cancelar();
		
		int qtdeReservasDepois = reservaDAO.recuperarTodasReservas().size();
		
		Assert.assertEquals(qtdeReservasAntes, qtdeReservasDepois);
	}
	
}
