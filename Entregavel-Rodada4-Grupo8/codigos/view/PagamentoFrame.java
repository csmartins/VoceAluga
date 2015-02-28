package br.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.action.ControladorPagamento;
import br.model.Carro;
import br.utils.Utils;
import javax.swing.JTextField;

public class PagamentoFrame extends JInternalFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7804070124138947416L;

	private Carro veiculo;
	
	private ControladorPagamento controladorPagamento;
	private JTextField cmpTextParcelas;
	
	public PagamentoFrame(Carro veiculo)
	{
		this.veiculo = veiculo;
		
		controladorPagamento = new ControladorPagamento();
		
		setBorder(null);
		setClosable(true);
		setTitle("Venda de Veículo");
		setBounds(100, 100, 582, 330);
		getContentPane().setLayout(null);
		
		JPanel panelPagarNoCredito = new JPanel();
		panelPagarNoCredito.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarNoCredito.setBounds(12, 194, 558, 79);
		getContentPane().add(panelPagarNoCredito);
		panelPagarNoCredito.setLayout(null);
		
		JLabel lblPagamentoNoCrdito = new JLabel("PAGAMENTO NO CRÉDITO");
		lblPagamentoNoCrdito.setBounds(192, 6, 174, 15);
		panelPagarNoCredito.add(lblPagamentoNoCrdito);
		
		JButton button = new JButton("Pagar");
		criarBotaoPagarNoCredito(button);
		button.setBounds(304, 42, 116, 25);
		panelPagarNoCredito.add(button);
		
		cmpTextParcelas = new JTextField();
		cmpTextParcelas.setBounds(178, 45, 114, 19);
		panelPagarNoCredito.add(cmpTextParcelas);
		cmpTextParcelas.setColumns(10);
		
		JLabel lblParcelas = new JLabel("Parcelas");
		lblParcelas.setBounds(90, 47, 70, 15);
		panelPagarNoCredito.add(lblParcelas);
		
		JPanel panelPagarNoDebito = new JPanel();
		panelPagarNoDebito.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarNoDebito.setBounds(12, 103, 558, 79);
		getContentPane().add(panelPagarNoDebito);
		panelPagarNoDebito.setLayout(null);
		
		JLabel lblPagamentoNoDbito = new JLabel("PAGAMENTO NO DÉBITO");
		lblPagamentoNoDbito.setBounds(196, 6, 165, 15);
		panelPagarNoDebito.add(lblPagamentoNoDbito);
		
		JButton btnPagar = new JButton("Pagar");
		criarBotaoPagarNoDebito(btnPagar);
		btnPagar.setBounds(218, 42, 116, 25);
		panelPagarNoDebito.add(btnPagar);
		
		JPanel panelPagarComDinheiro = new JPanel();
		panelPagarComDinheiro.setToolTipText("Pagar com dinheiro");
		panelPagarComDinheiro.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagarComDinheiro.setBounds(12, 12, 558, 79);
		getContentPane().add(panelPagarComDinheiro);
		panelPagarComDinheiro.setLayout(null);
		
		JLabel lblPagamentoComDinheiro = new JLabel("PAGAMENTO COM DINHEIRO");
		lblPagamentoComDinheiro.setBounds(177, 12, 192, 15);
		panelPagarComDinheiro.add(lblPagamentoComDinheiro);
		
		JButton btnPagarComDinheiro = new JButton("Pagar");
		criarBotaoPagarComDinheiro(btnPagarComDinheiro);
		btnPagarComDinheiro.setBounds(215, 42, 117, 25);
		panelPagarComDinheiro.add(btnPagarComDinheiro);

	}

	private void criarBotaoPagarNoCredito(JButton button)
	{
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String parcelas = cmpTextParcelas.getText();
				
				controladorPagamento.venderCarroCredito(veiculo, parcelas);
				
				finalizarCompra();
			}
		});
	}

	private void criarBotaoPagarNoDebito(JButton btnPagar)
	{
		btnPagar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String formaPagamento = "Débito";
				
				controladorPagamento.venderCarro(veiculo, formaPagamento);
				
				finalizarCompra();
			}
		});
	}

	private void criarBotaoPagarComDinheiro(JButton btnPagarComDinheiro)
	{
		btnPagarComDinheiro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String formaPagamento = "Dinheiro";
				controladorPagamento.venderCarro(veiculo, formaPagamento);
				
				finalizarCompra();
			}
		});
	}
	
	private void finalizarCompra()
	{
		Utils.exibirMensagem("Venda realizada com sucesso. Um email foi enviado para o cliente com o relatorio da compra e a nota fiscal.");
		
		dispose();
	}
}
