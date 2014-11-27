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

import br.action.ControladorConsultaVeiculo;
import br.action.ControladorInformacoesVeiculo;
import br.action.ControladorPagamento;
import br.model.Carro;

public class InformacoesVeiculoFrame extends JInternalFrame 
{
	private static final long serialVersionUID = 945196386534467283L;
	
	private ControladorInformacoesVeiculo controladorInformacoesVeiculo;
	
	private ControladorPagamento controladorPagamento;

	/**
	 * Create the frame.
	 */
	public InformacoesVeiculoFrame(Carro veiculo, ControladorConsultaVeiculo controladorConsultaVeiculo) 
	{
		controladorInformacoesVeiculo = new ControladorInformacoesVeiculo(veiculo, controladorConsultaVeiculo);

		setBorder(null);
		setClosable(true);
		setTitle("Informações do Veículo");
		setBounds(100, 100, 582, 330);
		
		JLabel lblNome = new JLabel("Veículo: " + controladorInformacoesVeiculo.getMarcaVeiculo() + " " + controladorInformacoesVeiculo.getModeloVeiculo());
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblMarca = new JLabel("Marca: " + controladorInformacoesVeiculo.getMarcaVeiculo());
		
		JLabel lblModelo = new JLabel("Modelo: " + controladorInformacoesVeiculo.getModeloVeiculo());
		
		JLabel lblPlaca = new JLabel("Placa: " + controladorInformacoesVeiculo.getPlacaVeiuclo());
		
		JLabel label = new JLabel("");
		
		JLabel lblAnoano = new JLabel("Ano: " + controladorInformacoesVeiculo.getAnoVeiculo());
		
		JLabel lblltimaManutencao = new JLabel("Última manutenção: " + controladorInformacoesVeiculo.getUltimaManutencaoVeiculo());
		
		JLabel lblDiaria = new JLabel("Diária: " + controladorInformacoesVeiculo.getDiariaVeiculo());
		
		JLabel lblPreco = new JLabel("Preço: " + controladorInformacoesVeiculo.getPrecoVeiculo());
		
		JLabel lblDisponivel = new JLabel(controladorInformacoesVeiculo.getTextoVeiculoDisponivel());
		lblDisponivel.setForeground(controladorInformacoesVeiculo.veiculoEstaDisponivel() ? new Color(0, 100, 0) : Color.RED);
		
		JButton btnVoltar = new JButton("Voltar");
		criarBotaoVoltar(btnVoltar);
		
		JLabel lblTxtDisponivel = new JLabel("Disponivel:");
		
		JButton btnEnviarParaManutencao = new JButton("Enviar Para Manutenção");
		criarBotaoEnviarManutencao(btnEnviarParaManutencao);
		btnEnviarParaManutencao.setVisible(isVeiculoDisponivel(veiculo) && !controladorInformacoesVeiculo.veiculoVendido());
		
		JButton btnRemoverDaManutencao = new JButton("Remover da Manutenção");
		criarBotaoRemoverManutencao(btnRemoverDaManutencao);
		btnRemoverDaManutencao.setVisible(!isVeiculoDisponivel(veiculo) && !controladorInformacoesVeiculo.veiculoVendido());
		
		JLabel lblVendido = new JLabel("Vendido: " + controladorInformacoesVeiculo.isVeiculoVendido());
		
		JButton btnVender = new JButton("Vender");
		criarBotaoVender(btnVender);
		btnVender.setVisible((controladorInformacoesVeiculo.isVeiculoVendido().equals("Sim") ? false : true));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMarca)
							.addGap(18)
							.addComponent(lblModelo))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAnoano)
							.addGap(23)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnVoltar)
							.addGap(28)
							.addComponent(btnEnviarParaManutencao)
							.addGap(18)
							.addComponent(btnRemoverDaManutencao))
						.addComponent(lblPlaca)
						.addComponent(lblltimaManutencao)
						.addComponent(lblDiaria)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTxtDisponivel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDisponivel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPreco)
									.addGap(42)
									.addComponent(lblVendido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblNome, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVender)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(lblModelo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblAnoano))
					.addGap(12)
					.addComponent(lblPlaca)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblltimaManutencao)
					.addGap(18)
					.addComponent(lblDiaria)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreco)
						.addComponent(lblVendido)
						.addComponent(btnVender))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTxtDisponivel)
						.addComponent(lblDisponivel))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnEnviarParaManutencao)
						.addComponent(btnRemoverDaManutencao))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	private void criarBotaoVender(JButton btnVender)
	{
		btnVender.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controladorPagamento.venderCarro(controladorInformacoesVeiculo.getVeiculo());
				
				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso.");

				dispose();
			}
		});
	}

	private void criarBotaoRemoverManutencao(JButton btnRemoverDaManuteno)
	{
		btnRemoverDaManuteno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					controladorInformacoesVeiculo.removerManutencao();
					
					JOptionPane.showMessageDialog(null, "Veiculo removido da manutenção.");

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


	private void criarBotaoEnviarManutencao(JButton btnEnviarParaManutencao)
	{
		btnEnviarParaManutencao.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					controladorInformacoesVeiculo.enviarManutencao();
					
					JOptionPane.showMessageDialog(null, "Veiculo enviado para manutenção.");

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
	
	private boolean isVeiculoDisponivel(Carro veiculo)
	{
		return controladorInformacoesVeiculo.veiculoEstaDisponivel();
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
