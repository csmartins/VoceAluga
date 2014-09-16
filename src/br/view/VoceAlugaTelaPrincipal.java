package br.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoceAlugaTelaPrincipal
{

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JMenuItem menuItemCadastro;
	
	private CadastroClienteFrame cadastroClienteFrame;
	private CadastroVeiculoFrame cadastroVeiculoFrame;

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
					VoceAlugaTelaPrincipal window = new VoceAlugaTelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VoceAlugaTelaPrincipal()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(12, 12, 582, 330);
		frame.getContentPane().add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuBar.add(menuCliente);
		
		JMenuItem menuItemCadastro = new JMenuItem("Cadastro");
		criarEventoBotaoCadastroCliente(menuItemCadastro, desktopPane);
		menuCliente.add(menuItemCadastro);
		
		JMenu mnVeculo = new JMenu("Veículo");
		menuBar.add(mnVeculo);
		
		JMenuItem menuItemCadastroVeiculo = new JMenuItem("Cadastro");
		criarEventoBotaoCadastroVeiculo(menuItemCadastroVeiculo, desktopPane);
		mnVeculo.add(menuItemCadastroVeiculo);
		
		JMenu menuAluguel = new JMenu("Aluguel");
		menuBar.add(menuAluguel);
		
		JMenuItem menuReserva = new JMenuItem("Reserva");
		menuAluguel.add(menuReserva);
		
		JMenuItem menuAlugar = new JMenuItem("Alugar");
		menuAluguel.add(menuAlugar);
		
		JMenu menuPagamento = new JMenu("Pagamento");
		menuBar.add(menuPagamento);
	}

	private void criarEventoBotaoCadastroVeiculo(
			JMenuItem menuItemCadastroVeiculo, final JDesktopPane desktopPane)
	{
		menuItemCadastroVeiculo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(cadastroVeiculoFrame == null || cadastroVeiculoFrame.isClosed())
				{
					cadastroVeiculoFrame = new CadastroVeiculoFrame();
					desktopPane.add(cadastroVeiculoFrame);
					cadastroVeiculoFrame.show();
					cadastroVeiculoFrame.setLocation(0, 0);
				}
			}
		});
	}

	private void criarEventoBotaoCadastroCliente(JMenuItem menuItemCadastroCliente, final JDesktopPane desktopPane)
	{
		menuItemCadastroCliente.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (cadastroClienteFrame == null || cadastroClienteFrame.isClosed())
				{
					cadastroClienteFrame = new CadastroClienteFrame();
					desktopPane.add(cadastroClienteFrame);
					cadastroClienteFrame.show();
					cadastroClienteFrame.setLocation(0, 0);
				}
			}
		});
	}

	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane)
	{
		this.desktopPane = desktopPane;
	}

	public JMenuItem getMenuItemCadastro()
	{
		return menuItemCadastro;
	}

	public void setMenuItemCadastro(JMenuItem menuItemCadastro)
	{
		this.menuItemCadastro = menuItemCadastro;
	}
}
