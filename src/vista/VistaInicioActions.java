package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		if(arg0.getSource() ==  this.vista.getAgregarAerolinea()) {
			vista.aerolineaControlador.mostrarVentanaCrear();
		}
		
	}
	
	 

}
