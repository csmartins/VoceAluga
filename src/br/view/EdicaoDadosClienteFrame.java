package br.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EdicaoDadosClienteFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField cmpTextCpfEdicao;

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
					EdicaoDadosClienteFrame frame = new EdicaoDadosClienteFrame();
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
	public EdicaoDadosClienteFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 628, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(166, 19, 26, 15);
		lblCpf.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblCpf);
		
		cmpTextCpfEdicao = new JTextField();
		cmpTextCpfEdicao.setBounds(210, 17, 114, 19);
		panel.add(cmpTextCpfEdicao);
		cmpTextCpfEdicao.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFiltrar.setBounds(404, 14, 117, 25);
		panel.add(btnFiltrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 77, 628, 264);
		contentPane.add(panel_1);
	}
}
