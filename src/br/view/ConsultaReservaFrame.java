package br.view;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import br.action.ControladorConsultaReserva;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaReservaFrame extends JInternalFrame {

	private static final long serialVersionUID = -3260622578112988026L;
	private JTextField txtCpfCliente;
	private JList<String> lstReservas;
	
	private ControladorConsultaReserva controladorConsultaReserva;

	/**
	 * Create the frame.
	 */
	public ConsultaReservaFrame() {
		setBorder(null);
		setClosable(true);
		setTitle("Consultar R");
		setBounds(100, 100, 582, 330);
		
		controladorConsultaReserva = new ControladorConsultaReserva();
		
		lstReservas = new JList<String>();
		lstReservas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstReservas.setModel(new AbstractListModel() {
			ArrayList<String> values = controladorConsultaReserva.getTextoReservas();
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
		btnConsultar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) {
				if (ae.getActionCommand().equals("Consultar"))
				{
					controladorConsultaReserva.filtrarReservas(txtCpfCliente.getText());
					lstReservas.updateUI();
				}
			}
		});
		panelConsulta.add(btnConsultar);
		
		JButton btnSelecionar = new JButton("Selecionar");
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(btnSelecionar)
							.addGap(85)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lstReservas, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(panelConsulta, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelConsulta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lstReservas, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelecionar)
						.addComponent(btnCancelar)))
		);
		getContentPane().setLayout(groupLayout);

	}
}
