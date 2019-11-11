package controlador;

import java.awt.EventQueue;

import vista.VistaInicio;

public class InicioControlador {


	
	public void mostrarPantallaInicio()
	{
		
		InicioControlador controlador = this;
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() 
			{
				
				VistaInicio frame;
				
				try {
					frame = new VistaInicio(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO mostrar detalles error.
					e.printStackTrace();
				}
				
			}
			
		});
		
		
	}
	
	/*
	public List<Pais> obtenerPaises() throws Exception
	{
		PaisDaoImplDB paisDao = new PaisDaoImplDB();
		return paisDao.obtenerTodos();
	}
	
	public void pepe()
	{
		
		System.out.println("Pepe");
	}
	*/
}
