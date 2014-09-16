package br.action;

import java.util.Date;

import javax.swing.JOptionPane;

import br.model.Carro;
import br.model.CarroDAO;

public class ControladorCadastroVeiculo
{
	private ValidadorDadosCadastroVeiculo validadorDadosCadastroVeiculo = new ValidadorDadosCadastroVeiculo();

	private boolean cadastroValido = true;

	private CarroDAO carroDAO = new CarroDAO();

	public void validarModelo(String modelo)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(modelo))
		{
			JOptionPane.showMessageDialog(null, "Digite o modelo do carro");

			cadastroValido = false;
		}
	}

	public void validarMarca(String marca)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(marca))
		{
			JOptionPane.showMessageDialog(null, "Digite a marca do carro.");

			cadastroValido = false;
		}
	}

	public void validarPlaca(String placa)
	{
		if (!validadorDadosCadastroVeiculo.validarModelo(placa))
		{
			JOptionPane.showMessageDialog(null, "Digite a placa do carro.");

			cadastroValido = false;
		}
	}

	public void validarUltimaManutencao(Date ultimaManutencao)
	{
		if (!validadorDadosCadastroVeiculo.validarUltimaManutencao(ultimaManutencao))
		{
			JOptionPane.showMessageDialog(null, "A data da última manutenção não pode ser uma data do futuro.");

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
			Date ultimaManutencao, Boolean disponivel)
	{
		Carro veiculo = new Carro(modelo, placa, ano, ultimaManutencao, marca,
				disponivel.toString());

		carroDAO.persistirVeiculo(veiculo);
	}

}
