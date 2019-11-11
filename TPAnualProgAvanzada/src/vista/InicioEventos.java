package vista;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import controlador.ClientesControlador;

public class InicioEventos {

	
	private InicioVista vista;
	
	private ClientesControlador clientesControlador;
	
	public InicioEventos(InicioVista vista) {
		
		this.vista = vista;
		
		clientesControlador = new ClientesControlador();
	}
	
	
	public void clicEnBoton(ActionEvent e)
	{
		System.out.println("HOLA!");
		vista.btnAsdf.setText("JEJEJ");
		vista.controlador.pepe();
	}
	
	
	public void clicBtnCrearCliente(ActionEvent e) 
	{
		clientesControlador.mostrarVentanaCrear();
	}
	
	
}
