package controlador;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import dao.implementations.db.PaisDaoImplDB;
import modelo.Pais;
import vista.InicioVista;

public class InicioControlador {

	
	
	
	public void mostrarPantallaInicio()
	{
		
		InicioControlador controlador = this;
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() 
			{
				
				InicioVista frame;
				
				try {
					frame = new InicioVista(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO mostrar detalles error.
					e.printStackTrace();
				}
				
			}
			
		});
		
		
	}
	
	public List<Pais> obtenerPaises() throws Exception
	{
		PaisDaoImplDB paisDao = new PaisDaoImplDB();
		return paisDao.obtenerTodos();
	}
	
	public void pepe()
	{
		
		System.out.println("Pepe");
	}
	
}
