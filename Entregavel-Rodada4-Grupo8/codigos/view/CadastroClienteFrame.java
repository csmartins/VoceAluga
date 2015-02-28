package br.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.action.ControladorCadastroCliente;
import br.model.CategoriasCarteira;
import br.utils.Utils;

public class CadastroClienteFrame extends JInternalFrame 
{
	private static final long serialVersionUID = -1170388866142872903L;

	private JTextField cmpTextNome;
	private JTextField cmpTextCpf;
	private JTextField cmpTextRg;
	private JTextField cmpTextCarteira;
	private JTextField cmpTextTelefone;
	private JTextField cmpTextEmail;
	private JComboBox<CategoriasCarteira> cmbBoxCategoriaCarteira;

	private ControladorCadastroCliente controladorCadastroCliente;
	
	/**
	 * Create the frame.
	 */
	public CadastroClienteFrame() 
	{
		criarCamposTelaCadastro();

	}

	private void criarCamposTelaCadastro()
	{
		setTitle("Cadastro de Cliente");
		setBorder(null);
		setClosable(true);
		setBounds(100, 100, 582, 330);
		
		JPanel panelDadosCadastrais = new JPanel();
		
		JPanel panelBotoes = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBotoes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
						.addComponent(panelDadosCadastrais, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDadosCadastrais, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		panelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		criarEventoBotaoSalvarCadastroCliente(btnSalvar);
		btnSalvar.setBounds(283, 12, 134, 50);
		panelBotoes.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		criarEventoCancelarCadastro(btnCancelar);
		btnCancelar.setBounds(422, 12, 134, 50);
		panelBotoes.add(btnCancelar);
		
		JLabel lblNome = new JLabel("Nome");
		
		cmpTextNome = new JTextField();
		cmpTextNome.setColumns(10);
		
		
		JLabel lblCpf = new JLabel("CPF");
		
		cmpTextCpf = new JTextField();
		cmpTextCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		
		cmpTextRg = new JTextField();
		cmpTextRg.setColumns(10);
		
		JLabel lblCarteira = new JLabel("Carteira");
		
		cmpTextCarteira = new JTextField();
		cmpTextCarteira.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		cmpTextTelefone = new JTextField();
		cmpTextTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		cmpTextEmail = new JTextField();
		cmpTextEmail.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		cmbBoxCategoriaCarteira = new JComboBox<CategoriasCarteira>();
		DefaultComboBoxModel<CategoriasCarteira> comboBoxModel = new DefaultComboBoxModel<CategoriasCarteira>(CategoriasCarteira.values());
		cmbBoxCategoriaCarteira.setModel(comboBoxModel);
		
		GroupLayout gl_panelDadosCadastrais = new GroupLayout(panelDadosCadastrais);
		gl_panelDadosCadastrais.setHorizontalGroup(
			gl_panelDadosCadastrais.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblCpf)
								.addComponent(lblRg))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
								.addComponent(cmpTextNome, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
									.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
										.addComponent(cmpTextCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cmpTextRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTelefone)
										.addComponent(lblCarteira))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
											.addComponent(cmpTextCarteira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCategoria)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cmbBoxCategoriaCarteira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(cmpTextTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(54))
						.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmpTextEmail, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
					.addGap(26))
		);
		gl_panelDadosCadastrais.setVerticalGroup(
			gl_panelDadosCadastrais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
					.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(cmpTextNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(cmpTextCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRg)
								.addComponent(cmpTextRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelDadosCadastrais.createSequentialGroup()
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCarteira)
								.addComponent(cmpTextCarteira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoria)
								.addComponent(cmbBoxCategoriaCarteira, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(cmpTextTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panelDadosCadastrais.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(cmpTextEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		panelDadosCadastrais.setLayout(gl_panelDadosCadastrais);
		getContentPane().setLayout(groupLayout);
	}

	private void criarEventoBotaoSalvarCadastroCliente(JButton btnSalvar)
	{
		controladorCadastroCliente = new ControladorCadastroCliente();
		
		btnSalvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				validarDadosInseridos();
				
				if(controladorCadastroCliente.isCadastroValido())
				{
					controladorCadastroCliente.cadastrar(cmpTextNome.getText(), 
														cmpTextCpf.getText(), 
														cmpTextRg.getText(), 
														cmpTextCarteira.getText(), 
														cmbBoxCategoriaCarteira.getSelectedItem().toString(),
														cmpTextTelefone.getText(), 
														cmpTextEmail.getText());
					
					Utils.exibirMensagem("Cadastro realizado com sucesso");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, Arrays.toString(controladorCadastroCliente.getMensagensCadastro().toArray()), "Existem problemas com o cadastro", JOptionPane.ERROR_MESSAGE);
					controladorCadastroCliente.limparMensagensCadastroCliente();
				}
				
				
			}

			private void validarDadosInseridos()
			{
				controladorCadastroCliente.validarNome(cmpTextNome.getText());
				controladorCadastroCliente.validarCpf(cmpTextCpf.getText());
				controladorCadastroCliente.validarRg(cmpTextRg.getText());
				controladorCadastroCliente.validarCarteira(cmpTextCarteira.getText());
				controladorCadastroCliente.validarTelefone(cmpTextTelefone.getText());
				controladorCadastroCliente.validarEmail(cmpTextEmail.getText());				
			}
		});
	}

	private void criarEventoCancelarCadastro(JButton btnCancelar)
	{
		btnCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
}
