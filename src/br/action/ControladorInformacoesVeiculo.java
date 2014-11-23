package br.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.model.Carro;

public class ControladorInformacoesVeiculo {
	
	private Carro veiculo;
	private DateFormat formatoData;
	
	public ControladorInformacoesVeiculo(Carro veiculo)
	{
		this.veiculo = veiculo;
		this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
	}

	public String getMarcaVeiculo() {
		return veiculo.getMarca();
	}
	
	public String getModeloVeiculo() {
		return veiculo.getModelo();
	}
	
	public boolean veiculoEstaDisponivel() {
		return veiculo.getDisponivel().equals("true");
	}
	
	public String getTextoVeiculoDisponivel() {
		return veiculoEstaDisponivel() ? "Sim" : "Não";
	}
	
	public String getAnoVeiculo() {
		return String.valueOf(veiculo.getAno());
	}
	
	public String getPlacaVeiuclo() {
		return veiculo.getPlaca();
	}
	
	public String getDiariaVeiculo() {
		return "R$" + veiculo.getDiaria();
	}
	
	public String getPrecoVeiculo() {
		return "R$" + veiculo.getPreco();
	}
	
	public String getUltimaManutencaoVeiculo() {
		return formatoData.format(veiculo.getUltimaManutencao());
	}
}
