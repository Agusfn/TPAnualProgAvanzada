package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.AerolineasControlador;
import controlador.ClientesControlador;
import controlador.PaisesControlador;
import controlador.ProvinciasControlador;
import modelo.Aerolinea;
import modelo.Pais;
import modelo.Provincia;
import util.ComboItem;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import java.util.List;
import javax.swing.JTextPane;

public class VistaCliente extends JFrame {

	private ClientesControlador clienteControlador;
	
	public PaisesControlador paisesControlador = new PaisesControlador();
	public ProvinciasControlador provinciasControlador = new ProvinciasControlador();
	public AerolineasControlador aerolineasControlador = new AerolineasControlador();
	
	public JPanel contentPane;
	public JTextField textFieldNombreYApellido;
	public JTextField textFieldDni;
	public JTextField textFieldFechaNac;
	public JTextField textFieldEmail;
	public JTextField textFieldTelPersonal;
	public JTextField textFieldTelCelular;
	public JTextField textFieldTelLaboral;
	public JTextField textFieldDirCiudad;
	public JTextField textFieldDirCalle;
	public JTextField textFieldDirAltura;
	public JTextField textFieldDirProvinciaCustom;
	public JTextField textFieldDirCodPostal;
	public JTextField textFieldPasaporteNro;
	public JTextField textFieldPasaporteAutoridadEmis;
	public JTextField textFieldPasaporteFechaEmis;
	public JTextField textFieldPasaporteFechaVto;
	public JTextField textFieldPasajFrecNro;
	public JTextField textFieldPasajFrecCategoria;
	public JComboBox comboBoxDirPais;
	public JComboBox comboBoxPasajFrecAerolinea;
	public JComboBox comboBoxPasaportePaisEmis;
	public JButton btnAceptar;
	public JTextField textFieldPaisPersonaliz;
	public JLabel lblPaisPersonaliz;
	public JComboBox comboBoxDirProvincia;
	public JTextField textFieldPsprtPaisPersonaliz;
	public JLabel lblPsprtPaisPersonaliz;
	
	/**
	 * Create the frame.
	 */
	public VistaCliente(ClientesControlador clienteControlador) {
		
		this.clienteControlador = clienteControlador;
		
		VistaClienteActions actions = new VistaClienteActions(this);
		
		
		setResizable(false);
		setTitle("Cliente");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 842, 574);
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
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(actions);
		btnAceptar.setBounds(640, 448, 136, 28);
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
		lblCiudad.setBounds(41, 396, 46, 14);
		panel.add(lblCiudad);
		
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setBounds(41, 424, 56, 14);
		panel.add(lblPas);
		
		textFieldDirCiudad = new JTextField();
		textFieldDirCiudad.setColumns(10);
		textFieldDirCiudad.setBounds(101, 393, 134, 20);
		panel.add(textFieldDirCiudad);
		
