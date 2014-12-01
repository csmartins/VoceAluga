package br.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VoceAlugaTelaPrincipal
{
	private JFrame frame;
	private JDesktopPane desktopPane;
	private JMenuItem menuItemCadastro;
	
	private CadastroClienteFrame cadastroClienteFrame;
	private CadastroVeiculoFrame cadastroVeiculoFrame;
	private ReservaVeiculoPorModeloFrame reservaVeiculoPorModeloFrame;
	private ConsultaReservaFrame consultaReservaFrame;
	private ConsultaClienteFrame consultaClienteFrame;
	private ConsultaVeiculoFrame consultaVeiculoFrame;
	private ConsultaAluguelFrame consultaAluguelFrame;

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
		
		JMenuItem menuConsultarCliente = new JMenuItem("Consultar Cliente");
		criarEventoBotaoConsutaCliente(menuConsultarCliente, desktopPane);
		menuCliente.add(menuConsultarCliente);
		
		JMenu mnVeculo = new JMenu("Veículo");
		menuBar.add(mnVeculo);
		
		JMenuItem menuItemCadastroVeiculo = new JMenuItem("Cadastro");
		criarEventoBotaoCadastroVeiculo(menuItemCadastroVeiculo, desktopPane);
		mnVeculo.add(menuItemCadastroVeiculo);
		
		JMenuItem menuConsultarVeiculo = new JMenuItem("Consultar Veículo");
		criarEventoBotaoConsutaVeiculo(menuConsultarVeiculo, desktopPane);
		mnVeculo.add(menuConsultarVeiculo);
		
		JMenu menuAluguel = new JMenu("Aluguel");
		menuBar.add(menuAluguel);
		
		JMenuItem menuReserva = new JMenuItem("Reserva");
		criarEventoBotaoReservaVeiculo(menuReserva, desktopPane);
		menuAluguel.add(menuReserva);
		
		JMenuItem menuAlugar = new JMenuItem("Consultar Alugueis");
		criarEventoBotaoConsultaAluguel(menuAlugar, desktopPane);
		menuAluguel.add(menuAlugar);
		
		JMenuItem menuConsultarReserva = new JMenuItem("Consultar Reserva");
		criarEventoBotaoConsutaReserva(menuConsultarReserva, desktopPane);
		menuAluguel.add(menuConsultarReserva);
		
		JMenu menuPagamento = new JMenu("Pagamento");
		menuBar.add(menuPagamento);
	}

	private void criarEventoBotaoConsultaAluguel(JMenuItem menuAlugar, final JDesktopPane desktopPane) {
		menuAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(consultaAluguelFrame == null || consultaAluguelFrame.isClosed())
				{
					consultaAluguelFrame = new ConsultaAluguelFrame(desktopPane);
					desktopPane.add(consultaAluguelFrame);
					consultaAluguelFrame.show();
					consultaAluguelFrame.setLocation(0,0);
				}
			}
		});
	}

	private void criarEventoBotaoReservaVeiculo(JMenuItem menuReserva, final JDesktopPane desktopPane)
	{
		menuReserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(reservaVeiculoPorModeloFrame == null || reservaVeiculoPorModeloFrame.isClosed())
				{
					reservaVeiculoPorModeloFrame = new ReservaVeiculoPorModeloFrame();
					desktopPane.add(reservaVeiculoPorModeloFrame);
					reservaVeiculoPorModeloFrame.show();
					reservaVeiculoPorModeloFrame.setLocation(0,0);
				}
			}
		});
	}
	
	private void criarEventoBotaoConsutaReserva(JMenuItem menuConsultarReserva, final JDesktopPane desktopPane)
	{
		menuConsultarReserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(consultaReservaFrame == null || consultaReservaFrame.isClosed())
				{
					consultaReservaFrame = new ConsultaReservaFrame(desktopPane);
					desktopPane.add(consultaReservaFrame);
					consultaReservaFrame.show();
					consultaReservaFrame.setLocation(0,0);
				}
			}
		});
	}
	
	private void criarEventoBotaoConsutaCliente(JMenuItem menuConsultaCliente, final JDesktopPane desktopPane)
	{
		menuConsultaCliente.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(consultaClienteFrame == null || consultaClienteFrame.isClosed())
				{
					consultaClienteFrame = new ConsultaClienteFrame(desktopPane);
					desktopPane.add(consultaClienteFrame);
					consultaClienteFrame.show();
					consultaClienteFrame.setLocation(0,0);
				}
			}
		});
	}
	
	private void criarEventoBotaoConsutaVeiculo(JMenuItem menuConsultaCliente, final JDesktopPane desktopPane)
	{
		menuConsultaCliente.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(consultaVeiculoFrame == null || consultaVeiculoFrame.isClosed())
				{
					consultaVeiculoFrame = new ConsultaVeiculoFrame(desktopPane);
					desktopPane.add(consultaVeiculoFrame);
					consultaVeiculoFrame.show();
					consultaVeiculoFrame.setLocation(0,0);
				}
			}
		});
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
