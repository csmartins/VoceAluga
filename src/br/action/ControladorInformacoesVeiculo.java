package br.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.model.Carro;
import br.model.CarroDAO;
import br.model.Filial;
import br.model.FilialDAO;
import br.model.Manutencao;
import br.model.ManutencaoDAO;

public class ControladorInformacoesVeiculo {
	
	private Carro veiculo;
	private DateFormat formatoData;
	private Filial filial;
	Manutencao manutencao;
	
	private ManutencaoDAO manutencaoDAO;
	private FilialDAO filialDAO;
	private CarroDAO carroDAO;
	
	private ControladorConsultaVeiculo controladorConsultaVeiculo;
	
	public ControladorInformacoesVeiculo(Carro veiculo, ControladorConsultaVeiculo controladorConsultaVeiculo)
	{
		this.veiculo = veiculo;
		this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.controladorConsultaVeiculo = controladorConsultaVeiculo;
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
	
	public String isVeiculoVendido()
	{
		return veiculoVendido() ? "Sim" : "Não";
	}
	
	public boolean veiculoVendido()
	{
		return veiculo.getVendido().equals("true");
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

	public void enviarManutencao()
	{
		veiculo.setDisponivel("false");
		
		veiculo.setUltimaManutencao(new Date());
		
		atualizarVeiculo();

		recuperarFilial();

		popularManutencao();
		
		manutencaoDAO.persistirManutencao(manutencao);
		
		controladorConsultaVeiculo.prepopular();
	}

	public void removerManutencao()
	{
		veiculo.setDisponivel("true");
		
		atualizarVeiculo();
		
		manutencaoDAO = new ManutencaoDAO();
		
		manutencaoDAO.removerManutencao(veiculo.getCarroOid());
		
		controladorConsultaVeiculo.prepopular();

	}

	private void popularManutencao()
	{
		manutencaoDAO = new ManutencaoDAO();
		
		manutencao = new Manutencao();
		manutencao.setCarro(veiculo);
		manutencao.setFilial(filial);
	}
	
	private void recuperarFilial()
	{
		filialDAO = new FilialDAO();
		
		filial = filialDAO.recuperarFilialPorNumero("1");
	}

	private void atualizarVeiculo()
	{
		carroDAO = new CarroDAO();
		
		carroDAO.atualizarVeiculo(veiculo);
	}

	
}
