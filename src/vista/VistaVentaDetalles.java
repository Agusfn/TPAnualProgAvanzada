package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AeropuertosControlador;
import controlador.ClientesControlador;
import controlador.PasaportesControlador;
import controlador.VentasControlador;
import controlador.VueloControlador;
import modelo.Cliente;
import modelo.Venta;
import modelo.Vuelo;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VistaVentaDetalles extends JFrame {

	
	public VentasControlador ventasController;
	public PasaportesControlador pasaportesControlador = new PasaportesControlador();
	public ClientesControlador clientesControlador = new ClientesControlador();
	public VueloControlador vuelosControlador = new VueloControlador();
	public AeropuertosControlador aeropuertosControlador = new AeropuertosControlador();
	
	public JPanel contentPane;
	public JTextField textFieldClienteNombre;
	public JTextField textFieldClienteEmail;
	public JTextField textFieldClienteDni;
	public JTextField textFieldClienteFechaNac;
	public JTextField textFieldVueloNro;
	public JTextField textFieldVueloFechaSalida;
	public JTextField textFieldVueloFechaLlegada;
	public JTextField textFieldVueloTiempoMins;
	public JTextField textFieldVueloCantAsientos;
	public JTextField textFieldFechaHoraVenta;
	public JTextField textFieldFormaDePago;
	public JTextField textFieldVueloAerolinea;
	public JTextField textFieldVueloAeropSalida;
	public JTextField textFieldVueloAeropLlegada;
	public JTextField textFieldClientePasaporteNro;
	public JTextField textFieldClientePasaporteVto;
	public JTextField textFieldMonto;
	public JTextField textFieldCuotas;

	/**
	 * Create the frame.
	 */
	public VistaVentaDetalles(VentasControlador ventasController) {
		
		this.ventasController = ventasController;
		
		setTitle("Venta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del cliente");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDelCliente.setBounds(26, 157, 146, 14);
		panel.add(lblDatosDelCliente);
		
		JLabel label = new JLabel("Nombre y apellido");
		label.setBounds(26, 191, 103, 14);
		panel.add(label);
		
		textFieldClienteNombre = new JTextField();
		textFieldClienteNombre.setEditable(false);
		textFieldClienteNombre.setColumns(10);
		textFieldClienteNombre.setBounds(127, 188, 291, 20);
		panel.add(textFieldClienteNombre);
		
		JLabel label_1 = new JLabel("E-mail");
		label_1.setBounds(26, 253, 46, 14);
		panel.add(label_1);
		
		textFieldClienteEmail = new JTextField();
		textFieldClienteEmail.setEditable(false);
		textFieldClienteEmail.setColumns(10);
		textFieldClienteEmail.setBounds(127, 250, 291, 20);
		panel.add(textFieldClienteEmail);
		
		JLabel label_2 = new JLabel("DNI");
		label_2.setBounds(26, 222, 46, 14);
		panel.add(label_2);
		
		textFieldClienteDni = new JTextField();
		textFieldClienteDni.setEditable(false);
		textFieldClienteDni.setColumns(10);
		textFieldClienteDni.setBounds(127, 219, 93, 20);
		panel.add(textFieldClienteDni);
		
		textFieldClienteFechaNac = new JTextField();
		textFieldClienteFechaNac.setEditable(false);
		textFieldClienteFechaNac.setColumns(10);
		textFieldClienteFechaNac.setBounds(315, 219, 103, 20);
		panel.add(textFieldClienteFechaNac);
		
		JLabel label_3 = new JLabel("Fecha nac.");
		label_3.setBounds(230, 222, 61, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Datos del vuelo");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(26, 333, 146, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Nro de vuelo");
		label_5.setBounds(26, 369, 103, 14);
		panel.add(label_5);
		
		textFieldVueloNro = new JTextField();
		textFieldVueloNro.setEditable(false);
		textFieldVueloNro.setColumns(10);
		textFieldVueloNro.setBounds(143, 366, 70, 20);
		panel.add(textFieldVueloNro);
		
		JLabel label_6 = new JLabel("Aerop. salida");
		label_6.setBounds(26, 397, 103, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Aerop. llegada");
		label_7.setBounds(26, 428, 103, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Fecha y hora salida");
		label_8.setBounds(26, 456, 103, 14);
		panel.add(label_8);
		
		textFieldVueloFechaSalida = new JTextField();
		textFieldVueloFechaSalida.setEditable(false);
		textFieldVueloFechaSalida.setColumns(10);
		textFieldVueloFechaSalida.setBounds(143, 453, 275, 20);
		panel.add(textFieldVueloFechaSalida);
		
		JLabel label_9 = new JLabel("Fecha y hora llegada");
		label_9.setBounds(26, 484, 103, 14);
		panel.add(label_9);
		
		textFieldVueloFechaLlegada = new JTextField();
		textFieldVueloFechaLlegada.setEditable(false);
		textFieldVueloFechaLlegada.setColumns(10);
		textFieldVueloFechaLlegada.setBounds(143, 481, 275, 20);
		panel.add(textFieldVueloFechaLlegada);
		
		textFieldVueloTiempoMins = new JTextField();
		textFieldVueloTiempoMins.setEditable(false);
		textFieldVueloTiempoMins.setColumns(10);
		textFieldVueloTiempoMins.setBounds(143, 512, 86, 20);
		panel.add(textFieldVueloTiempoMins);
		
		JLabel label_10 = new JLabel("Tiempo de vuelo (min)");
		label_10.setBounds(26, 515, 114, 14);
		panel.add(label_10);
		
		textFieldVueloCantAsientos = new JTextField();
		textFieldVueloCantAsientos.setEditable(false);
		textFieldVueloCantAsientos.setColumns(10);
		textFieldVueloCantAsientos.setBounds(319, 512, 99, 20);
		panel.add(textFieldVueloCantAsientos);
		
		JLabel label_11 = new JLabel("Cant. asientos");
		label_11.setBounds(239, 515, 70, 14);
		panel.add(label_11);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de venta");
		lblFechaYHora.setBounds(26, 58, 114, 14);
		panel.add(lblFechaYHora);
		
		textFieldFechaHoraVenta = new JTextField();
		textFieldFechaHoraVenta.setEditable(false);
		textFieldFechaHoraVenta.setColumns(10);
		textFieldFechaHoraVenta.setBounds(157, 55, 261, 20);
		panel.add(textFieldFechaHoraVenta);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago");
		lblFormaDePago.setBounds(26, 86, 103, 14);
		panel.add(lblFormaDePago);
		
		textFieldFormaDePago = new JTextField();
		textFieldFormaDePago.setEditable(false);
		textFieldFormaDePago.setColumns(10);
		textFieldFormaDePago.setBounds(157, 83, 261, 20);
		panel.add(textFieldFormaDePago);
		
		JLabel lblNombreAerolnea = new JLabel("Aerol\u00EDnea");
		lblNombreAerolnea.setBounds(224, 369, 70, 14);
		panel.add(lblNombreAerolnea);
		
		textFieldVueloAerolinea = new JTextField();
		textFieldVueloAerolinea.setEditable(false);
		textFieldVueloAerolinea.setColumns(10);
		textFieldVueloAerolinea.setBounds(280, 366, 138, 20);
		panel.add(textFieldVueloAerolinea);
		
		textFieldVueloAeropSalida = new JTextField();
		textFieldVueloAeropSalida.setEditable(false);
		textFieldVueloAeropSalida.setColumns(10);
		textFieldVueloAeropSalida.setBounds(143, 394, 275, 20);
		panel.add(textFieldVueloAeropSalida);
		
		textFieldVueloAeropLlegada = new JTextField();
		textFieldVueloAeropLlegada.setEditable(false);
		textFieldVueloAeropLlegada.setColumns(10);
		textFieldVueloAeropLlegada.setBounds(143, 425, 275, 20);
		panel.add(textFieldVueloAeropLlegada);
		
		JLabel lblDetallesDeLa = new JLabel("Detalles de la venta");
		lblDetallesDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDetallesDeLa.setBounds(26, 11, 178, 35);
		panel.add(lblDetallesDeLa);
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setBounds(26, 281, 72, 14);
		panel.add(lblPasaporte);
		
		textFieldClientePasaporteNro = new JTextField();
		textFieldClientePasaporteNro.setEditable(false);
		textFieldClientePasaporteNro.setColumns(10);
		textFieldClientePasaporteNro.setBounds(127, 278, 133, 20);
		panel.add(textFieldClientePasaporteNro);
		
		textFieldClientePasaporteVto = new JTextField();
		textFieldClientePasaporteVto.setEditable(false);
		textFieldClientePasaporteVto.setColumns(10);
		textFieldClientePasaporteVto.setBounds(304, 278, 114, 20);
		panel.add(textFieldClientePasaporteVto);
		
		JLabel lblVto = new JLabel("Vto");
		lblVto.setBounds(280, 281, 22, 14);
		panel.add(lblVto);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setEditable(false);
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(157, 111, 103, 20);
		panel.add(textFieldMonto);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(26, 114, 103, 14);
		panel.add(lblMonto);
		
		textFieldCuotas = new JTextField();
		textFieldCuotas.setEditable(false);
		textFieldCuotas.setColumns(10);
		textFieldCuotas.setBounds(332, 111, 86, 20);
		panel.add(textFieldCuotas);
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(280, 114, 46, 14);
		panel.add(lblCuotas);
	}
	
	
	/**
	 * Cargar todos los datos de una venta. Solicita a otros controladores datos de las relaciones.
	 * @param venta
	 */
	public void cargarDatosVenta(Venta venta) 
	{
		this.textFieldFechaHoraVenta.setText(venta.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
		this.textFieldFormaDePago.setText(venta.getFormaDePago());
		this.textFieldMonto.setText(Double.toString(venta.getMonto()));
		this.textFieldCuotas.setText(Integer.toString(venta.getCuotas()));
		
		Cliente cliente = this.clientesControlador.obtenerConPasaporte(venta.getCliente().getId());
		this.textFieldClienteNombre.setText(cliente.getNombreYApellido());
		this.textFieldClienteDni.setText(cliente.getDni());
		this.textFieldClienteFechaNac.setText(cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		this.textFieldClienteEmail.setText(cliente.getEmail());
		this.textFieldClientePasaporteNro.setText(cliente.getPasaporte().getNumero());
		this.textFieldClientePasaporteVto.setText(cliente.getPasaporte().getFechVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		Vuelo vuelo = this.vuelosControlador.obtenerDetallado(venta.getVuelo().getId());
		this.textFieldVueloNro.setText(vuelo.getNumero());
		this.textFieldVueloAerolinea.setText(vuelo.getAerolinea().getNombre());
		this.textFieldVueloAeropSalida.setText(vuelo.getAeropSalida().getIdentificacion() + " (" + vuelo.getAeropSalida().getCiudad() + ")");
		this.textFieldVueloAeropLlegada.setText(vuelo.getAeropLlegada().getIdentificacion() + " (" + vuelo.getAeropLlegada().getCiudad() + ")");
		this.textFieldVueloFechaSalida.setText(vuelo.getFechaHoraSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
		this.textFieldVueloFechaLlegada.setText(vuelo.getFechaHoraLlegada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
		this.textFieldVueloTiempoMins.setText(Integer.toString(vuelo.getTiempoVueloMinutos()) + " minutos");
		this.textFieldVueloCantAsientos.setText(Integer.toString(vuelo.getCantAsientos()));
	}
	
	
}
