package controlador;

import java.util.List;

import dao.factory.AerolineaFactory;
import dao.interfaces.IAerolineaDao;
import modelo.Aerolinea;

public class AerolineasControlador {

	
	/**
	 * Obtener todas las aerolineas.
	 * @return
	 */
	public List<Aerolinea> obtenerTodas()
	{
		
		
		try {
			IAerolineaDao aerolineaDao = AerolineaFactory.getImplementation("db");
			
			return aerolineaDao.obtenerTodos();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	
}
