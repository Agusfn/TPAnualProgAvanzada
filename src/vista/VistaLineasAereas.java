package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VistaLineasAereas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLineasAereas frame = new VistaLineasAereas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaLineasAereas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Aerolinea");
		lblNewLabel.setBounds(20, 11, 115, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 8, 165, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Alianza");
		lblNewLabel_1.setBounds(20, 39, 46, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(135, 36, 165, 20);
		panel.add(comboBox_1);
		
		JLabel lblVuelo = new JLabel("Vuelo");
		lblVuelo.setBounds(20, 70, 46, 14);
		panel.add(lblVuelo);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(135, 67, 165, 20);
		panel.add(comboBox_2);
	}
}
