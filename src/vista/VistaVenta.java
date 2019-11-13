package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClientesControlador;
import controlador.VentasControlador;
import controlador.VueloControlador;
import modelo.Cliente;
import modelo.Vuelo;
import util.ComboItem;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaVenta extends JFrame {

	
	public VentasControlador ventasControlador;
	public ClientesControlador clienteControlador = new ClientesControlador();
	public VueloControlador vuelosControlador = new VueloControlador();
	
	
	private JPanel contentPane;
	public JTextField textFieldMontoArs;
	public JComboBox comboBoxMedioPago;
	public JButton btnAceptar;
	public JComboBox comboBoxCuotas;
	public JComboBox comboBoxVuelo;
	public JComboBox comboBoxCliente;
	public JComboBox comboBoxAsiento;
	

	/**
	 * Create the frame.
	 */
	public VistaVenta(VentasControlador ventasControlador) {
		
		
		this.ventasControlador = ventasControlador;
		
		VistaVentaActions actions = new VistaVentaActions(this);
		
		
		setTitle("Venta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Realizar venta");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDelCliente.setBounds(44, 25, 194, 20);
		panel.add(lblDatosDelCliente);
		
		JLabel lblMontoars = new JLabel("Monto (ARS)");
		lblMontoars.setBounds(44, 196, 70, 14);
		panel.add(lblMontoars);
		
		textFieldMontoArs = new JTextField();
		textFieldMontoArs.setColumns(10);
		textFieldMontoArs.setBounds(145, 193, 137, 20);
		panel.add(textFieldMontoArs);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(44, 72, 70, 14);
		panel.add(lblNewLabel);
		
		comboBoxVuelo = new JComboBox();
		comboBoxVuelo.setBounds(145, 100, 436, 20);
		panel.add(comboBoxVuelo);
		
		JLabel lblVuelo = new JLabel("Vuelo");
		lblVuelo.setBounds(44, 103, 70, 14);
		panel.add(lblVuelo);
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(145, 69, 436, 20);
		panel.add(comboBoxCliente);
		
		comboBoxMedioPago = new JComboBox();
		comboBoxMedioPago.setBounds(145, 162, 436, 20);
		comboBoxMedioPago.addItem(new ComboItem(0, "Contado efectivo"));
		comboBoxMedioPago.addItem(new ComboItem(1, "Tarjeta de crédito/débito"));
		
		panel.add(comboBoxMedioPago);
		
		JLabel lblMedioDePago = new JLabel("Medio de pago");
		lblMedioDePago.setBounds(44, 165, 70, 14);
		panel.add(lblMedioDePago);
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(456, 199, 70, 14);
		panel.add(lblCuotas);
		
		comboBoxCuotas = new JComboBox();
		comboBoxCuotas.addItem(new ComboItem(1, "1"));
		comboBoxCuotas.setBounds(520, 196, 61, 20);
		panel.add(comboBoxCuotas);
		
		comboBoxAsiento = new JComboBox();
		comboBoxAsiento.setBounds(145, 131, 436, 20);
		comboBoxAsiento.addItem(new ComboItem(0, "Economy"));
		panel.add(comboBoxAsiento);
		
		JLabel lblCategoraAsiento = new JLabel("Categor\u00EDa asiento");
		lblCategoraAsiento.setBounds(44, 134, 91, 14);
		panel.add(lblCategoraAsiento);
		
		btnAceptar = new JButton("Registrar");
		btnAceptar.addActionListener(actions);
		btnAceptar.setBounds(456, 250, 125, 29);
		panel.add(btnAceptar);
		
		comboBoxMedioPago.addActionListener(actions);
		
		
		cargarCampoClientes();
		cargarCampoVuelos();
	}
	
	
	
	
	private void cargarCampoClientes()
	{
		List<Cliente> clientes = clienteControlador.obtenerTodosConPasaportes();
		
		this.comboBoxCliente.addItem(new ComboItem(-1, "Seleccionar"));
		for(Cliente cliente: clientes) {
			ComboItem item = new ComboItem(cliente.getId(), cliente.getNombreYApellido() + " - Pasaporte: " + cliente.getPasaporte().getNumero() + ". Vto: " + cliente.getPasaporte().getFechVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			this.comboBoxCliente.addItem(item);
		}
		
	}

	private void cargarCampoVuelos()
	{
		List<Vuelo> vuelos = vuelosControlador.obtenerTodosDetallados();
		
		this.comboBoxVuelo.addItem(new ComboItem(-1, "Seleccionar"));
		for(Vuelo vuelo: vuelos) {
			String trayecto = vuelo.getAeropSalida().getIdentificacion() + " -> " + vuelo.getAeropLlegada().getIdentificacion();
			String fechaSalida = vuelo.getFechaHoraSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
			this.comboBoxVuelo.addItem(new ComboItem(vuelo.getId(), vuelo.getNumero() + " - " + trayecto + ". Salida: " + fechaSalida));
		}
		
	}
	
	
}
