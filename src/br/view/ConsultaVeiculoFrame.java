package br.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import br.action.ControladorConsultaVeiculo;
import br.model.Carro;
import javax.swing.JCheckBox;

public class ConsultaVeiculoFrame extends JInternalFrame {

	private static final long serialVersionUID = -3260622578112988026L;
	private JTextField txtModeloVeiculo;
	private JCheckBox chckbxSDisponveis;
	private JList<String> lstVeiculos;
	private JDesktopPane desktopPane;

	private ControladorConsultaVeiculo controladorConsultaVeiculo;

	/**
	 * Create the frame.
	 */

	@SuppressWarnings("unchecked")
	public ConsultaVeiculoFrame(final JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;

		setBorder(null);
		setClosable(true);
		setTitle("Consultar Veículo");
		setBounds(100, 100, 582, 330);

		controladorConsultaVeiculo = new ControladorConsultaVeiculo();

		lstVeiculos = new JList<String>();
		lstVeiculos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		lstVeiculos.setModel(new AbstractListModel() {
			ArrayList<String> values = controladorConsultaVeiculo
					.getTextoVeiculos();

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		lstVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel panelConsulta = new JPanel();
		panelConsulta.setBorder(null);

		JLabel lblModeloVeiculo = new JLabel("Modelo:");
		panelConsulta.add(lblModeloVeiculo);

		txtModeloVeiculo = new JTextField();
		panelConsulta.add(txtModeloVeiculo);
		txtModeloVeiculo.setColumns(11);
		
		chckbxSDisponveis = new JCheckBox("Só disponíveis");
		panelConsulta.add(chckbxSDisponveis);

		JButton btnConsultar = new JButton("Consultar");
		criarBotaoConsultar(btnConsultar);
		panelConsulta.add(btnConsultar);

		JButton btnSelecionar = new JButton("Selecionar");
		criarBotaoSelecionar(btnSelecionar, this);

		JButton btnVoltar = new JButton("Voltar");
		criarBotaoVoltar(btnVoltar);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(129)
																		.addComponent(
																				btnSelecionar)
																		.addGap(85)
																		.addComponent(
																				btnVoltar))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(6)
																		.addComponent(
																				lstVeiculos,
																				GroupLayout.DEFAULT_SIZE,
																				564,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addGap(6)
																		.addComponent(
																				panelConsulta,
																				GroupLayout.DEFAULT_SIZE,
																				564,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panelConsulta,
										GroupLayout.PREFERRED_SIZE, 38,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lstVeiculos,
										GroupLayout.PREFERRED_SIZE, 191,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnSelecionar)
												.addComponent(btnVoltar))));

		getContentPane().setLayout(groupLayout);

	}

	private void criarBotaoConsultar(JButton btnConsultar) {
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getActionCommand().equals("Consultar")) {
					controladorConsultaVeiculo.filtrarVeiculos(txtModeloVeiculo
							.getText(), chckbxSDisponveis.isSelected());
					lstVeiculos.updateUI();
				}
			}
		});
	}

	private void criarBotaoSelecionar(JButton btnSelecionar, final ConsultaVeiculoFrame frame) {
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getActionCommand().equals("Selecionar")) {
					int veiculoSelecionado = lstVeiculos
							.getAnchorSelectionIndex();
					Carro veiculo = controladorConsultaVeiculo
							.getVeiculo(veiculoSelecionado);

//					InformacoesVeiculoFrame informacoesVeiculoFrame = new InformacoesVeiculoFrame(veiculo);
//					desktopPane.add(informacoesVeiculoFrame);
//					informacoesVeiculoFrame.show();
//					informacoesVeiculoFrame.setLocation(0, 0);
				}
			}
		});
	}

	private void criarBotaoVoltar(JButton btnVoltar) {
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
	}
}
