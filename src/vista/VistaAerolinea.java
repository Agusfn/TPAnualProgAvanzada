package vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AerolineasControlador;
import controlador.AlianzasControlador;
import modelo.Alianza;
import modelo.Pais;
import util.ComboItem;
import javax.swing.JTextField;

public class VistaAerolinea extends JFrame {

	public AlianzasControlador alianzasControlador = new AlianzasControlador();
	private JPanel contentPane;
	private AerolineasControlador aerolineasControlador;
	private JButton btnAceptar;
	private JComboBox comboBox_alianza;
	
	
	private JTextField textField_nombre;
	public JButton getAceptarBtn()
	{
		return this.btnAceptar;
	}
	public JTextField getTextField_nombre(){
		return this.textField_nombre;
	}
	
	public JComboBox getComboBox_alianza(){
		return this.comboBox_alianza;
	}



	/**
	 * Create the frame.
	 */
	public VistaAerolinea(AerolineasControlador aerolineasControlador) {
		
		this.aerolineasControlador = aerolineasControlador;
		VistaAerolineasActions actions = new VistaAerolineasActions(this);
		
		setResizable(false);
		setTitle("Nueva Aerolínea");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_nombre = new JLabel("Nombre de Aerolínea");
		lblNewLabel_nombre.setBounds(20, 11, 150, 14);
		panel.add(lblNewLabel_nombre);
		
		JLabel lblNewLabel_alianza = new JLabel("Alianza");
		lblNewLabel_alianza.setBounds(20, 39, 46, 14);
		panel.add(lblNewLabel_alianza);
		
		comboBox_alianza = new JComboBox();
		comboBox_alianza.setBounds(220, 36, 165, 20);
		panel.add(comboBox_alianza);
		cargarAlianzaEnCampos();
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(actions);
		btnAceptar.setBounds(296, 149, 89, 23);
		panel.add(btnAceptar);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(220, 8, 165, 20);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		
		
		
	}
	
	public AerolineasControlador getAerolineasControlador() {
		return this.aerolineasControlador;
	}
	
	
	public void cargarAlianzaEnCampos()
	{
		
		List<Alianza> alianzas = alianzasControlador.obtenerTodas();
		
		ComboItem item = new ComboItem(-1, "Seleccionar");
		comboBox_alianza.addItem(item);

		for(Alianza alianza: alianzas) {
			item = new ComboItem(alianza.getId(), alianza.getNombre());
			comboBox_alianza.addItem(item);
		}
		
		
	}
}
