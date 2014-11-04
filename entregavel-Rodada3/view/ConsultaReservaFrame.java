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

import br.action.ControladorConsultaReserva;
import br.model.Reserva;

public class ConsultaReservaFrame extends JInternalFrame {

	private static final long serialVersionUID = -3260622578112988026L;
	private JTextField txtCpfCliente;
	private JList<String> lstReservas;
	private JDesktopPane desktopPane;

	private ControladorConsultaReserva controladorConsultaReserva;

	/**
	 * Create the frame.
	 */

	@SuppressWarnings("unchecked")
	public ConsultaReservaFrame(final JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;

		setBorder(null);
		setClosable(true);
		setTitle("Consultar Reserva");
		setBounds(100, 100, 582, 330);

		controladorConsultaReserva = new ControladorConsultaReserva();

		lstReservas = new JList<String>();
		lstReservas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		lstReservas.setModel(new AbstractListModel() {
			ArrayList<String> values = controladorConsultaReserva
					.getTextoReservas();

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		lstReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel panelConsulta = new JPanel();
		panelConsulta.setBorder(null);

		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente:");
		panelConsulta.add(lblCpfDoCliente);

		txtCpfCliente = new JTextField();
		panelConsulta.add(txtCpfCliente);
		txtCpfCliente.setColumns(11);

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
																				lstReservas,
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
								.addComponent(lstReservas,
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
					controladorConsultaReserva.filtrarReservas(txtCpfCliente
							.getText());
					lstReservas.updateUI();
				}
			}
		});
	}

	private void criarBotaoSelecionar(JButton btnSelecionar, final ConsultaReservaFrame frame) {
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getActionCommand().equals("Selecionar")) {
					int reservaSelecionada = lstReservas
							.getAnchorSelectionIndex();
					Reserva reserva = controladorConsultaReserva
							.getReserva(reservaSelecionada);

					InformacoesReservaFrame informacoesReservaFrame = new InformacoesReservaFrame(
							reserva, frame);
					desktopPane.add(informacoesReservaFrame);
					informacoesReservaFrame.show();
					informacoesReservaFrame.setLocation(0, 0);
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

	public void atualizarListaReservas() {
		if (txtCpfCliente.getText() == null
				|| txtCpfCliente.getText().equals("")) {
			controladorConsultaReserva.atualizarListadeReservas();
		} else {
			controladorConsultaReserva.filtrarReservas(txtCpfCliente.getText());
		}

		lstReservas.updateUI();
	}
}
