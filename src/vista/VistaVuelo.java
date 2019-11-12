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
import javax.swing.JButton;

public class VistaVuelo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroVuelo;
	private JTextField textFieldTiempoVueloMins;
	private JTextField textFieldFechaHoraSalida;
	private JTextField textFieldFechaHoraLlegada;
	private JTextField textFieldCantidadAsientos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVuelo frame = new VistaVuelo();
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
	public VistaVuelo() {
		setResizable(false);
		setTitle("Vuelo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDatosDelVuelo = new JLabel("Datos del vuelo");
		lblDatosDelVuelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosDelVuelo.setBounds(27, 23, 146, 14);
		panel.add(lblDatosDelVuelo);
		
		JLabel lblNroDeVuelo = new JLabel("Nro de vuelo");
		lblNroDeVuelo.setBounds(27, 59, 103, 14);
		panel.add(lblNroDeVuelo);
		
		textFieldNroVuelo = new JTextField();
		textFieldNroVuelo.setColumns(10);
		textFieldNroVuelo.setBounds(144, 56, 230, 20);
		panel.add(textFieldNroVuelo);
		
		textFieldTiempoVueloMins = new JTextField();
		textFieldTiempoVueloMins.setColumns(10);
		textFieldTiempoVueloMins.setBounds(144, 202, 86, 20);
		panel.add(textFieldTiempoVueloMins);
		
		JLabel lblCantidadAsientos = new JLabel("Tiempo de vuelo (min)");
		lblCantidadAsientos.setBounds(27, 205, 114, 14);
		panel.add(lblCantidadAsientos);
		
		JLabel lblAeropSalida = new JLabel("Aerop. salida");
		lblAeropSalida.setBounds(27, 87, 103, 14);
		panel.add(lblAeropSalida);
		
		JLabel lblAeropLlegada = new JLabel("Aerop. llegada");
		lblAeropLlegada.setBounds(27, 118, 103, 14);
		panel.add(lblAeropLlegada);
		
		JLabel lblFechaHoraSalida = new JLabel("Fecha y hora salida");
		lblFechaHoraSalida.setBounds(27, 146, 103, 14);
		panel.add(lblFechaHoraSalida);
		
		textFieldFechaHoraSalida = new JTextField();
		textFieldFechaHoraSalida.setColumns(10);
		textFieldFechaHoraSalida.setBounds(144, 143, 230, 20);
		panel.add(textFieldFechaHoraSalida);
		
		textFieldFechaHoraLlegada = new JTextField();
		textFieldFechaHoraLlegada.setColumns(10);
		textFieldFechaHoraLlegada.setBounds(144, 171, 230, 20);
		panel.add(textFieldFechaHoraLlegada);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora llegada");
		lblFechaYHora.setBounds(27, 174, 103, 14);
		panel.add(lblFechaYHora);
		
		JComboBox comboBoxAeropSalida = new JComboBox();
		comboBoxAeropSalida.setBounds(144, 84, 230, 20);
		panel.add(comboBoxAeropSalida);
		
		JComboBox comboBoxAeropLlegada = new JComboBox();
		comboBoxAeropLlegada.setBounds(144, 115, 230, 20);
		panel.add(comboBoxAeropLlegada);
		
		JLabel lblCantAsientos = new JLabel("Cant. asientos");
		lblCantAsientos.setBounds(240, 205, 70, 14);
		panel.add(lblCantAsientos);
		
		textFieldCantidadAsientos = new JTextField();
		textFieldCantidadAsientos.setColumns(10);
		textFieldCantidadAsientos.setBounds(320, 202, 54, 20);
		panel.add(textFieldCantidadAsientos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(320, 255, 95, 23);
		panel.add(btnAceptar);
	}
}
