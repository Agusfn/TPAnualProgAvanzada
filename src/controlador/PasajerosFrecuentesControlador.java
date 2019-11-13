package controlador;

import dao.factory.PasajeroFrecuenteFactory;
import dao.interfaces.IPasajeroFrecuenteDao;
import modelo.PasajeroFrecuente;

public class PasajerosFrecuentesControlador {

	
	
	public PasajeroFrecuente obtenerPasajeroFrecuente(int id) 
	{
		try {
			
			IPasajeroFrecuenteDao pasajFrecDao = PasajeroFrecuenteFactory.getImplementation("db");
			PasajeroFrecuente pasajFrec = pasajFrecDao.obtener(id);
			pasajFrecDao.close();
			
			return pasajFrec;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}	
	
	public void crearPasajeroFrecuente(PasajeroFrecuente pasajFrecuente)
	{
		try {
			IPasajeroFrecuenteDao pasajFrecDao = PasajeroFrecuenteFactory.getImplementation("db");
			pasajFrecDao.agregar(pasajFrecuente);
			pasajFrecDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void actualizarPasajeroFrecuente(PasajeroFrecuente pasajFrecuente)
	{
		try {
			IPasajeroFrecuenteDao pasajFrecDao = PasajeroFrecuenteFactory.getImplementation("db");
			pasajFrecDao.actualizar(pasajFrecuente);
			pasajFrecDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
	public void eliminarPasajeroFrecuente(PasajeroFrecuente pasajFrecuente)
	{
		try {
			IPasajeroFrecuenteDao pasajFrecDao = PasajeroFrecuenteFactory.getImplementation("db");
			pasajFrecDao.eliminar(pasajFrecuente);
			pasajFrecDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
