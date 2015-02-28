package br.test;

import javax.persistence.NoResultException;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.action.ControladorConsultaVeiculo;
import br.action.ControladorInformacoesVeiculo;
import br.model.Carro;
import br.model.CarroDAO;
import br.model.Manutencao;
import br.model.ManutencaoDAO;

public class ControladorInformacoesVeiculoFunctionalTest extends FunctionalTest
{
	private ControladorConsultaVeiculo controladorConsultaVeiculo;
	private ControladorInformacoesVeiculo controladorInformacoesVeiculo;
	private CarroDAO carroDAO;
	private ManutencaoDAO manutencaoDAO;
	
	@Test
	public void testControladorInformacoesVeiculo_EnviarManutencao_DeveEnviarOVeiculoParaManutencao()
	{
		controladorConsultaVeiculo = new ControladorConsultaVeiculo();
		carroDAO = new CarroDAO();
		manutencaoDAO = new ManutencaoDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234"); 
		controladorInformacoesVeiculo = new ControladorInformacoesVeiculo(veiculo, controladorConsultaVeiculo);
		
		Assert.assertEquals(veiculo.getDisponivel(), "true");
		
		controladorInformacoesVeiculo.enviarManutencao();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		
		Manutencao manutencao;
		
		try
		{
			manutencao = manutencaoDAO.recuperarManutencaoPorCarro(veiculo.getCarroOid());
		}
		catch(NoResultException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		controladorInformacoesVeiculo.removerManutencao();
	}
	
	@Test
	public void testControladorInformacoesVeiculo_RemoverManutencao_DeveRemoverOVeiculoDaManutencao()
	{
		controladorConsultaVeiculo = new ControladorConsultaVeiculo();
		carroDAO = new CarroDAO();
		manutencaoDAO = new ManutencaoDAO();
		
		Carro veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234"); 
		controladorInformacoesVeiculo = new ControladorInformacoesVeiculo(veiculo, controladorConsultaVeiculo);
		
		controladorInformacoesVeiculo.enviarManutencao();
		
		Assert.assertEquals(veiculo.getDisponivel(), "false");
		
		controladorInformacoesVeiculo.removerManutencao();
		
		veiculo = carroDAO.recuperarCarroPorPlaca("TST-1234");
		
		Assert.assertEquals(veiculo.getDisponivel(), "true");
		
	}
	
}
