package br.action;

import java.math.BigDecimal;
import java.util.Date;

import br.model.Carro;
import br.model.CarroDAO;
import br.utils.Utils;

public class ControladorCadastroVeiculo
{
	private ValidadorDadosCadastroVeiculo validadorDadosCadastroVeiculo = new ValidadorDadosCadastroVeiculo();

	private boolean cadastroValido = true;

	private CarroDAO carroDAO = new CarroDAO();

	public void validarModelo(String modelo)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(modelo))
		{
			Utils.exibirMensagem("Digite o modelo do carro");

			cadastroValido = false;
		}
	}

	public void validarMarca(String marca)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(marca))
		{
			Utils.exibirMensagem("Digite a marca do carro.");

			cadastroValido = false;
		}
	}

	public void validarPlaca(String placa)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(placa))
		{
			Utils.exibirMensagem("Digite a placa do carro.");

			cadastroValido = false;
		}
	}

	public void validarUltimaManutencao(Date ultimaManutencao)
	{
		if (!validadorDadosCadastroVeiculo.validarUltimaManutencao(ultimaManutencao))
		{
			Utils.exibirMensagem("A data da última manutenção não pode ser uma data do futuro.");

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

}
