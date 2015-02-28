package br.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaReserva;
import br.model.Carro;
import br.model.Pessoa;
import br.model.Reserva;

public class ControladorConsultaReservaUnitTest
{
	private ControladorConsultaReserva controladorConsultaReserva;
	
	@Test
	public void testControladorConsultaReserva_FormatarReserva_DeveFormatarInformacoesDaReserva()
	{
		controladorConsultaReserva = new ControladorConsultaReserva();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ana Mel");
		
		Carro carro = new Carro();
		carro.setMarca("Camaro");
		carro.setModelo("Amarelo");
		
		Reserva reserva = new Reserva();
		reserva.setCarro(carro);
		reserva.setPessoa(pessoa);
		reserva.setDataInicio(new Date());
		reserva.setDataFim(new Date());
		
		String reservaFormatada = controladorConsultaReserva.formatarReserva(reserva);
		
		Assert.assertEquals(reservaFormatada, "Carro: Camaro Amarelo | Cliente: Ana Mel | Duração: 26/11/2014 a 26/11/2014");
	}
}
