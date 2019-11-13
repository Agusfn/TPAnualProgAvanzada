package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.AerolineasControlador;
import controlador.AeropuertosControlador;
import controlador.ClientesControlador;
import controlador.InicioControlador;
import controlador.PaisesControlador;
import controlador.ProvinciasControlador;
import modelo.Aerolinea;
import modelo.Aeropuerto;
import modelo.Cliente;
import modelo.Pais;
import modelo.Provincia;

public class VistaInicio extends JFrame {
	
	public ClientesControlador clientesControlador = new ClientesControlador();
	public PaisesControlador paisesControlador = new PaisesControlador();
	public AeropuertosControlador aeropuertosControlador = new AeropuertosControlador();
	public ProvinciasControlador provinciasControlador = new ProvinciasControlador();
	public AerolineasControlador aerolineaControlador = new AerolineasControlador();
	
	
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
	private JButton btnCrearAerolinea;
	

	/**
	 * Create the frame.
	 */
	
	public VistaInicio(InicioControlador controlador) {
		setTitle("Sistema aerol\u00EDnea");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		//################ CLIENTE ##############################\\
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel.add(scrollPane_6, BorderLayout.CENTER);
		
		
		tableClientes = new JTable();
		tableClientes.setFillsViewportHeight(true);
		scrollPane_6.setViewportView(tableClientes);
		
		
		//################### AEROLINEAS ################################# \\
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Aerol\u00EDneas", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnCrearAerolinea = new JButton("Nueva aerol\u00EDnea");
		btnCrearAerolinea.addActionListener(new VistaInicioActions(this));
		panel_8.add(btnCrearAerolinea);
		
		textFieldBuscarAerolinea = new JTextField();
		panel_8.add(textFieldBuscarAerolinea);
		textFieldBuscarAerolinea.setColumns(10);
		
		JButton btnBuscarAerolinea = new JButton("Buscar");
		panel_8.add(btnBuscarAerolinea);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_2.add(scrollPane_5, BorderLayout.CENTER);
		
		tableAerolineas = new JTable();
		tableAerolineas.setFillsViewportHeight(true);
		scrollPane_5.setViewportView(tableAerolineas);
		
		//####################################################################\\
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Vuelos", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
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
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_3.add(scrollPane_4, BorderLayout.CENTER);
		
		tableVuelos = new JTable();
		tableVuelos.setFillsViewportHeight(true);
		scrollPane_4.setViewportView(tableVuelos);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
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
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3, BorderLayout.CENTER);
		
		tableVentas = new JTable();
		tableVentas.setFillsViewportHeight(true);
		scrollPane_3.setViewportView(tableVentas);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Provincias", null, panel_5, null);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_5.add(scrollPane_2);
		
		tableProvincias = new JTable();
		tableProvincias.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(tableProvincias);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Pa\u00EDses", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		
		tablePaises = new JTable();
		scrollPane_1.setViewportView(tablePaises);
		tablePaises.setFillsViewportHeight(true);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Aeropuertos", null, panel_7, null);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_7.add(scrollPane);
		
		tableAeropuertos = new JTable();
		tableAeropuertos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableAeropuertos);
		
		
		recargarTablaClientes();
		recargarTablaProvincias();
		recargarTablaPaises();
		recargarTablaAeropuertos();
		recargarTablaAerolineas();
		
	}
	
	
	/**
	 * Obtener clientes (con sus pasaportes) y cargarlos en la tabla.
	 */
	public void recargarTablaClientes()
	{
		List<Cliente> clientes = clientesControlador.obtenerTodosConPasaportes();
				
		String[] columnas = {"Nombre y apellido", "DNI", "Fecha nacimiento", "E-mail", "Nro pasaporte"};
		
		String[][] datos = new String[clientes.size()][5];
		
		for(int i = 0; i<clientes.size(); i++) 
		{
			Cliente cliente = clientes.get(i);
			datos[i] = new String[] { 
					cliente.getNombreYApellido(), 
					cliente.getDni(), 
					cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					cliente.getEmail(),
					cliente.getPasaporte().getNumero()
			};
		}
		
		recargarDatosTabla(tableClientes, columnas, datos);
	}
	
	
	
	
	

	/**
	 * Obtener Aerolineas y cargarlos en la tabla.
	 */
	public void recargarTablaAerolineas()
	{
		List<Aerolinea> aerolineas = aerolineaControlador.obtenerTodosConAlianza();
				
		String[] columnas = {"Nombre Aerolinea", "Nombre Alianza"};
		
		String[][] datos = new String[aerolineas.size()][5];
		
		for(int i = 0; i<aerolineas.size(); i++) 
		{
			Aerolinea aerolinea = aerolineas.get(i);
			
			if (aerolinea.getAlianza() !=null) {
				datos[i] = new String[] { aerolinea.getNombre(), aerolinea.getAlianza().getNombre()};
			}else {
				
				datos[i] = new String[] { aerolinea.getNombre(), ""};
			}
			
		}
		
		recargarDatosTabla(tableAerolineas, columnas, datos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Obtener aeropuertos y cargar tabla.
	 */
	public void recargarTablaAeropuertos()
	{
		List<Aeropuerto> aeropuertos = aeropuertosControlador.obtenerTodos();
		
		String[] columnas = {"Identificacion", "Ciudad", "Provincia", "Pais"};
		String[][] datos = new String[aeropuertos.size()][4];
		
		for(int i = 0; i<aeropuertos.size(); i++) 
		{
			Aeropuerto aerop = aeropuertos.get(i);
			
			String nombreProvincia;
			if(aerop.getProvincia() == null) {
				nombreProvincia = aerop.getNombreProvincia();				
			} else {
				nombreProvincia = aerop.getProvincia().getNombre();
			}
			
			String nombrePais;
			if(aerop.getPais() == null) {
				nombrePais = aerop.getNombrePais();
			} else {
				nombrePais = aerop.getPais().getNombre();
			}
			
			datos[i] = new String[] { aerop.getIdentificacion(), aerop.getCiudad(), nombreProvincia, nombrePais };
		}
		
		recargarDatosTabla(tableAeropuertos, columnas, datos);
	}
	
	
	/**
	 * Obtener provincias y recargar tabla.
	 */
	public void recargarTablaProvincias()
	{
		List<Provincia> provincias = provinciasControlador.obtenerTodas();
		
		String[] columnas = {"Nombre", "Pais"};
		String[][] datos = new String[provincias.size()][2];
		
		for(int i = 0; i<provincias.size(); i++) 
		{
			datos[i] = new String[] { provincias.get(i).getNombre(), provincias.get(i).getPais().getNombre() };
		}

		recargarDatosTabla(tableProvincias, columnas, datos);
	}
	
	
	/**
	 * Obtener paises y cargar tabla de paises.
	 */
	public void recargarTablaPaises() 
	{
		List<Pais> paises = paisesControlador.obtenerTodos();
		
		String[] columnas = {"Nombre"};
		String[][] datos = new String[paises.size()][1];
		
		for(int i = 0; i<paises.size(); i++) 
		{
			datos[i] = new String[] { paises.get(i).getNombre() };
		}
		
		recargarDatosTabla(tablePaises, columnas, datos);
	}
	
	

	
	public JButton getAgregarCliente() {
		return this.btnCrearCliente;
		
	}
	
	public JButton getAgregarAerolinea() {
		return this.btnCrearAerolinea;
		
	}
	
	
	private void recargarDatosTabla(JTable tabla, String[] columnas, String[][] datos)
	{
		DefaultTableModel tableModel = new DefaultTableModel(datos, columnas);
		tabla.setModel(tableModel);
	}
}
