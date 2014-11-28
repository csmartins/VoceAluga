package br.view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import br.action.ControladorInformacoesReserva;
import br.model.Reserva;
import br.utils.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacoesReservaFrame extends JInternalFrame {
	private ControladorInformacoesReserva controladorInformacoesReserva;
	private ConsultaReservaFrame frameConsultaReserva;

	/**
	 * Create the frame.
	 */
	public InformacoesReservaFrame(Reserva reserva, ConsultaReservaFrame frameConsultaReserva) {
		this.frameConsultaReserva = frameConsultaReserva;
		
		setBorder(null);
		setClosable(true);
		setBounds(100, 100, 582, 330);
		setTitle("Informações da Reserva");

		controladorInformacoesReserva = new ControladorInformacoesReserva(reserva);
		
		JPanel pnlInfoCliente = new JPanel();
		pnlInfoCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel pnlInfoCarro = new JPanel();
		pnlInfoCarro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel pnlInfoReserva = new JPanel();
		pnlInfoReserva.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnVoltar = new JButton("Voltar");
		criarBotaoVoltar(btnVoltar);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlInfoCliente, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlInfoCarro, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlInfoReserva, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnVoltar)
							.addGap(244))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlInfoReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlInfoCliente, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pnlInfoCarro, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVoltar)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JLabel lblInformaesDaReserva = new JLabel("Informações da Reserva");
		
		JLabel lblDataDeIncio = new JLabel("Data de Início: " + controladorInformacoesReserva.getDataInicio());
		
		JLabel lblDataDeFim = new JLabel("Data de Fim:" + controladorInformacoesReserva.getDataFim());
		
		JLabel lblPagoAntecipadamente = new JLabel("Pago antecipadamente: "  + controladorInformacoesReserva.getPagoAntecipadamente());
		
		JButton btnCancelar = new JButton("Cancelar");
		criarBotaoCancelar(btnCancelar);
		btnCancelar.setVisible(controladorInformacoesReserva.reservaPodeSerCancelada());
		
		JLabel lblValor = new JLabel("Valor: " + controladorInformacoesReserva.getValor());
		
		JButton btnAlugar = new JButton("Alugar");
		criarEventoBotaoAlugar(btnAlugar);
		GroupLayout gl_pnlInfoReserva = new GroupLayout(pnlInfoReserva);
		gl_pnlInfoReserva.setHorizontalGroup(
			gl_pnlInfoReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfoReserva.createSequentialGroup()
					.addGroup(gl_pnlInfoReserva.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlInfoReserva.createSequentialGroup()
							.addGap(45)
							.addComponent(lblInformaesDaReserva))
						.addGroup(gl_pnlInfoReserva.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_pnlInfoReserva.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataDeFim)
								.addComponent(lblDataDeIncio)
								.addComponent(lblValor)
								.addComponent(lblPagoAntecipadamente)
								.addGroup(gl_pnlInfoReserva.createSequentialGroup()
									.addComponent(btnCancelar)
									.addGap(34)
									.addComponent(btnAlugar)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlInfoReserva.setVerticalGroup(
			gl_pnlInfoReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfoReserva.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformaesDaReserva)
					.addGap(18)
					.addComponent(lblDataDeIncio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDataDeFim)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPagoAntecipadamente)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(gl_pnlInfoReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAlugar))
					.addContainerGap())
		);
		pnlInfoReserva.setLayout(gl_pnlInfoReserva);
		
		JLabel lblInformaesDoVeiculo = new JLabel("Informações do Veículo");
		
		JLabel lblMarca = new JLabel("Marca: " + controladorInformacoesReserva.getMarcaCarro());
		
		JLabel lblModelo = new JLabel("Modelo: " + controladorInformacoesReserva.getModeloCarro());
		
		JLabel lblDiria = new JLabel("Diária: " + controladorInformacoesReserva.getDiariaCarro());
		GroupLayout gl_pnlInfoCarro = new GroupLayout(pnlInfoCarro);
		gl_pnlInfoCarro.setHorizontalGroup(
			gl_pnlInfoCarro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlInfoCarro.createSequentialGroup()
					.addGroup(gl_pnlInfoCarro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlInfoCarro.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMarca))
						.addGroup(gl_pnlInfoCarro.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblModelo))
						.addGroup(gl_pnlInfoCarro.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDiria))
						.addGroup(gl_pnlInfoCarro.createSequentialGroup()
							.addGap(55)
							.addComponent(lblInformaesDoVeiculo)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_pnlInfoCarro.setVerticalGroup(
			gl_pnlInfoCarro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfoCarro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformaesDoVeiculo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMarca)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblModelo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDiria)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		pnlInfoCarro.setLayout(gl_pnlInfoCarro);
		
		JLabel lblInformaoesDoCliente = new JLabel("Informaçoes do Cliente");
		
		JLabel lblNome = new JLabel("Nome: " + controladorInformacoesReserva.getNomeCliente());
		
		JLabel lblCpf = new JLabel("CPF: " + controladorInformacoesReserva.getCpfCliente());
		
		JLabel lblCarteira = new JLabel("Carteira: " + controladorInformacoesReserva.getCarteiraCliente());
		GroupLayout gl_pnlInfoCliente = new GroupLayout(pnlInfoCliente);
		gl_pnlInfoCliente.setHorizontalGroup(
			gl_pnlInfoCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfoCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlInfoCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblCpf)
						.addComponent(lblCarteira))
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlInfoCliente.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addComponent(lblInformaoesDoCliente)
					.addGap(57))
		);
		gl_pnlInfoCliente.setVerticalGroup(
			gl_pnlInfoCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfoCliente.createSequentialGroup()
					.addGap(11)
					.addComponent(lblInformaoesDoCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCarteira)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		pnlInfoCliente.setLayout(gl_pnlInfoCliente);
		getContentPane().setLayout(groupLayout);
	}

	private void criarEventoBotaoAlugar(JButton btnAlugar) {
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorInformacoesReserva.alugar();
				
				Utils.exibirMensagem("Carro alugado com sucesso");
				frameConsultaReserva.atualizarListaReservas();
				dispose();
			}
		});
	}

	private void criarBotaoCancelar(JButton btnCancelar) {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				controladorInformacoesReserva.cancelar();
				
				Utils.exibirMensagem("Reserva cancelada com sucesso");
				frameConsultaReserva.atualizarListaReservas();
				dispose();
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
