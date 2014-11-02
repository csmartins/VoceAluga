package br.action;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.NoResultException;

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
	
	private ArrayList<String> mensagensReserva;

	public ControladorReservaVeiculoPorModelo()
	{
		pessoaDAO = new PessoaDAO();
		
		carroDAO = new CarroDAO();
		
		reservaDAO = new ReservaDAO();
		
		mensagensReserva = new ArrayList<String>();
	}
	
	public void validarCPF(String cpf)
	{
		if(!validadorDadosReservaVeiculo.validarCPF(cpf))
		{
			mensagensReserva.add("\nDigite o cpf do cliente que está reservando este veículo");
			reservaValida = false;
		}
	}

	public void validarModelo(String modelo)
	{
		if(!validadorDadosReservaVeiculo.validarModelo(modelo))
		{
			mensagensReserva.add("\nDigite o modelo do veículo a ser reservado");
			reservaValida = false;
		}
		
	}

	public void validarMarca(String marca)
	{
		if(!validadorDadosReservaVeiculo.validarMarca(marca))
		{
			mensagensReserva.add("\nDigite a marca do veículo a ser reservado");
			reservaValida = false;
		}
		
	}
	
	public void validarMarcaEModelo(String marca, String modelo)
	{
		if(!validadorDadosReservaVeiculo.validarExistenciaDeVeiculoParaMarcaEModelo(marca, modelo))
		{
			mensagensReserva.add("\nNão existe um carro disponivel para essa marca e modelo. Entre em contato com outra filial");
			reservaValida = false;
		}
	}

	public void validarDatas(Date dataInicio, Date dataFim)
	{
		if(!validadorDadosReservaVeiculo.validarDataInicio(dataInicio))
		{
			mensagensReserva.add("\nInforme a data de início da reserva");
			reservaValida = false;
		}
		
		if(!validadorDadosReservaVeiculo.validarDataFim(dataFim))
		{
			mensagensReserva.add("\nInforme a data de vencimento da reserva");
			reservaValida = false;
		}
		
		if (!validadorDadosReservaVeiculo.validarDataFimDepoisDataInicio(dataInicio, dataFim))
		{
			mensagensReserva.add("\nData de fim deve ser depois da data de início.");
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

	public void cadastrar(String cpf, String marca, String modelo, Date dataInicio, Date dataFim)
	{
		popularCliente(cpf);
		
		popularVeiculo(marca, modelo);
			
		criarReserva(dataInicio, dataFim);
		
	}

	private void criarReserva(Date dataInicio, Date dataFim)
	{
		veiculo.setDisponivel("false");
		Reserva reserva = new Reserva(cliente, veiculo, dataInicio, dataFim, false);
		
		reservaDAO.persistirReserva(reserva);
		
		carroDAO.atualizarVeiculo(veiculo);
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
	public ArrayList<String> getMensagensReserva()
	{
		return mensagensReserva;
	}
	public void setMensagensReserva(ArrayList<String> mensagensReserva)
	{
		this.mensagensReserva = mensagensReserva;
	}

	public void limparMensagensReserva()
	{
		mensagensReserva.clear();
	}

	public void verificarClienteCadastrado(String cpf)
	{
		try
		{
			popularCliente(cpf);			
		}
		catch(NoResultException e)
		{
			e.printStackTrace();
			mensagensReserva.add("\nEsse CPF não está cadastrado, por favor cadastre-o.");
			reservaValida = false;
		}
	}
	

}
