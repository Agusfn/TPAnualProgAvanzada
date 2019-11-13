package controlador;

import java.util.List;

import dao.factory.AerolineaFactory;
import dao.interfaces.IAerolineaDao;
import modelo.Aerolinea;
import vista.VistaAerolinea;

public class AerolineasControlador {

	
	/**
	 * Mostrar ventana para dar de alta nuevo aerolinea.
	 */
	public void mostrarVentanaCrear()
	{	
		VistaAerolinea vista = new VistaAerolinea(this);
		vista.setVisible(true);
	}
	
	
	
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