		textFieldDirCalle = new JTextField();
		textFieldDirCalle.setColumns(10);
		textFieldDirCalle.setBounds(101, 362, 155, 20);
		panel.add(textFieldDirCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(266, 365, 56, 14);
		panel.add(lblAltura);
		
		textFieldDirAltura = new JTextField();
		textFieldDirAltura.setColumns(10);
		textFieldDirAltura.setBounds(315, 362, 73, 20);
		panel.add(textFieldDirAltura);
		
		textFieldDirProvinciaCustom = new JTextField();
		textFieldDirProvinciaCustom.setColumns(10);
		textFieldDirProvinciaCustom.setBounds(101, 448, 287, 20);
		panel.add(textFieldDirProvinciaCustom);
		
		textFieldDirCodPostal = new JTextField();
		textFieldDirCodPostal.setColumns(10);
		textFieldDirCodPostal.setBounds(309, 393, 79, 20);
		panel.add(textFieldDirCodPostal);
		
		JLabel lblCdPostal = new JLabel("C\u00F3d. postal");
		lblCdPostal.setBounds(245, 396, 61, 14);
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
		
		comboBoxPasaportePaisEmis = new JComboBox();
		comboBoxPasaportePaisEmis.setBounds(538, 93, 103, 20);
		comboBoxPasaportePaisEmis.addActionListener(actions);
		panel.add(comboBoxPasaportePaisEmis);
		
		textFieldPasaporteAutoridadEmis = new JTextField();
		textFieldPasaporteAutoridadEmis.setColumns(10);
		textFieldPasaporteAutoridadEmis.setBounds(538, 124, 238, 20);
		panel.add(textFieldPasaporteAutoridadEmis);
		
		JLabel lblAutoridadDeEmisin = new JLabel("Autoridad emisi\u00F3n");
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
		
		comboBoxDirPais = new JComboBox();
		comboBoxDirPais.setBounds(101, 421, 111, 20);
		comboBoxDirPais.addActionListener(actions);
		panel.add(comboBoxDirPais);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(429, 195, 347, 20);
		panel.add(separator_2);
		
		JLabel lblDatosDePasajero = new JLabel("Datos de pasajero frecuente");
		lblDatosDePasajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDePasajero.setBounds(429, 215, 246, 20);
		panel.add(lblDatosDePasajero);
		
		comboBoxPasajFrecAerolinea = new JComboBox();
		comboBoxPasajFrecAerolinea.setBounds(538, 256, 238, 20);
		comboBoxPasajFrecAerolinea.addActionListener(actions);
		panel.add(comboBoxPasajFrecAerolinea);
		
		
		JLabel lblAerolnea = new JLabel("Aerol\u00EDnea");
		lblAerolnea.setBounds(429, 259, 103, 14);
		panel.add(lblAerolnea);
		
		JLabel lblNroPasajero = new JLabel("Nro. pasajero");
		lblNroPasajero.setBounds(429, 290, 103, 14);
		panel.add(lblNroPasajero);
		
		textFieldPasajFrecNro = new JTextField();
		textFieldPasajFrecNro.setColumns(10);
		textFieldPasajFrecNro.setBounds(538, 287, 238, 20);
		panel.add(textFieldPasajFrecNro);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(429, 323, 103, 14);
		panel.add(lblCategora);
		
		textFieldPasajFrecCategoria = new JTextField();
		textFieldPasajFrecCategoria.setColumns(10);
		textFieldPasajFrecCategoria.setBounds(538, 320, 238, 20);
		panel.add(textFieldPasajFrecCategoria);
		
		textFieldPaisPersonaliz = new JTextField();
		textFieldPaisPersonaliz.setBounds(255, 421, 133, 20);
		panel.add(textFieldPaisPersonaliz);
		textFieldPaisPersonaliz.setColumns(10);
		textFieldPaisPersonaliz.setVisible(false);
		
		lblPaisPersonaliz = new JLabel("Pais");
		lblPaisPersonaliz.setBounds(222, 424, 34, 14);
		panel.add(lblPaisPersonaliz);
		lblPaisPersonaliz.setVisible(false);
		
		comboBoxDirProvincia = new JComboBox();
		comboBoxDirProvincia.setBounds(101, 448, 287, 20);
		panel.add(comboBoxDirProvincia);
		comboBoxDirProvincia.setVisible(false);
		
		JLabel lblProvincia_1 = new JLabel("Provincia");
		lblProvincia_1.setBounds(41, 451, 56, 14);
		panel.add(lblProvincia_1);
		
		textFieldPsprtPaisPersonaliz = new JTextField();
		textFieldPsprtPaisPersonaliz.setBounds(690, 93, 86, 20);
		panel.add(textFieldPsprtPaisPersonaliz);
		textFieldPsprtPaisPersonaliz.setColumns(10);
		textFieldPsprtPaisPersonaliz.setVisible(false);
		
		lblPsprtPaisPersonaliz = new JLabel("Pais");
		lblPsprtPaisPersonaliz.setBounds(657, 96, 34, 14);
		panel.add(lblPsprtPaisPersonaliz);
		lblPsprtPaisPersonaliz.setVisible(false);
		
		cargarAerolineasPasajeroFrecuente();
		cargarPaisesEnCampos();
		cargarProvincias();
	}
	
	
	/**
	 * 
	 */
	public void cargarAerolineasPasajeroFrecuente()
	{
		List<Aerolinea> aerolineas = aerolineasControlador.obtenerUnicamenteConAlianzas();
		
		comboBoxPasajFrecAerolinea.addItem(new ComboItem(-1, "Seleccionar"));
		
		for(Aerolinea aerolinea: aerolineas) {
			ComboItem item = new ComboItem(
					aerolinea.getId(), 
					aerolinea.getNombre() + "(" + aerolinea.getAlianza().getNombre() + ")"
			);
			comboBoxPasajFrecAerolinea.addItem(item);
		}		
		
	}
	
	
	/*
	 * Cargar comboboxes de pais de dirección cliente, y de país de emisión de pasaporte, con los países existentes.
	 */
	public void cargarPaisesEnCampos()
	{
		List<Pais> paises = paisesControlador.obtenerTodos();
		
		ComboItem item = new ComboItem(-1, "Seleccionar");
		comboBoxDirPais.addItem(item);
		comboBoxPasaportePaisEmis.addItem(item);
		
		for(Pais pais: paises) {
			item = new ComboItem(pais.getId(), pais.getNombre());
			comboBoxDirPais.addItem(item);
			comboBoxPasaportePaisEmis.addItem(item);
		}

		
	}
	
	
	/**
	 * Cargamos provincias (solo de argentina por ahora)
	 */
	public void cargarProvincias()
	{
		List<Provincia> provincias = provinciasControlador.obtenerDePaisId(1);
		
		ComboItem item = new ComboItem(-1, "Seleccionar");
		comboBoxDirProvincia.addItem(item);
		
		for(Provincia provincia: provincias) {
			item = new ComboItem(provincia.getId(), provincia.getNombre());
			comboBoxDirProvincia.addItem(item);
		}
		
	}
	
	
	
	public JButton getAceptarBtn()
	{
		return this.btnAceptar;
	}
	
	public JComboBox getComboBoxDirPais() 
	{
		return this.comboBoxDirPais;
	}
	
	public JTextField getTextFieldPaisPersonaliz()
	{
		return this.textFieldPaisPersonaliz;
	}
	
	public JLabel getLblPaisPersonaliz() {
		return this.lblPaisPersonaliz;
	}
	
	public JComboBox getComboBoxDirProvincia() {
		return this.comboBoxDirProvincia;
	}
	
	public JTextField getTextFieldDirProvinciaCustom() 
	{
		return this.textFieldDirProvinciaCustom;
	}
	
	public JComboBox getComboBoxPasaportePaisEmis() {
		return this.comboBoxPasaportePaisEmis;
	}
	
	
	public JTextField getTextFieldPsprtPaisPersonaliz()
	{
		return this.textFieldPsprtPaisPersonaliz;
	}
	
	public JLabel getLblPsprtPaisPersonaliz() {
		return this.lblPsprtPaisPersonaliz;
	}
	
	public JComboBox getComboBoxPasajFrecAerolinea()
	{
		return this.comboBoxPasajFrecAerolinea;
	}
	
	
	
}
