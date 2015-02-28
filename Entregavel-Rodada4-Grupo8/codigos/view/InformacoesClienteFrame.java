package br.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.action.ControladorInformacoesCliente;
import br.model.Pessoa;

public class InformacoesClienteFrame extends JInternalFrame {

	private ControladorInformacoesCliente controladorInformacoesCliente;

	private Pessoa pessoa;
	/**
	 * Create the frame.
	 */
	public InformacoesClienteFrame(Pessoa cliente) {
		controladorInformacoesCliente = new ControladorInformacoesCliente(cliente);
		
		pessoa = cliente;
		
		setBorder(null);
		setClosable(true);
		setBounds(100, 100, 582, 330);
		setTitle("Informações do Cliente");
		
		JLabel lblNome = new JLabel("Nome: " + controladorInformacoesCliente.getNomeCliente());
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblCpf = new JLabel("CPF: " + controladorInformacoesCliente.getCpfCliente());
		
		JLabel lblRg = new JLabel("RG: " + controladorInformacoesCliente.getRgCliente());
		
		JLabel lblCarteira = new JLabel("Carteira: " + controladorInformacoesCliente.getCarteiraCliente());
		
		JLabel lblCategoria = new JLabel("Categoria: " + controladorInformacoesCliente.getCategoriaCarteiraCliente());
		
		JLabel lblTelefone = new JLabel("Telefone: " + controladorInformacoesCliente.getTelefoneCliente());
		
		JLabel lblEmail = new JLabel("Email: " + controladorInformacoesCliente.getEmailCliente());
		
		JLabel lblListaNegra = new JLabel("Lista negra:");
		
		JLabel lblListaNegraSituacao = new JLabel(controladorInformacoesCliente.situacaoListaNegra());
		
		if (controladorInformacoesCliente.clienteEstaNaListaNegra())
		{
			lblListaNegraSituacao.setForeground(Color.RED);
			lblListaNegraSituacao.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		
		JButton btnVoltar = new JButton("Voltar");
		criarBotaoVoltar(btnVoltar);
		
		JButton btnAdicionarListaNegra = new JButton("Adicionar à lista negra");
		criarBotaoAdicionarListaNegra(btnAdicionarListaNegra);
		btnAdicionarListaNegra.setVisible(!controladorInformacoesCliente.clienteEstaNaListaNegra());
		
		JButton btnRemoverDaLista = new JButton("Remover da lista negra");
		criarBotaoRemoverListaNegra(btnRemoverDaLista, this);
		btnRemoverDaLista.setVisible(controladorInformacoesCliente.clienteEstaNaListaNegra());
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblListaNegra)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblListaNegraSituacao)
							.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNome)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCpf)
								.addGap(18)
								.addComponent(lblRg))
							.addComponent(lblTelefone)
							.addComponent(lblEmail)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCarteira)
								.addGap(18)
								.addComponent(lblCategoria))))
					.addGap(250))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(btnVoltar)
					.addGap(18)
					.addComponent(btnAdicionarListaNegra)
					.addGap(18)
					.addComponent(btnRemoverDaLista)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(lblRg))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarteira)
						.addComponent(lblCategoria))
					.addGap(18)
					.addComponent(lblTelefone)
					.addGap(18)
					.addComponent(lblEmail)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListaNegra)
						.addComponent(lblListaNegraSituacao))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnAdicionarListaNegra)
						.addComponent(btnRemoverDaLista))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	private void criarBotaoRemoverListaNegra(JButton btnRemoverDaLista, final JInternalFrame frame)
	{
		btnRemoverDaLista.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					pessoa.getListaNegras().clear();
					
					controladorInformacoesCliente.removerClienteListaNegra();
					
					JOptionPane.showMessageDialog(null, "O cliente foi removido da lista negra com sucesso");
					
					dispose();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente.");
					e.printStackTrace();
				}
			}
		});
	}

	private void criarBotaoAdicionarListaNegra(JButton btnAdicionarListaNegra)
	{
		btnAdicionarListaNegra.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					pessoa.getListaNegras().add(true);
					
					controladorInformacoesCliente.adicionarListaNegra();
					
					JOptionPane.showMessageDialog(null, "O cliente foi adicionado à lista negra com sucesso");
					
					dispose();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro, tente novamente.");
					e.printStackTrace();
				}
			}
		});
	}
	
	private void criarBotaoVoltar(JButton btnVoltar) 
	{
		btnVoltar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				dispose();
			}
		});
	}
}
