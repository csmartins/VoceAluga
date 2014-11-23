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
import javax.swing.LayoutStyle.ComponentPlacement;

import br.action.ControladorInformacoesVeiculo;
import br.model.Carro;

public class InformacoesVeiculoFrame extends JInternalFrame {
	private static final long serialVersionUID = 945196386534467283L;
	
	private ControladorInformacoesVeiculo controladorInformacoesVeiculo;

	/**
	 * Create the frame.
	 */
	public InformacoesVeiculoFrame(Carro veiculo) {
		controladorInformacoesVeiculo = new ControladorInformacoesVeiculo(veiculo);

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
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMarca)
							.addGap(18)
							.addComponent(lblModelo))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAnoano)
							.addGap(23)
							.addComponent(label))
						.addComponent(btnVoltar)
						.addComponent(lblPlaca)
						.addComponent(lblltimaManutencao)
						.addComponent(lblDiaria)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTxtDisponivel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDisponivel))
						.addComponent(lblPreco))
					.addContainerGap(247, Short.MAX_VALUE))
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
					.addComponent(lblPreco)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTxtDisponivel)
						.addComponent(lblDisponivel))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

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
