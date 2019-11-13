package controlador;

import java.util.List;

import dao.factory.PaisFactory;
import dao.interfaces.IPaisDao;
import modelo.Pais;

public class PaisesControlador {

	
	
	
	/**
	 * Obtener todos los países.
	 * @return
	 */
	public List<Pais> obtenerTodos()
	{

		try {
			IPaisDao paisDao = PaisFactory.getImplementation("archivo");
			List<Pais> paises = paisDao.obtenerTodos();
			paisDao.close();
			
			return paises;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	
	}
	
	
}
