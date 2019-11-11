package controlador;

import vista.CrearClienteVista;
import vista.InicioVista;

public class ClientesControlador {

	
	public void mostrarVentanaCrear()
	{
		
		
		CrearClienteVista frame = new CrearClienteVista(this);
		frame.setVisible(true);
	}
	
}
