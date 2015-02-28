package br.action;

import java.util.ArrayList;

import br.model.Carro;
import br.model.CarroDAO;

public class ControladorConsultaVeiculo
{
	private CarroDAO carroDAO;
	private ArrayList<Carro> veiculos;
	private ArrayList<String> textoClientes;
	
	public ControladorConsultaVeiculo()
	{
		carroDAO = new CarroDAO();
		veiculos = new ArrayList<Carro>();
		textoClientes = new ArrayList<String>();
		
		prepopular();
	}
	
	public void prepopular()
	{
		veiculos.addAll(carroDAO.recuperarTodosCarros());
		popularTextoVeiculos();
	}
	
	public void filtrarVeiculos(String modelo, boolean soDisponiveis)
	{
		veiculos.clear();
		
		if (modelo == null || modelo.equals(""))
		{
			if (soDisponiveis)
				veiculos.addAll(carroDAO.recuperarCarrosDisponiveis());
			else
				veiculos.addAll(carroDAO.recuperarTodosCarros());
		}
		else
		{
			if (soDisponiveis)
				veiculos.addAll(carroDAO.recuperarCarrosDisponiveisPorModelo(modelo));
			else
				veiculos.addAll(carroDAO.recuperarCarrosPorModelo(modelo));
		}
		
		popularTextoVeiculos();
	}

	private void popularTextoVeiculos()
	{
		textoClientes.clear();
		
		for (Carro c : veiculos)
		{
			textoClientes.add(formatarInformacoesVeiculo(c));
		}
	}
	
	private String formatarInformacoesVeiculo(Carro c)
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append("Modelo: ");
		buf.append(c.getMarca());
		buf.append(" ");
		buf.append(c.getModelo());
		
		buf.append(" | ");
		
		buf.append("Placa: ");
		buf.append(c.getPlaca());

		buf.append(" | ");
		
		buf.append(c.getDisponivel().equals("true") ? "Disponível": "Indisponível");
		
		return buf.toString();
	}

	public ArrayList<String> getTextoVeiculos()
	{
		return textoClientes;
	}
	
	public Carro getVeiculo(int index)
	{
		return veiculos.get(index);
	}
}
