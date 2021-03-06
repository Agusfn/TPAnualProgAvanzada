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
import controlador.VentasControlador;
import controlador.VueloControlador;
import modelo.Aerolinea;
import modelo.Aeropuerto;
import modelo.Cliente;
import modelo.Pais;
import modelo.Provincia;
import modelo.Venta;
import modelo.Vuelo;
import javax.swing.ListSelectionModel;

public class VistaInicio extends JFrame {
	
	public ClientesControlador clientesControlador = new ClientesControlador(this);
	public PaisesControlador paisesControlador = new PaisesControlador();
	public AeropuertosControlador aeropuertosControlador = new AeropuertosControlador();
	public ProvinciasControlador provinciasControlador = new ProvinciasControlador();
	public AerolineasControlador aerolineaControlador = new AerolineasControlador(this);
	public VueloControlador vueloControlador = new VueloControlador();
	public VentasControlador ventasControlador = new VentasControlador(this);

	
	public JPanel contentPane;
	public JTable tableClientes;
	public JButton btnCrearCliente;
	public JTable tableAerolineas;
	public JTable tableVuelos;
	public JTable tableVentas;
	public JTable tableProvincias;
	public JTable tablePaises;
	public JTable tableAeropuertos;
	public JButton btnCrearAerolinea;
	public JButton btnModificarCliente;
	public JButton btnEliminarCliente;
	public JButton btnCrearVenta;
	public JButton btnDetallesVenta;
	
	/**
	 * Create the frame.
	 */
	
	public VistaInicio(InicioControlador controlador) {
		
		VistaInicioActions actions = new VistaInicioActions(this);
		
		
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
		btnCrearCliente.addActionListener(actions);
		panel_1.add(btnCrearCliente);
		
		btnModificarCliente = new JButton("Modificar seleccionado");
		btnModificarCliente.addActionListener(actions);
		panel_1.add(btnModificarCliente);
		
		btnEliminarCliente = new JButton("Eliminar seleccionado");
		btnEliminarCliente.addActionListener(actions);
		panel_1.add(btnEliminarCliente);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel.add(scrollPane_6, BorderLayout.CENTER);
		
		
		tableClientes = new JTable();
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		btnCrearAerolinea.addActionListener(actions);
		panel_8.add(btnCrearAerolinea);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_2.add(scrollPane_5, BorderLayout.CENTER);
		
		tableAerolineas = new JTable();
		tableAerolineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAerolineas.setFillsViewportHeight(true);
		scrollPane_5.setViewportView(tableAerolineas);
		
		//####################################################################\\
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Vuelos", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_3.add(scrollPane_4, BorderLayout.CENTER);
		
		tableVuelos = new JTable();
		tableVuelos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVuelos.setFillsViewportHeight(true);
		scrollPane_4.setViewportView(tableVuelos);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnCrearVenta = new JButton("Alta venta");
		btnCrearVenta.addActionListener(actions);
		panel_10.add(btnCrearVenta);
		
		btnDetallesVenta = new JButton("Ver detalles");
		panel_10.add(btnDetallesVenta);
		btnDetallesVenta.addActionListener(actions);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3, BorderLayout.CENTER);
		
		tableVentas = new JTable();
		tableVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVentas.setFillsViewportHeight(true);
		scrollPane_3.setViewportView(tableVentas);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Provincias", null, panel_5, null);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_5.add(scrollPane_2);
		
		tableProvincias = new JTable();
		tableProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProvincias.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(tableProvincias);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Pa\u00EDses", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		
		tablePaises = new JTable();
		tablePaises.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tablePaises);
		tablePaises.setFillsViewportHeight(true);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Aeropuertos", null, panel_7, null);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_7.add(scrollPane);
		
		tableAeropuertos = new JTable();
		tableAeropuertos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAeropuertos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableAeropuertos);
		
		
		recargarTablaClientes();
		recargarTablaProvincias();
		recargarTablaPaises();
		recargarTablaAeropuertos();
		recargarTablaAerolineas();
		recargarTablaVentas();
		recargarTablaVuelos();
		
	}
	
	
	/**
	 * Obtener clientes (con sus pasaportes) y cargarlos en la tabla.
	 */
	public void recargarTablaClientes()
	{
		List<Cliente> clientes = clientesControlador.obtenerTodosConPasaportes();
				
		String[] columnas = {"ID", "Nombre y apellido", "DNI", "Fecha nacimiento", "E-mail", "Nro pasaporte"};
		
		String[][] datos = new String[clientes.size()][6];
		
		for(int i = 0; i<clientes.size(); i++) 
		{
			Cliente cliente = clientes.get(i);
			datos[i] = new String[] { 
					Integer.toString(cliente.getId()),
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
	
	
	
	public void recargarTablaVuelos()
	{
		List<Vuelo> vuelos = vueloControlador.obtenerTodosDetallados();
		
		String[] columnas = {"ID", "Aerol�nea", "N�mero", "Asientos", "Aerop salida", "Aerop llegada", "Fecha salida", "Fecha llegada", "Tiempo vuelo"};
		String[][] datos = new String[vuelos.size()][9];
		
		for(int i = 0; i<vuelos.size(); i++) 
		{
			Vuelo vuelo = vuelos.get(i);
			
			datos[i] = new String[] { 
				Integer.toString(vuelo.getId()),
				vuelo.getAerolinea().getNombre(),
				vuelo.getNumero(),
				Integer.toString(vuelo.getCantAsientos()),
				vuelo.getAeropSalida().getIdentificacion(),
				vuelo.getAeropLlegada().getIdentificacion(),
				vuelo.getFechaHoraSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
				vuelo.getFechaHoraLlegada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
				Integer.toString(vuelo.getTiempoVueloMinutos())
			};
		}
		
		recargarDatosTabla(tableVuelos, columnas, datos);
	}

	
	
	
	/**
	 * Obtener ventas y cargar tabla de ventas.
	 */
	public void recargarTablaVentas() 
	{
		List<Venta> ventas = this.ventasControlador.obtenerTodasConDetalles();
		
		String[] columnas = {"ID", "Fecha compra", "Cliente", "Nro vuelo", "Trayecto", "Hora salida", "Monto ARS", "Forma pago", "Cuotas"};
		String[][] datos = new String[ventas.size()][9];
		
		for(int i = 0; i<ventas.size(); i++) 
		{
			Venta venta = ventas.get(i);
			datos[i] = new String[] { 
					Integer.toString(venta.getId()),
					venta.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					venta.getCliente().getNombreYApellido(),
					venta.getVuelo().getNumero(),
					venta.getVuelo().getAeropSalida().getIdentificacion() + " -> " + venta.getVuelo().getAeropLlegada().getIdentificacion(),
					venta.getVuelo().getFechaHoraSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
					Double.toString(venta.getMonto()),
					venta.getFormaDePago(),
					Integer.toString(venta.getCuotas())
					
			};
		}
		
		recargarDatosTabla(tableVentas, columnas, datos);
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
