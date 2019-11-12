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

public class VistaCliente extends JFrame {

	private ClientesControlador clienteControlador;
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;


	/**
	 * Create the frame.
	 */
	public VistaCliente(ClientesControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido");
		lblNombreYApellido.setBounds(20, 11, 103, 14);
		panel.add(lblNombreYApellido);
		
		textField = new JTextField();
		textField.setBounds(183, 8, 200, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(20, 42, 46, 14);
		panel.add(lblDni);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 39, 200, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 70, 200, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(183, 101, 200, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(20, 73, 103, 14);
		panel.add(lblFechaDeNacimiento);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(20, 104, 46, 14);
		panel.add(lblEmail);
		
		JLabel label = new JLabel("____________________________________________________________");
		label.setBounds(20, 118, 363, 14);
		panel.add(label);
		
		textField_4 = new JTextField();
		textField_4.setBounds(183, 134, 200, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(183, 161, 200, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(183, 192, 200, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(183, 223, 200, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(20, 222, 89, 23);
		panel.add(btnAceptar);
	}
}
