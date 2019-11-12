package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ClientesControlador;
import controlador.InicioControlador;
import modelo.Cliente;

public class VistaInicio extends JFrame {
	
	public ClientesControlador clientesControlador = new ClientesControlador();
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnAgregarPersona;

	/**
	 * Create the frame.
	 */
	
	public VistaInicio(InicioControlador controlador) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		table = new JTable();
		panel.add(table, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		btnAgregarPersona = new JButton("Nuevo");
		btnAgregarPersona.addActionListener(new VistaInicioActions(this));
		panel_1.add(btnAgregarPersona);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(25);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		panel_1.add(btnNewButton_1);
		
		
		recargarTablaClientes();
	}
	
	
	public void recargarTablaClientes()
	{
		List<Cliente> clientes = clientesControlador.obtenerListaClientes();
				
		String[] columnas = {"Nombre", "DNI", "Fecha nacimiento", "E-mail"};
		
		String[][] datos = new String[clientes.size()][4];
		
		for(int i = 0; i<clientes.size(); i++) 
		{
			Cliente cliente = clientes.get(i);
			datos[i] = new String[] {"a"};
		}
		
		
		System.out.println(datos);
	}
	
	
	public JButton getAgregarCliente() {
		return this.btnAgregarPersona;
		
		
	}
	
	

}
