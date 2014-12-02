package br.action;

import java.math.BigDecimal;
import java.util.Date;

import br.model.Aluguel;
import br.model.AluguelDAO;
import br.model.Carro;
import br.model.CarroDAO;

public class ControladorPagamento
{
	private CarroDAO carroDAO;
	private AluguelDAO aluguelDAO;
	
	private ControladorInformacoesReserva controladorInformacoesReserva;
	
	private String taxaPagamento;
	private String mensagens = "";
	
	private boolean retornoNaFilial;
	private boolean danificacao;
	
	private BigDecimal pagamentoAluguelTotal;
	
	private Aluguel aluguel;
	
	public ControladorPagamento()
	{
		carroDAO = new CarroDAO();
		aluguelDAO = new AluguelDAO();
	}
	
	public void venderCarro(Carro veiculo, String formaPagamento)
	{
		veiculo.setDisponivel("false");
		veiculo.setVendido("true");
		veiculo.setFormaPagamento(formaPagamento);
		
		carroDAO.atualizarVeiculo(veiculo);
	}

	public void venderCarroCredito(Carro veiculo, String parcelas)
	{
		String formaPagamento = "Crédito em " + parcelas + " vezes";
		
		venderCarro(veiculo, formaPagamento);
	}

	public void adicionarTaxas(Aluguel aluguel, String taxaPagamento, boolean retornoNaFilial, boolean danificacao)
	{
		this.aluguel = aluguel;
		this.taxaPagamento = taxaPagamento;
		this.retornoNaFilial = retornoNaFilial;
		this.danificacao = danificacao;
		
		popularPagamentoAluguelTotal();
		
		adicionarTaxaPagamento();
		
		adicionarTaxaRetorno();
		
		adicionarTaxaDanificacao();
		
		mensagens = mensagens + "Valor total: R$ " + pagamentoAluguelTotal.toString() + "\n";
		
		mensagens = mensagens + "Pagamento realizado com sucesso. Um email foi enviado para o cliente com o relatorio do pagamento e a nota fiscal";
		
	}

	private void adicionarTaxaDanificacao()
	{
		if(danificacao)
		{
			pagamentoAluguelTotal = pagamentoAluguelTotal.add(pagamentoAluguelTotal.multiply(BigDecimal.valueOf(0.1)));
			
			mensagens = mensagens + "Adicionada taxa para veiculo danificado.\n";
		}
	}

	private void adicionarTaxaRetorno()
	{
		if(!retornoNaFilial)
		{
			pagamentoAluguelTotal = pagamentoAluguelTotal.add(pagamentoAluguelTotal.multiply(BigDecimal.valueOf(0.1)));
			
			mensagens = mensagens + "Adicionada taxa para veiculo retornado em outra filial.\n";
		}
		
	}

	private void popularPagamentoAluguelTotal()
	{
		controladorInformacoesReserva = new ControladorInformacoesReserva(aluguel.getReserva());
		
		pagamentoAluguelTotal = calcularValorAluguel();
	}

	private BigDecimal calcularValorAluguel()
	{
		return aluguel.getReserva().getCarro().getDiaria().multiply(BigDecimal.valueOf(calculaDiasReserva()));
	}
	
	private int calculaIntervaloDias(Date d1, Date d2)
	{
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24) );
	}
	
	private int calculaDiasReserva()
	{
		return calculaIntervaloDias(aluguel.getReserva().getDataInicio(), aluguel.getReserva().getDataFim());
	}

	private void adicionarTaxaPagamento()
	{
		if(taxaPagamento.equals("Adiantado"))
		{
			pagamentoAluguelTotal = pagamentoAluguelTotal.subtract(pagamentoAluguelTotal.multiply(BigDecimal.valueOf(0.1)));
			
			mensagens = mensagens + "Adicionado desconto para pagamento Adiantado.\n";
		}
		if(taxaPagamento.equals("Atrasado"))
		{
			pagamentoAluguelTotal = pagamentoAluguelTotal.add(pagamentoAluguelTotal.multiply(BigDecimal.valueOf(0.1)));
			
			mensagens = mensagens + "Adicionada taxa para pagamento atrasado.\n";
		}
	}

	public void pagarAluguel(Aluguel aluguel, String formaPagamento)
	{
		aluguel.setPago(true);
		aluguel.setFormaPagamento(formaPagamento);
		
		aluguelDAO.atualizarAluguel(aluguel);
	}

	public void pagarAluguelCredito(Aluguel aluguel, String parcelas)
	{
		String formaPagamento = "Crédito em " + parcelas + " vezes";
		
		pagarAluguel(aluguel, formaPagamento);
		
	}

	public String getMensagens()
	{
		return mensagens;
	}

	public void setMensagens(String mensagens)
	{
		this.mensagens = mensagens;
	}

}
