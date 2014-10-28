package br.test;

import br.model.CarroDAO;
import br.model.PessoaDAO;

public class FunctionalTest
{
	private PessoaDAO pessoaDAO;
	private CarroDAO carroDAO;
	
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
}
