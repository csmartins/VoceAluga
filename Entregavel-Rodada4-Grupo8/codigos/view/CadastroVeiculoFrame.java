package br.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.action.ControladorCadastroVeiculo;
import br.utils.Utils;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;

public class CadastroVeiculoFrame extends JInternalFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 538366666404576928L;
	private JPanel contentPane;
	private JTextField cmpTextMarca;
	private JTextField cmpTextModelo;
	private JLabel lblNewLabel;
	private JTextField cmpTextPlaca;
	private JLabel lblUltimaManutencao;
	private JYearChooser cmpAno;
	private JCalendar calendarUltimaManutencao;
	private JCheckBox chckbxDisponivel;
	
	private ControladorCadastroVeiculo controladorCadastroVeiculo;
	private JTextField cmpTextPreco;
	private JTextField cmpTextDiaria;

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
					CadastroVeiculoFrame frame = new CadastroVeiculoFrame();
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
	 * 
	 */
	public CadastroVeiculoFrame()
	{
		setMaximizable(true);
		setResizable(true);
		setBorder(null);
		setClosable(true);
		setTitle("Cadastro de Veículo");
		setBounds(100, 100, 582, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(24, 12, 54, 15);
		contentPane.add(lblMarca);
		
		cmpTextMarca = new JTextField();
		cmpTextMarca.setBounds(96, 10, 114, 19);
		contentPane.add(cmpTextMarca);
		cmpTextMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(294, 14, 70, 15);
		contentPane.add(lblModelo);
		
		cmpTextModelo = new JTextField();
		cmpTextModelo.setBounds(382, 12, 114, 19);
		contentPane.add(cmpTextModelo);
		cmpTextModelo.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(24, 39, 70, 15);
		contentPane.add(lblAno);
		
		lblNewLabel = new JLabel("Placa");
		lblNewLabel.setBounds(294, 43, 70, 15);
		contentPane.add(lblNewLabel);
		
		cmpTextPlaca = new JTextField();
		cmpTextPlaca.setBounds(382, 41, 114, 19);
		contentPane.add(cmpTextPlaca);
		cmpTextPlaca.setColumns(10);
		
		lblUltimaManutencao = new JLabel("Última Manutenção");
		lblUltimaManutencao.setBounds(24, 74, 146, 15);
		contentPane.add(lblUltimaManutencao);
		
		calendarUltimaManutencao = new JCalendar();
		calendarUltimaManutencao.setBounds(34, 101, 244, 159);
		contentPane.add(calendarUltimaManutencao);
		
		cmpAno = new JYearChooser();
		cmpAno.setBounds(96, 35, 52, 19);
		contentPane.add(cmpAno);
		
		chckbxDisponivel = new JCheckBox("Disponível");
		chckbxDisponivel.setBounds(294, 70, 129, 23);
		contentPane.add(chckbxDisponivel);
		
		JButton btnSalvar = new JButton("Salvar");
		criarEventoBotaoSalvarCadastroVeiculo(btnSalvar);
		btnSalvar.setBounds(294, 217, 117, 43);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		criarBotaoCancelarCadastro(btnCancelar);
		btnCancelar.setBounds(423, 217, 117, 43);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel.setBounds(12, 59, 274, 213);
		contentPane.add(panel);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(294, 101, 70, 15);
		contentPane.add(lblPreco);
		
		cmpTextPreco = new JTextField();
		cmpTextPreco.setBounds(382, 99, 114, 19);
		contentPane.add(cmpTextPreco);
		cmpTextPreco.setColumns(10);
		
		JLabel lblDiaria = new JLabel("Diaria");
		lblDiaria.setBounds(294, 133, 70, 15);
		contentPane.add(lblDiaria);
		
		cmpTextDiaria = new JTextField();
		cmpTextDiaria.setColumns(10);
		cmpTextDiaria.setBounds(382, 130, 114, 19);
		contentPane.add(cmpTextDiaria);
	}

	private void criarEventoBotaoSalvarCadastroVeiculo(JButton btnSalvar)
	{
		controladorCadastroVeiculo = new ControladorCadastroVeiculo();
		
		btnSalvar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				validarDadosInseridos();
				
				if(controladorCadastroVeiculo.isCadastroValido())
				{
					controladorCadastroVeiculo.cadastrar(cmpTextMarca.getText(), 
														cmpTextPlaca.getText(),
														cmpTextModelo.getText(),
														cmpAno.getYear(), 
														calendarUltimaManutencao.getDate(), 
														chckbxDisponivel.isSelected(), cmpTextPreco.getText(), cmpTextDiaria.getText());
					
					Utils.exibirMensagem("Cadastro realizado com sucesso");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, Arrays.toString(controladorCadastroVeiculo.getMensagensCadastro().toArray()), "Existem problemas com o cadastro", JOptionPane.ERROR_MESSAGE);
					controladorCadastroVeiculo.limparMensagensCadastroVeiculo();
				}
					
			}

			private void validarDadosInseridos()
			{
				controladorCadastroVeiculo.validarMarca(cmpTextMarca.getText());
				controladorCadastroVeiculo.validarModelo(cmpTextModelo.getText());
				controladorCadastroVeiculo.validarPlaca(cmpTextPlaca.getText());
				controladorCadastroVeiculo.validarUltimaManutencao(calendarUltimaManutencao.getDate());
				controladorCadastroVeiculo.validarPreco(cmpTextPreco.getText());
				controladorCadastroVeiculo.validarDiaria(cmpTextDiaria.getText());
			}
		});
	}

	private void criarBotaoCancelarCadastro(JButton btnCancelar)
	{
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
	}
}
