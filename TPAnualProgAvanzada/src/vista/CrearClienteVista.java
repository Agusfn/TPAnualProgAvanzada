package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClientesControlador;
import controlador.InicioControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearClienteVista extends JFrame {

	
	public ClientesControlador controlador;
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearClienteVista frame = new CrearClienteVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CrearClienteVista(ClientesControlador controlador) {
		
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCliente = new JLabel("Crear cliente");
		lblCrearCliente.setBounds(20, 11, 131, 14);
		contentPane.add(lblCrearCliente);
		
		textField = new JTextField();
		textField.setBounds(20, 36, 404, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(305, 227, 119, 23);
		contentPane.add(btnNewButton);
	}
}
