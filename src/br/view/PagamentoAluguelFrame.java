package br.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.action.ControladorPagamento;
import br.model.Aluguel;
import br.model.TaxaPagamento;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagamentoAluguelFrame extends JInternalFrame
{

	private Aluguel aluguel;
	
	private ControladorPagamento controladorPagamento;
	
	private JComboBox<TaxaPagamento> cmbBoxTaxaPagamento;
	
	private JCheckBox chckbxRetorno;
	private JCheckBox chckbxDanificao;
	
	private JTextField cmpTextParcelas;
	private JTextField txtParcelas;
	
	public PagamentoAluguelFrame(Aluguel aluguel)
	{
		this.aluguel = aluguel;
		
		controladorPagamento = new ControladorPagamento();
		
		setBorder(null);
		setClosable(true);
		setTitle("Pagamento de Aluguel");
		setBounds(100, 100, 582, 330);
		getContentPane().setLayout(null);
		
		JPanel panelTaxasAdicionais = new JPanel();
		panelTaxasAdicionais.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTaxasAdicionais.setBounds(12, 12, 558, 154);
		getContentPane().add(panelTaxasAdicionais);
		panelTaxasAdicionais.setLayout(null);
		
		cmbBoxTaxaPagamento = new JComboBox<TaxaPagamento>();
		DefaultComboBoxModel<TaxaPagamento> comboBoxModel = new DefaultComboBoxModel<TaxaPagamento>(TaxaPagamento.values());
		cmbBoxTaxaPagamento.setModel(comboBoxModel);
		cmbBoxTaxaPagamento.setBounds(12, 53, 110, 24);
		panelTaxasAdicionais.add(cmbBoxTaxaPagamento);
		
		JLabel lblTaxas = new JLabel("Taxas Adicionais");
		lblTaxas.setBounds(215, 12, 117, 15);
		panelTaxasAdicionais.add(lblTaxas);
		
		JLabel lblTaxaDePagamento = new JLabel("Taxa de pagamento");
		lblTaxaDePagamento.setBounds(140, 58, 147, 15);
		panelTaxasAdicionais.add(lblTaxaDePagamento);
		
		chckbxRetorno = new JCheckBox("Retorno");
		chckbxRetorno.setBounds(315, 54, 82, 23);
		panelTaxasAdicionais.add(chckbxRetorno);
		
		chckbxDanificao = new JCheckBox("Danificação");
		chckbxDanificao.setBounds(421, 54, 129, 23);
		panelTaxasAdicionais.add(chckbxDanificao);
		
		JPanel panelPagarDinheiro = new JPanel();
		panelPagarDinheiro.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarDinheiro.setBounds(12, 178, 156, 118);
		getContentPane().add(panelPagarDinheiro);
		panelPagarDinheiro.setLayout(null);
		
		JLabel lblDinheiro = new JLabel("Dinheiro");
		lblDinheiro.setBounds(43, 12, 70, 15);
		panelPagarDinheiro.add(lblDinheiro);
		
		JButton btnPagarDinheiro = new JButton("Pagar");
		criarBotaoPagarDinheiro(btnPagarDinheiro);
		btnPagarDinheiro.setBounds(12, 49, 132, 25);
		panelPagarDinheiro.add(btnPagarDinheiro);
		
		JPanel panelPagarDebito = new JPanel();
		panelPagarDebito.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarDebito.setBounds(180, 178, 156, 118);
		getContentPane().add(panelPagarDebito);
		panelPagarDebito.setLayout(null);
		
		JLabel lblDbito = new JLabel("Débito");
		lblDbito.setBounds(53, 12, 70, 15);
		panelPagarDebito.add(lblDbito);
		
		JButton btnPagarDébito = new JButton("Pagar");
		criarBotaoPagarDebito(btnPagarDébito);
		btnPagarDébito.setBounds(12, 49, 132, 25);
		panelPagarDebito.add(btnPagarDébito);
		
		JPanel panelPagarCredito = new JPanel();
		panelPagarCredito.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarCredito.setBounds(348, 178, 222, 118);
		getContentPane().add(panelPagarCredito);
		panelPagarCredito.setLayout(null);
		
		JLabel lblCrdito = new JLabel("Crédito");
		lblCrdito.setBounds(82, 12, 70, 15);
		panelPagarCredito.add(lblCrdito);
		
		txtParcelas = new JTextField();
		txtParcelas.setBounds(57, 50, 114, 19);
		panelPagarCredito.add(txtParcelas);
		txtParcelas.setColumns(10);
		
		JButton btnPagarCredito = new JButton("Pagar");
		criarBotaoPagarCredito(btnPagarCredito);
		btnPagarCredito.setBounds(12, 81, 198, 25);
		panelPagarCredito.add(btnPagarCredito);

	}

	private void criarBotaoPagarCredito(JButton btnPagarCredito)
	{
		btnPagarCredito.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String parcelas = cmpTextParcelas.getText();
				
				controladorPagamento.adicionarTaxas(aluguel, cmbBoxTaxaPagamento.getSelectedItem().toString(), chckbxRetorno.isSelected(), chckbxDanificao.isSelected());
				
				controladorPagamento.pagarAluguelCredito(aluguel, parcelas);
			}
		});
	}

	private void criarBotaoPagarDebito(JButton btnPagarDébito)
	{
		btnPagarDébito.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controladorPagamento.adicionarTaxas(aluguel, cmbBoxTaxaPagamento.getSelectedItem().toString(), chckbxRetorno.isSelected(), chckbxDanificao.isSelected());
				
				controladorPagamento.pagarAluguel(aluguel, "Débito");
			}
		});
	}

	private void criarBotaoPagarDinheiro(JButton btnPagarDinheiro)
	{
		btnPagarDinheiro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controladorPagamento.adicionarTaxas(aluguel, cmbBoxTaxaPagamento.getSelectedItem().toString(), chckbxRetorno.isSelected(), chckbxDanificao.isSelected());
				
				controladorPagamento.pagarAluguel(aluguel, "Dinheiro");
			}
		});
	}
}
