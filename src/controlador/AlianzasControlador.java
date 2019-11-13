package controlador;

import java.util.List;

import dao.factory.AlianzaFactory;
import dao.factory.PasaporteFactory;
import dao.implementations.db.AlianzaDaoImplDB;
import dao.interfaces.IAlianzaDao;
import dao.interfaces.IPasaporteDao;
import modelo.Alianza;
import modelo.Pasaporte;

public class AlianzasControlador {
	
	
	
	public List<Alianza> obtenerTodas()
	{
		
		
		try {
			AlianzaDaoImplDB alianzaDao = new AlianzaDaoImplDB();
			
			return alianzaDao.obtenerTodos();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	public void crearAlianza(Alianza alianza)
	{
		try {
			
			IAlianzaDao alianzaDao = AlianzaFactory.getImplementation("db");
			alianzaDao.agregar(alianza);
			alianzaDao.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
