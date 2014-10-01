package br.action;

import java.util.Date;

import javax.swing.JOptionPane;

import br.model.Carro;
import br.model.CarroDAO;
import br.model.Pessoa;
import br.model.PessoaDAO;
import br.model.Reserva;
import br.model.ReservaDAO;

public class ControladorReservaVeiculoPorModelo
{
	private ValidadorDadosReservaVeiculo validadorDadosReservaVeiculo = new ValidadorDadosReservaVeiculo();
	
	private boolean reservaValida = true;
	
	private Pessoa cliente;
	private Carro veiculo;
	
	private PessoaDAO pessoaDAO;
	private CarroDAO carroDAO;
	private ReservaDAO reservaDAO;

	public ControladorReservaVeiculoPorModelo()
	{
		pessoaDAO = new PessoaDAO();
		
		carroDAO = new CarroDAO();
		
		reservaDAO = new ReservaDAO();
	}
	public void validarCPF(String cpf)
	{
		if(!validadorDadosReservaVeiculo.validarCPF(cpf))
		{
			JOptionPane.showMessageDialog(null, "Digite o cpf do cliente que está reservando este veículo.");
			reservaValida = false;
		}
	}

	public void validarModelo(String modelo)
	{
		if(!validadorDadosReservaVeiculo.validarModelo(modelo))
		{
			JOptionPane.showMessageDialog(null, "Digite o modelo do veículo a ser reservado.");
			reservaValida = false;
		}
		
	}

	public void validarMarca(String marca)
	{
		if(!validadorDadosReservaVeiculo.validarMarca(marca))
		{
			JOptionPane.showMessageDialog(null, "Digite a marca do veículo a ser reservado.");
			reservaValida = false;
		}
		
	}
	
//	public void validarMarcaEModelo(String marca, String modelo)
//	{
//		if(!validadorDadosReservaVeiculo.validarExistenciaDeVeiculoParaMarcaEModelo(marca, modelo))
//		{
//			JOptionPane.showMessageDialog(null, "Não existe um carro disponivel para essa marca e modelo. Entre em contato com outra filial");
//			reservaValida = false;
//		}
//	}

	public void validarDataFim(Date dataFim)
	{
		if(!validadorDadosReservaVeiculo.validarDataFim(dataFim))
		{
			JOptionPane.showMessageDialog(null, "Digite a data de vencimento da reserva.");
			reservaValida = false;
		}
		
	}

	public boolean isReservaValida()
	{
		return reservaValida;
	}

	public void setReservaValida(boolean reservaValida)
	{
		this.reservaValida = reservaValida;
	}

	public void cadastrar(String cpf, String marca, String modelo, Date dataFim)
	{
		popularCliente(cpf);
		
		popularVeiculo(marca, modelo);
		
		criarReserva(dataFim);
		
	}

	private void criarReserva(Date dataFim)
	{
		Reserva reserva = new Reserva(cliente, veiculo, new Date(), dataFim, false);
		
		reservaDAO.persistirReserva(reserva);
		
	}

	public void popularVeiculo(String marca, String modelo)
	{
		Carro veiculo = carroDAO.recuperarCarroDisponivelPorMarcaEModelo(marca, modelo);
		
		setVeiculo(veiculo);
	}

	private void popularCliente(String cpf)
	{
		cliente = pessoaDAO.recuperarPessoaPorCPF(cpf);			
	}
	
	public Carro getVeiculo()
	{
		return veiculo;
	}
	
	public void setVeiculo(Carro veiculo)
	{
		this.veiculo = veiculo;
	}
	

}
