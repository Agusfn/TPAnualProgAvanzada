package controlador;

import dao.factory.DireccionFactory;
import dao.interfaces.IDireccionDao;
import modelo.Direccion;

public class DireccionesControlador {

	
	public Direccion obtenerDireccion(int id) 
	{
		try {
			
			IDireccionDao direccionDao = DireccionFactory.getImplementation("db");
			Direccion direccion = direccionDao.obtener(id);
			direccionDao.close();
			
			return direccion;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void crearDireccion(Direccion direccion)
	{
		try {
			IDireccionDao dirDao = DireccionFactory.getImplementation("db");
			dirDao.agregar(direccion);
			dirDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
