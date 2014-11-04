package br.action;

import br.model.Pessoa;

public class ControladorInformacoesCliente {
	
	private Pessoa cliente;
	
	public ControladorInformacoesCliente(Pessoa cliente)
	{
		this.cliente = cliente;
	}
	
	public String getNomeCliente()
	{
		return cliente.getNome();
	}
	
	public String getCpfCliente()
	{
		return cliente.getCpf();
	}
	
	public String getRgCliente()
	{
		return cliente.getRg();
	}
	
	public String getTelefoneCliente()
	{
		return cliente.getTelefone();
	}
	
	public String getEmailCliente()
	{
		return cliente.getEmail();
	}
	
	public String getCarteiraCliente()
	{
		return cliente.getCarteira();
	}
	
	public String getCategoriaCarteiraCliente()
	{
		return Character.toString(cliente.getCategoriaCarteira());
	}
	
	public String situacaoListaNegra()
	{
		return cliente.getListaNegras().isEmpty() ? "Não": "Sim";
	}
	
	public boolean clienteEstaNaListaNegra()
	{
		return !cliente.getListaNegras().isEmpty();
	}
}
