package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ClientesControlador;

public class VistaInicioActions implements ActionListener {
	
	private VistaInicio vistaInicio;
	private ClientesControlador clienteControlador;
	
	public VistaInicioActions(VistaInicio vista) {
		this.vistaInicio = vista;
		this.clienteControlador = new ClientesControlador();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if(arg0.getSource() == this.vistaInicio.getAgregarCliente()) {
			 clienteControlador.mostrarVentanaCrear();
			
	 
		}
		
		
	}
	
	 

}
