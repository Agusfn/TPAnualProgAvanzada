package controlador;

import dao.factory.TelefonoFactory;
import dao.interfaces.ITelefonoDao;
import modelo.Telefono;

public class TelefonosControlador {

	
	
	
	public Telefono obtenerTelefono(int id) 
	{
		try {
			
			ITelefonoDao telDao = TelefonoFactory.getImplementation("db");
			Telefono tel = telDao.obtener(id);
			telDao.close();
			
			return tel;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public void altaTelefono(Telefono telefono)
	{
		try {
			
			ITelefonoDao telDao = TelefonoFactory.getImplementation("db");
			telDao.agregar(telefono);
			telDao.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
