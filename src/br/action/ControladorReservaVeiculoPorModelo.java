package br.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import br.model.Carro;
import br.model.CarroDAO;
import br.model.ListaNegra;
import br.model.ListaNegraDAO;
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
	
	private String marca;
	private String modelo;
	
	private PessoaDAO pessoaDAO;
	private CarroDAO carroDAO;
	private ReservaDAO reservaDAO;
	private ListaNegraDAO listaNegraDAO;
	
	private ArrayList<String> mensagensReserva;

	public ControladorReservaVeiculoPorModelo()
	{
		pessoaDAO = new PessoaDAO();
		
		carroDAO = new CarroDAO();
		
		reservaDAO = new ReservaDAO();
		
		mensagensReserva = new ArrayList<String>();
		
		listaNegraDAO = new ListaNegraDAO();
	}
	
	public void validarCPF(String cpf)
	{
		if(!validadorDadosReservaVeiculo.validarCPF(cpf))
		{
			invalidarReserva("\nDigite o cpf do cliente que está reservando este veículo");
		}
	}

	public void validarModelo(String modelo)
	{
		if(!validadorDadosReservaVeiculo.validarModelo(modelo))
		{
			invalidarReserva("\nDigite o modelo do veículo a ser reservado");
		}
	}

	public void validarMarca(String marca)
	{
		if(!validadorDadosReservaVeiculo.validarMarca(marca))
		{
			invalidarReserva("\nDigite a marca do veículo a ser reservado");
		}
	}
	
	public void validarMarcaEModelo(String marca, String modelo)
	{
		this.marca = marca;
		this.modelo = modelo;
		
		if(!validadorDadosReservaVeiculo.validarExistenciaDeVeiculoParaMarcaEModelo(marca, modelo))
		{
			invalidarReserva("\nNão existe um carro disponivel para essa marca e modelo. Entre em contato com outra filial");
		}
	}

	public void validarDatas(Date dataInicio, Date dataFim)
	{
		if(!validadorDadosReservaVeiculo.validarDataInicio(dataInicio))
		{
			invalidarReserva("\nInforme a data de início da reserva");
		}
		
		if(!validadorDadosReservaVeiculo.validarDataFim(dataFim))
		{
			invalidarReserva("\nInforme a data de vencimento da reserva");
		}
		
		if (!validadorDadosReservaVeiculo.validarDataFimDepoisDataInicio(dataInicio, dataFim))
		{
			invalidarReserva("\nData de fim deve ser depois da data de início.");
		}
		
		verificarDisponibilidadeVeiculoParaDatasDigitadas(dataInicio, dataFim);
	}

	private void verificarDisponibilidadeVeiculoParaDatasDigitadas(Date dataInicio, Date dataFim)
	{
		List<Reserva> reservasCarro = reservaDAO.recuperarReservasPorMarcaEModelo(marca, modelo);
		
		Date dataInicioCadastrada;
		Date dataFimCadastrada;
		
		for(Reserva reserva : reservasCarro)
		{
			dataInicioCadastrada = reserva.getDataInicio();
			dataFimCadastrada = reserva.getDataFim();
			
			if(dataInicioCadastrada.after(dataInicio) && dataInicioCadastrada.before(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
			
			if(dataFimCadastrada.after(dataInicio) && dataFimCadastrada.before(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
			
			if(dataInicioCadastrada.before(dataInicio) && dataFimCadastrada.after(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
			
			if(dataInicioCadastrada.after(dataInicio) && dataFimCadastrada.before(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
			
			if(dataInicioCadastrada.equals(dataInicio) || dataInicioCadastrada.equals(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
			
			if(dataFimCadastrada.equals(dataInicio) || dataFimCadastrada.equals(dataFim))
			{
				invalidarReserva("\nJá existe uma reserva para este veículo no período digitado.");
				return;
			}
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
			invalidarReserva("\nEsse CPF não está cadastrado, por favor cadastre-o.");
		}
	}

	@SuppressWarnings("unused")
	public void verificarClienteNaListaNegra(String cpf)
	{
		try
		{
			ListaNegra entradasListaNegra = listaNegraDAO.recuperarListaNegraPorCPF(cpf);
		}
		catch(NoResultException e)
		{
			return;
		}
		
		invalidarReserva("\nEsse cliente possui irregularidades e está na Lista Negra, por favor resolva as irregularidades antes de efetuar uma reserva");
	}
	
	private void invalidarReserva(String mensagem)
	{
		mensagensReserva.add(mensagem);
		reservaValida = false;
	}
}
