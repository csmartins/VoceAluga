package br.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import br.model.Carro;
import br.model.CarroDAO;

public class ControladorCadastroVeiculo
{
	private ValidadorDadosCadastroVeiculo validadorDadosCadastroVeiculo = new ValidadorDadosCadastroVeiculo();

	private boolean cadastroValido;

	private CarroDAO carroDAO;
	
	private ArrayList<String> mensagensCadastro;
	
	public ControladorCadastroVeiculo()
	{
		cadastroValido = true;
		
		carroDAO = new CarroDAO();
		
		mensagensCadastro = new ArrayList<String>();
	}

	public void validarModelo(String modelo)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(modelo))
		{
			mensagensCadastro.add("\nDigite o modelo do carro");

			cadastroValido = false;
		}
	}

	public void validarMarca(String marca)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(marca))
		{
			mensagensCadastro.add("\nDigite a marca do carro");

			cadastroValido = false;
		}
	}

	public void validarPlaca(String placa)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(placa))
		{
			mensagensCadastro.add("\nDigite a placa do carro");

			cadastroValido = false;
		}
	}

	public void validarUltimaManutencao(Date ultimaManutencao)
	{
		if (!validadorDadosCadastroVeiculo.validarUltimaManutencao(ultimaManutencao))
		{
			mensagensCadastro.add("\nA data da última manutenção não pode ser uma data do futuro");

			cadastroValido = false;
		}
	}
	
	public void validarPreco(String preco)
	{
		if(!validadorDadosCadastroVeiculo.validarPreco(preco))
		{
			mensagensCadastro.add("\nPreço invalido");
			
			cadastroValido = false;
		}
	}
	
	public void validarDiaria(String diaria)
	{
		if(!validadorDadosCadastroVeiculo.validarDiaria(diaria))
		{
			mensagensCadastro.add("\nDiaria invalida");
			
			cadastroValido = false;
		}
	}

	public boolean isCadastroValido()
	{
		return cadastroValido;
	}

	public void setCadastroValido(boolean cadastroValido)
	{
		this.cadastroValido = cadastroValido;
	}

	public void cadastrar(String marca, String placa, String modelo, int ano,
			Date ultimaManutencao, Boolean disponivel, String preco, String diaria)
	{
		
		Carro veiculo = new Carro(modelo, placa, ano, ultimaManutencao, marca,
				disponivel.toString(), new BigDecimal(preco), new BigDecimal(diaria));

		carroDAO.persistirVeiculo(veiculo);
	}

	public ArrayList<String> getMensagensCadastro()
	{
		return mensagensCadastro;
	}

	public void setMensagensCadastro(ArrayList<String> mensagensCadastro)
	{
		this.mensagensCadastro = mensagensCadastro;
	}

	public void limparMensagensCadastroVeiculo()
	{
		mensagensCadastro.clear();
	}

	

}
