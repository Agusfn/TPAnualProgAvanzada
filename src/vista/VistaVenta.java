package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.VentasControlador;
import util.ComboItem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaVenta extends JFrame {

	
	public VentasControlador ventasControlador;
	
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
		setBounds(100, 100, 465, 329);
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
		textFieldMontoArs.setBounds(145, 193, 111, 20);
		panel.add(textFieldMontoArs);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(44, 72, 70, 14);
		panel.add(lblNewLabel);
		
		comboBoxVuelo = new JComboBox();
		comboBoxVuelo.setBounds(145, 100, 246, 20);
		panel.add(comboBoxVuelo);
		
		JLabel lblVuelo = new JLabel("Vuelo");
		lblVuelo.setBounds(44, 103, 70, 14);
		panel.add(lblVuelo);
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(145, 69, 246, 20);
		panel.add(comboBoxCliente);
		
		comboBoxMedioPago = new JComboBox();
		comboBoxMedioPago.setBounds(145, 162, 246, 20);
		comboBoxMedioPago.addItem(new ComboItem(0, "Contado efectivo"));
		comboBoxMedioPago.addItem(new ComboItem(1, "Tarjeta de crédito/débito"));
		
		panel.add(comboBoxMedioPago);
		
		JLabel lblMedioDePago = new JLabel("Medio de pago");
		lblMedioDePago.setBounds(44, 165, 70, 14);
		panel.add(lblMedioDePago);
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(266, 196, 70, 14);
		panel.add(lblCuotas);
		
		comboBoxCuotas = new JComboBox();
		comboBoxCuotas.addItem(new ComboItem(1, "1"));
		comboBoxCuotas.setBounds(330, 193, 61, 20);
		panel.add(comboBoxCuotas);
		
		comboBoxAsiento = new JComboBox();
		comboBoxAsiento.setBounds(145, 131, 246, 20);
		comboBoxAsiento.addItem(new ComboItem(0, "Economy"));
		panel.add(comboBoxAsiento);
		
		JLabel lblCategoraAsiento = new JLabel("Categor\u00EDa asiento");
		lblCategoraAsiento.setBounds(44, 134, 91, 14);
		panel.add(lblCategoraAsiento);
		
		btnAceptar = new JButton("Registrar");
		btnAceptar.addActionListener(actions);
		btnAceptar.setBounds(266, 239, 125, 29);
		panel.add(btnAceptar);
		
		comboBoxMedioPago.addActionListener(actions);
	}
}
