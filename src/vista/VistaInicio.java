package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ClientesControlador;
import controlador.InicioControlador;
import modelo.Cliente;
import javax.swing.BoxLayout;

public class VistaInicio extends JFrame {
	
	public ClientesControlador clientesControlador = new ClientesControlador();
	
	private JPanel contentPane;
	private JTable tableClientes;
	private JTextField textFieldBuscarCliente;
	private JButton btnCrearCliente;
	private JTable tableAerolineas;
	private JTextField textFieldBuscarAerolinea;
	private JTable tableVuelos;
	private JTextField textFieldBuscarVuelo;
	private JTable tableVentas;
	private JTextField textFieldBuscarVenta;
	private JTable tableProvincias;
	private JTable tablePaises;
	private JTable tableAeropuertos;

	/**
	 * Create the frame.
	 */
	
	public VistaInicio(InicioControlador controlador) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		tableClientes = new JTable();
		panel.add(tableClientes, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		btnCrearCliente = new JButton("Nuevo cliente");
		btnCrearCliente.addActionListener(new VistaInicioActions(this));
		panel_1.add(btnCrearCliente);
		
		textFieldBuscarCliente = new JTextField();
		panel_1.add(textFieldBuscarCliente);
		textFieldBuscarCliente.setColumns(25);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		panel_1.add(btnBuscarCliente);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Aerolineas", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tableAerolineas = new JTable();
		panel_2.add(tableAerolineas, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnCrearAerolinea = new JButton("Nueva aerol\u00EDnea");
		panel_8.add(btnCrearAerolinea);
		
		textFieldBuscarAerolinea = new JTextField();
		panel_8.add(textFieldBuscarAerolinea);
		textFieldBuscarAerolinea.setColumns(10);
		
		JButton btnBuscarAerolinea = new JButton("Buscar");
		panel_8.add(btnBuscarAerolinea);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Vuelos", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		tableVuelos = new JTable();
		panel_3.add(tableVuelos, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnCrearVuelo = new JButton("Nuevo vuelo");
		panel_9.add(btnCrearVuelo);
		
		textFieldBuscarVuelo = new JTextField();
		panel_9.add(textFieldBuscarVuelo);
		textFieldBuscarVuelo.setColumns(10);
		
		JButton btnBuscarVuelo = new JButton("Buscar");
		panel_9.add(btnBuscarVuelo);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		tableVentas = new JTable();
		panel_4.add(tableVentas, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnCrearVenta = new JButton("New button");
		panel_10.add(btnCrearVenta);
		
		textFieldBuscarVenta = new JTextField();
		panel_10.add(textFieldBuscarVenta);
		textFieldBuscarVenta.setColumns(10);
		
		JButton btnBuscarVenta = new JButton("New button");
		panel_10.add(btnBuscarVenta);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Provincias", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		tableProvincias = new JTable();
		panel_5.add(tableProvincias, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Pa\u00EDses", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		tablePaises = new JTable();
		panel_6.add(tablePaises, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Aeropuertos", null, panel_7, null);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		tableAeropuertos = new JTable();
		panel_7.add(tableAeropuertos, BorderLayout.CENTER);
		
		
		recargarTablaClientes();
	}
	
	
	public void recargarTablaClientes()
	{
		List<Cliente> clientes = clientesControlador.obtenerListaClientes();
				
		String[] columnas = {"Nombre", "DNI", "Fecha nacimiento", "E-mail"};
		
		String[][] datos = new String[clientes.size()][4];
		
		for(int i = 0; i<clientes.size(); i++) 
		{
			Cliente cliente = clientes.get(i);
			datos[i] = new String[] {"a"};
		}
		
		
		System.out.println(datos);
	}
	
	
	public JButton getAgregarCliente() {
		return this.btnCrearCliente;
		
		
	}
	
	

}
