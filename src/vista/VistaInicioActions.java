package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ClientesControlador;

public class VistaInicioActions implements ActionListener {
	
	private VistaInicio vista;
	
	public VistaInicioActions(VistaInicio vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if(arg0.getSource() == this.vista.getAgregarCliente()) {
			 vista.clientesControlador.mostrarVentanaCrear();
		}
		
		
	}
	
	 

}
