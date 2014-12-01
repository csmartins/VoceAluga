package br.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.model.Aluguel;
import br.model.AluguelDAO;

public class ControladorInformacoesAluguel
{
	private Aluguel aluguel;
	private SimpleDateFormat formatoData;
	
	public ControladorInformacoesAluguel(Aluguel aluguel)
	{
		this.aluguel = aluguel;
		formatoData = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public String getNomeCliente()
	{
		return aluguel.getPessoa().getNome();
	}
	
	public String getCpfCliente()
	{
		return aluguel.getPessoa().getCpf();
	}
	
	public String getCarteiraCliente()
	{
		return aluguel.getPessoa().getCarteira() + " (Tipo " + aluguel.getPessoa().getCategoriaCarteira() + ")";
	}
	
	public String getMarcaCarro()
	{
		return aluguel.getCarro().getMarca();
	}
	
	public String getModeloCarro()
	{
		return aluguel.getCarro().getModelo();
	}
	
	public String getDiariaCarro()
	{
		return "R$" + aluguel.getCarro().getDiaria();
	}
	
	public String getDataInicio()
	{
		return formatoData.format(aluguel.getDataInicio());
	}
	
	public String getDataFim()
	{
		return formatoData.format(aluguel.getDataFim());
	}
	
	public String getValor()
	{
		return "R$" + aluguel.getCarro().getDiaria().multiply(BigDecimal.valueOf(calculaDiasReserva())).toString();
	}
	
	public String getPago()
	{
		return aluguel.isPago() ? "Sim" : "Não";
	}
	
	private int calculaIntervaloDias(Date d1, Date d2)
	{
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24) );
	}
	
	private int calculaDiasReserva()
	{
		return calculaIntervaloDias(aluguel.getDataInicio(), aluguel.getDataFim());
	}
	
	public boolean aluguelPodeSerCancelado()
	{
		if (aluguel.getDataInicio().before(new Date()))
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
		if (!aluguelPodeSerCancelado())
		{
			return;
		}
	
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.removerAluguel(aluguel);
	}
}
