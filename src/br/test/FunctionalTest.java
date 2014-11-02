package br.test;

import br.model.CarroDAO;
import br.model.PessoaDAO;
import br.model.ReservaDAO;

public class FunctionalTest
{
	private PessoaDAO pessoaDAO;
	private CarroDAO carroDAO;
	private ReservaDAO reservaDAO;
	
	public void limparCarroAdicionadoPorPlaca(String placa)
	{
		carroDAO = new CarroDAO();
		
		carroDAO.apagarCarroAdicionadoNoTestePorPlaca(placa);
	}
	
	public void limparPessoaAdicionadaPorCPF(String cpf)
	{
		pessoaDAO = new PessoaDAO();
		
		pessoaDAO.apagarPessoaAdicinadaNoTestePorCPF(cpf);
	}
	
	public void limparReservaPorCPFMarcaEModelo(String cpf, String marca, String modelo)
	{
		reservaDAO = new ReservaDAO();
		
		reservaDAO.apagarReservaAdicionadaNoTeste(cpf, marca, modelo);
	}
}
