package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VistaVentaDetalles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Create the frame.
	 */
	public VistaVentaDetalles() {
		setTitle("Venta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 428, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del cliente");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDelCliente.setBounds(26, 89, 146, 14);
		panel.add(lblDatosDelCliente);
		
		JLabel label = new JLabel("Nombre y apellido");
		label.setBounds(26, 123, 103, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(127, 120, 246, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("E-mail");
		label_1.setBounds(26, 185, 46, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 182, 246, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("DNI");
		label_2.setBounds(26, 154, 46, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 151, 93, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(301, 151, 72, 20);
		panel.add(textField_3);
		
		JLabel label_3 = new JLabel("Fecha nac.");
		label_3.setBounds(230, 154, 61, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Datos del vuelo");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(26, 225, 146, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Nro de vuelo");
		label_5.setBounds(26, 261, 103, 14);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 258, 230, 20);
		panel.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 286, 230, 20);
		panel.add(comboBox);
		
		JLabel label_6 = new JLabel("Aerop. salida");
		label_6.setBounds(26, 289, 103, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Aerop. llegada");
		label_7.setBounds(26, 320, 103, 14);
		panel.add(label_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(143, 317, 230, 20);
		panel.add(comboBox_1);
		
		JLabel label_8 = new JLabel("Fecha y hora salida");
		label_8.setBounds(26, 348, 103, 14);
		panel.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(143, 345, 230, 20);
		panel.add(textField_5);
		
		JLabel label_9 = new JLabel("Fecha y hora llegada");
		label_9.setBounds(26, 376, 103, 14);
		panel.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(143, 373, 230, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(143, 404, 86, 20);
		panel.add(textField_7);
		
		JLabel label_10 = new JLabel("Tiempo de vuelo (min)");
		label_10.setBounds(26, 407, 114, 14);
		panel.add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(319, 404, 54, 20);
		panel.add(textField_8);
		
		JLabel label_11 = new JLabel("Cant. asientos");
		label_11.setBounds(239, 407, 70, 14);
		panel.add(label_11);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de venta");
		lblFechaYHora.setBounds(26, 25, 114, 14);
		panel.add(lblFechaYHora);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(157, 22, 216, 20);
		panel.add(textField_9);
		
		JLabel label_13 = new JLabel("Nombre y apellido");
		label_13.setBounds(26, 53, 103, 14);
		panel.add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(157, 50, 216, 20);
		panel.add(textField_10);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la aerol\u00EDnea");
		lblDatosDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDeLa.setBounds(26, 465, 178, 14);
		panel.add(lblDatosDeLa);
		
		JLabel lblNombreAerolnea = new JLabel("Nombre aerol\u00EDnea");
		lblNombreAerolnea.setBounds(26, 499, 103, 14);
		panel.add(lblNombreAerolnea);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(127, 496, 246, 20);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(127, 524, 246, 20);
		panel.add(textField_12);
		
		JLabel lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(26, 527, 103, 14);
		panel.add(lblAlianza);
	}

}
