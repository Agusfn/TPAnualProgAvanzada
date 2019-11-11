package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.InicioControlador;
import modelo.Pais;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;

public class InicioVista extends JFrame {

	
	public InicioControlador controlador;
	
	public JPanel contentPane;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnCrearCliente;
	public JButton btnAsdf;
	public JList<String> listPaises;
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioVista frame = new InicioVista();
					frame.setVisible(true);
					System.out.println("1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public InicioVista(InicioControlador controlador) throws Exception {
			
		this.controlador = controlador;
		
		InicioEventos evts = new InicioEventos(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Mi bot\u00F3n");
		btnNewButton.setBounds(181, 320, 73, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(277, 320, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnCrearCliente = new JButton("Crear cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evts.clicBtnCrearCliente(arg0);
			}
		});
		btnCrearCliente.setBounds(392, 335, 142, 23);
		contentPane.add(btnCrearCliente);
		
	
		
		btnAsdf = new JButton("asdf");
		btnAsdf.setBounds(136, 283, 89, 23);
		contentPane.add(btnAsdf);
		
		listPaises = new JList<String>();
		listPaises.setBounds(10, 30, 524, 175);
		contentPane.add(listPaises);
		
		
		JLabel lblNewLabel = new JLabel("Pa\u00EDses");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evts.clicEnBoton(e);
			}
		});
		
		
		cargarListaPaises();
	}
	
	
	private void cargarListaPaises() throws Exception
	{
		List<Pais> paises = controlador.obtenerPaises();
		
		DefaultListModel<String> demoList = new DefaultListModel<>();
		for(Pais pais: paises)
		{
			demoList.addElement(pais.getNombre());
		}
			
		
		listPaises.setModel(demoList);
	}
}
