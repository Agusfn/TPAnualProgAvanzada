package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ClientesControlador;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Window.Type;

public class VistaCliente extends JFrame {

	private ClientesControlador clienteControlador;
	
	
	private JPanel contentPane;
	private JTextField textFieldNombreYApellido;
	private JTextField textFieldDni;
	private JTextField textFieldFechaNac;
	private JTextField textFieldEmail;
	private JTextField textFieldTelPersonal;
	private JTextField textFieldTelCelular;
	private JTextField textFieldTelLaboral;
	private JTextField textFieldDirCiudad;
	private JTextField textFieldDirCalle;
	private JTextField textFieldDirAltura;
	private JTextField textFieldDirProvincia;
	private JTextField textFieldDirCodPostal;
	private JTextField textFieldPasaporteNro;
	private JTextField textFieldPasaporteAutoridadEmis;
	private JTextField textFieldPasaporteFechaEmis;
	private JTextField textFieldPasaporteFechaVto;
	private JTextField textFieldPasajFrecNro;
	private JTextField textFieldPasajFrecCategoria;


	/**
	 * Create the frame.
	 */
	public VistaCliente(ClientesControlador clienteControlador) {
		setResizable(false);
		setTitle("Cliente");
		this.clienteControlador = clienteControlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 842, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(41, 65, 103, 14);
		panel.add(lblNombreYApellido);
		
		textFieldNombreYApellido = new JTextField();
		textFieldNombreYApellido.setBounds(142, 62, 246, 20);
		panel.add(textFieldNombreYApellido);
		textFieldNombreYApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(41, 96, 46, 14);
		panel.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(142, 93, 93, 20);
		panel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(316, 93, 72, 20);
		panel.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(142, 124, 246, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha nac.");
		lblFechaDeNacimiento.setBounds(245, 96, 61, 14);
		panel.add(lblFechaDeNacimiento);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(41, 127, 46, 14);
		panel.add(lblEmail);
		
		textFieldTelPersonal = new JTextField();
		textFieldTelPersonal.setBounds(142, 215, 246, 20);
		panel.add(textFieldTelPersonal);
		textFieldTelPersonal.setColumns(10);
		
		textFieldTelCelular = new JTextField();
		textFieldTelCelular.setBounds(142, 246, 246, 20);
		panel.add(textFieldTelCelular);
		textFieldTelCelular.setColumns(10);
		
		textFieldTelLaboral = new JTextField();
		textFieldTelLaboral.setBounds(142, 277, 246, 20);
		panel.add(textFieldTelLaboral);
		textFieldTelLaboral.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(640, 430, 136, 28);
		panel.add(btnAceptar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 155, 347, 20);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("Datos personales");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 29, 146, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDatosTelefnicos = new JLabel("Datos telef\u00F3nicos");
		lblDatosTelefnicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosTelefnicos.setBounds(41, 182, 146, 22);
		panel.add(lblDatosTelefnicos);
		
		JLabel lblTelfonoPersonal = new JLabel("Tel\u00E9fono personal");
		lblTelfonoPersonal.setBounds(41, 215, 93, 14);
		panel.add(lblTelfonoPersonal);
		
		JLabel lblTelfonoCelular = new JLabel("Tel\u00E9fono celular");
		lblTelfonoCelular.setBounds(41, 246, 103, 14);
		panel.add(lblTelfonoCelular);
		
		JLabel lblTelfonoLaboral = new JLabel("Tel\u00E9fono laboral");
		lblTelfonoLaboral.setBounds(41, 277, 103, 14);
		panel.add(lblTelfonoLaboral);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(41, 332, 146, 14);
		panel.add(lblDireccin);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 308, 347, 20);
		panel.add(separator_1);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(41, 365, 56, 14);
		panel.add(lblCalle);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(41, 396, 72, 14);
		panel.add(lblCiudad);
		
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setBounds(41, 430, 89, 14);
		panel.add(lblPas);
		
		textFieldDirCiudad = new JTextField();
		textFieldDirCiudad.setColumns(10);
		textFieldDirCiudad.setBounds(107, 393, 112, 20);
		panel.add(textFieldDirCiudad);
		
		textFieldDirCalle = new JTextField();
		textFieldDirCalle.setColumns(10);
		textFieldDirCalle.setBounds(107, 362, 149, 20);
		panel.add(textFieldDirCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(266, 365, 56, 14);
		panel.add(lblAltura);
		
		textFieldDirAltura = new JTextField();
		textFieldDirAltura.setColumns(10);
		textFieldDirAltura.setBounds(315, 362, 73, 20);
		panel.add(textFieldDirAltura);
		
		textFieldDirProvincia = new JTextField();
		textFieldDirProvincia.setColumns(10);
		textFieldDirProvincia.setBounds(276, 393, 112, 20);
		panel.add(textFieldDirProvincia);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(229, 396, 46, 14);
		panel.add(lblProvincia);
		
		textFieldDirCodPostal = new JTextField();
		textFieldDirCodPostal.setColumns(10);
		textFieldDirCodPostal.setBounds(309, 427, 79, 20);
		panel.add(textFieldDirCodPostal);
		
		JLabel lblCdPostal = new JLabel("C\u00F3d. postal");
		lblCdPostal.setBounds(245, 430, 61, 14);
		panel.add(lblCdPostal);
		
		JLabel lblDatosDelPasasporte = new JLabel("Datos del pasasporte");
		lblDatosDelPasasporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDelPasasporte.setBounds(429, 26, 191, 17);
		panel.add(lblDatosDelPasasporte);
		
		JLabel lblNroDePasaporte = new JLabel("Nro. de pasaporte");
		lblNroDePasaporte.setBounds(429, 62, 103, 14);
		panel.add(lblNroDePasaporte);
		
		textFieldPasaporteNro = new JTextField();
		textFieldPasaporteNro.setColumns(10);
		textFieldPasaporteNro.setBounds(538, 59, 238, 20);
		panel.add(textFieldPasaporteNro);
		
		JLabel lblPasEmisin = new JLabel("Pa\u00EDs emisi\u00F3n");
		lblPasEmisin.setBounds(429, 96, 103, 14);
		panel.add(lblPasEmisin);
		
		JComboBox comboBoxPasaportePaisEmis = new JComboBox();
		comboBoxPasaportePaisEmis.setBounds(538, 93, 238, 20);
		panel.add(comboBoxPasaportePaisEmis);
		
		textFieldPasaporteAutoridadEmis = new JTextField();
		textFieldPasaporteAutoridadEmis.setColumns(10);
		textFieldPasaporteAutoridadEmis.setBounds(538, 124, 238, 20);
		panel.add(textFieldPasaporteAutoridadEmis);
		
		JLabel lblAutoridadDeEmisin = new JLabel("Autoridad de emisi\u00F3n");
		lblAutoridadDeEmisin.setBounds(429, 127, 103, 14);
		panel.add(lblAutoridadDeEmisin);
		
		JLabel lblFechaEmisin = new JLabel("Fecha emisi\u00F3n");
		lblFechaEmisin.setBounds(429, 158, 103, 14);
		panel.add(lblFechaEmisin);
		
		textFieldPasaporteFechaEmis = new JTextField();
		textFieldPasaporteFechaEmis.setColumns(10);
		textFieldPasaporteFechaEmis.setBounds(538, 155, 82, 20);
		panel.add(textFieldPasaporteFechaEmis);
		
		textFieldPasaporteFechaVto = new JTextField();
		textFieldPasaporteFechaVto.setColumns(10);
		textFieldPasaporteFechaVto.setBounds(694, 155, 82, 20);
		panel.add(textFieldPasaporteFechaVto);
		
		JLabel lblFechaVto = new JLabel("Fecha vto.");
		lblFechaVto.setBounds(630, 158, 61, 14);
		panel.add(lblFechaVto);
		
		JComboBox comboBoxDirPais = new JComboBox();
		comboBoxDirPais.setBounds(107, 427, 128, 20);
		panel.add(comboBoxDirPais);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(429, 195, 347, 20);
		panel.add(separator_2);
		
		JLabel lblDatosDePasajero = new JLabel("Datos de pasajero frecuente");
		lblDatosDePasajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDePasajero.setBounds(429, 215, 246, 20);
		panel.add(lblDatosDePasajero);
		
		JLabel lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(429, 251, 103, 14);
		panel.add(lblAlianza);
		
		JComboBox comboBoxPasajFrecAerolinea = new JComboBox();
		comboBoxPasajFrecAerolinea.setBounds(538, 282, 238, 20);
		panel.add(comboBoxPasajFrecAerolinea);
		
		JLabel lblAerolnea = new JLabel("Aerol\u00EDnea");
		lblAerolnea.setBounds(429, 285, 103, 14);
		panel.add(lblAerolnea);
		
		JLabel lblNroPasajero = new JLabel("Nro. pasajero");
		lblNroPasajero.setBounds(429, 316, 103, 14);
		panel.add(lblNroPasajero);
		
		textFieldPasajFrecNro = new JTextField();
		textFieldPasajFrecNro.setColumns(10);
		textFieldPasajFrecNro.setBounds(538, 313, 238, 20);
		panel.add(textFieldPasajFrecNro);
		
		JComboBox comboBoxPasajFrecAlianza = new JComboBox();
		comboBoxPasajFrecAlianza.setBounds(538, 246, 238, 20);
		panel.add(comboBoxPasajFrecAlianza);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(429, 349, 103, 14);
		panel.add(lblCategora);
		
		textFieldPasajFrecCategoria = new JTextField();
		textFieldPasajFrecCategoria.setColumns(10);
		textFieldPasajFrecCategoria.setBounds(538, 346, 238, 20);
		panel.add(textFieldPasajFrecCategoria);
	}
}
