package br.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.action.ControladorReservaVeiculoPorModelo;
import br.model.GruposCarro;
import br.utils.Utils;

import com.toedter.calendar.JDateChooser;

public class ReservaVeiculoPorModeloFrame extends JInternalFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4554087699882488376L;
	private JTextField cmpTextCPF;

	private JTextField cmpTextMarca;
	private JTextField cmpTextModelo;
	JDateChooser dtChooserDataFim;
	JDateChooser dtChooserDataInicio;
	
	private ControladorReservaVeiculoPorModelo controladorReservaVeiculoPorModelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ReservaVeiculoPorModeloFrame frame = new ReservaVeiculoPorModeloFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservaVeiculoPorModeloFrame()
	{
		setBorder(null);
		setClosable(true);
		setTitle("Reserva Por Modelo");
		setBounds(100, 100, 582, 330);
		getContentPane().setLayout(null);
		
		JButton btnReservar = new JButton("Reservar");
		criarEventoBotaoReservar(btnReservar);
		btnReservar.setBounds(152, 243, 130, 42);
		getContentPane().add(btnReservar);
		
		JButton btnCancelar = new JButton("Cancelar");
		criarEventoBotaoCancelar(btnCancelar);
		btnCancelar.setBounds(332, 243, 138, 42);
		getContentPane().add(btnCancelar);
		DefaultComboBoxModel<GruposCarro> comboBoxModel = new DefaultComboBoxModel<GruposCarro>(GruposCarro.values());
		
		JPanel panelDadosPessoa = new JPanel();
		panelDadosPessoa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDadosPessoa.setBounds(12, 12, 558, 52);
		getContentPane().add(panelDadosPessoa);
		panelDadosPessoa.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(100, 23, 36, 15);
		panelDadosPessoa.add(lblCpf);
		
		cmpTextCPF = new JTextField();
		cmpTextCPF.setBounds(142, 21, 114, 19);
		panelDadosPessoa.add(cmpTextCPF);
		cmpTextCPF.setColumns(10);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setBounds(0, 0, 127, 19);
		panelDadosPessoa.add(lblDadosPessoais);
		
		JPanel panelDadosVeiculo = new JPanel();
		panelDadosVeiculo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDadosVeiculo.setBounds(12, 71, 558, 78);
		getContentPane().add(panelDadosVeiculo);
		panelDadosVeiculo.setLayout(null);
		
		JLabel lblDadosVeiculo = new JLabel("Dados Veiculo");
		lblDadosVeiculo.setBounds(0, 0, 101, 21);
		panelDadosVeiculo.add(lblDadosVeiculo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 33, 70, 15);
		panelDadosVeiculo.add(lblMarca);
		
		cmpTextMarca = new JTextField();
		cmpTextMarca.setBounds(98, 31, 114, 19);
		panelDadosVeiculo.add(cmpTextMarca);
		cmpTextMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(246, 33, 70, 15);
		panelDadosVeiculo.add(lblModelo);
		
		cmpTextModelo = new JTextField();
		cmpTextModelo.setBounds(334, 31, 114, 19);
		panelDadosVeiculo.add(cmpTextModelo);
		cmpTextModelo.setColumns(10);
		
		JPanel panelDuracao = new JPanel();
		panelDuracao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDuracao.setBounds(12, 157, 558, 74);
		getContentPane().add(panelDuracao);
		panelDuracao.setLayout(null);
		
		JLabel lblDuraoDaReserva = new JLabel("Duração da Reserva");
		lblDuraoDaReserva.setBounds(0, 0, 151, 15);
		panelDuracao.add(lblDuraoDaReserva);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(312, 26, 70, 15);
		panelDuracao.add(lblDataFim);
		
		dtChooserDataFim = new JDateChooser();
		dtChooserDataFim.setBounds(383, 26, 94, 19);
		panelDuracao.add(dtChooserDataFim);
		
		dtChooserDataInicio = new JDateChooser();
		dtChooserDataInicio.setBounds(152, 26, 94, 19);
		panelDuracao.add(dtChooserDataInicio);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(67, 27, 84, 15);
		panelDuracao.add(lblDataInicio);

	}

	private void criarEventoBotaoCancelar(JButton btnCancelar) 
	{
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
	}

	private void criarEventoBotaoReservar(JButton btnReservar)
	{
		controladorReservaVeiculoPorModelo = new ControladorReservaVeiculoPorModelo();
		
		btnReservar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				validarDadosInseridos();
				
				if(controladorReservaVeiculoPorModelo.isReservaValida())
				{
					controladorReservaVeiculoPorModelo.cadastrar(cmpTextCPF.getText(), cmpTextMarca.getText(), cmpTextModelo.getText(), dtChooserDataInicio.getDate(), dtChooserDataFim.getDate());
					
				
					Utils.exibirMensagem("Reserva realizada com sucesso");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, Arrays.toString(controladorReservaVeiculoPorModelo.getMensagensReserva().toArray()), "Existem problemas com a reserva", JOptionPane.ERROR_MESSAGE);
					
					controladorReservaVeiculoPorModelo.limparMensagensReserva();
					
					controladorReservaVeiculoPorModelo.setReservaValida(true);
				}
			}

			private void validarDadosInseridos()
			{
				controladorReservaVeiculoPorModelo.validarCPF(cmpTextCPF.getText());
				controladorReservaVeiculoPorModelo.validarMarca(cmpTextMarca.getText());
				controladorReservaVeiculoPorModelo.validarModelo(cmpTextModelo.getText());
				
				controladorReservaVeiculoPorModelo.validarDatas(dtChooserDataInicio.getDate(), dtChooserDataFim.getDate());
				
				controladorReservaVeiculoPorModelo.validarMarcaEModelo(cmpTextMarca.getText(), cmpTextModelo.getText());
				
				controladorReservaVeiculoPorModelo.verificarClienteCadastrado(cmpTextCPF.getText());
				
				controladorReservaVeiculoPorModelo.verificarClienteNaListaNegra(cmpTextCPF.getText());
			}
		});
	}
}
