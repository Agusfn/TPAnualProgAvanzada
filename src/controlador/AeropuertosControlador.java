package controlador;

import java.util.List;

import dao.factory.AeropuertoFactory;
import dao.factory.PaisFactory;
import dao.factory.ProvinciaFactory;
import dao.interfaces.IAeropuertoDao;
import dao.interfaces.IPaisDao;
import dao.interfaces.IProvinciaDao;
import modelo.Aeropuerto;

public class AeropuertosControlador {

	
	/**
	 * Obtener todos los aeropuertos, con sus respectivos paises y provincias.
	 * @return
	 */
	public List<Aeropuerto> obtenerTodos()
	{
		try {
			// Obtenemos aeropuertos.
			IAeropuertoDao aeropDao = AeropuertoFactory.getImplementation("db");
			List<Aeropuerto> aeropuertos = aeropDao.obtenerTodos();
			aeropDao.close();
			
			
			// Cargamos sus paises y provincias
			IPaisDao paisDao = PaisFactory.getImplementation("db");
			IProvinciaDao provinciaDao = ProvinciaFactory.getImplementation("db");
			
			for(Aeropuerto aerop: aeropuertos) {
				aerop.setPais(paisDao.obtener(aerop.getPais().getId()));
				aerop.setProvincia(provinciaDao.obtener(aerop.getProvincia().getId()));
			}
			
			paisDao.close();
			provinciaDao.close();
			
			
			return aeropuertos;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
}
