package br.view;

import javax.swing.JInternalFrame;

import br.action.ControladorInformacoesCliente;
import br.model.Pessoa;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacoesClienteFrame extends JInternalFrame {

	private ControladorInformacoesCliente controladorInformacoesCliente;

	/**
	 * Create the frame.
	 */
	public InformacoesClienteFrame(Pessoa cliente) {
		controladorInformacoesCliente = new ControladorInformacoesCliente(cliente);
		
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
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCpf)
							.addGap(18)
							.addComponent(lblRg))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCarteira)
							.addGap(18)
							.addComponent(lblCategoria))
						.addComponent(lblTelefone)
						.addComponent(lblEmail)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblListaNegra)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblListaNegraSituacao)))
					.addContainerGap(267, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addGap(235))
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
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	private void criarBotaoVoltar(JButton btnVoltar) {
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
	}
}
