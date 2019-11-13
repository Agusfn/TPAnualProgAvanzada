package controlador;

import dao.factory.PasaporteFactory;
import dao.interfaces.IPasaporteDao;
import modelo.Pasaporte;

public class PasaportesControlador {

	
	
	public Pasaporte obtenerPasaporte(int id) 
	{
		try {
			
			IPasaporteDao pasaporteDao = PasaporteFactory.getImplementation("db");
			Pasaporte pasaporte = pasaporteDao.obtener(id);
			pasaporteDao.close();
			
			return pasaporte;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void crearPasaporte(Pasaporte pasaporte)
	{
		try {
			
			IPasaporteDao pasaporteDao = PasaporteFactory.getImplementation("db");
			pasaporteDao.agregar(pasaporte);
			pasaporteDao.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
