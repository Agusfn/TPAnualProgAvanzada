package controlador;

import java.util.List;

import dao.factory.PaisFactory;
import dao.factory.ProvinciaFactory;
import dao.interfaces.IPaisDao;
import dao.interfaces.IProvinciaDao;
import modelo.Provincia;

public class ProvinciasControlador {

		
	/**
	 * Obtener todas las provincias con su respectivo país.
	 * @return
	 */
	public List<Provincia> obtenerTodas()
	{

			try {
				IProvinciaDao provinciaDao = ProvinciaFactory.getImplementation("db");
				List<Provincia> provincias = provinciaDao.obtenerTodos();
				provinciaDao.close();
				
				IPaisDao paisDao = PaisFactory.getImplementation("db");
				
				for(Provincia provincia: provincias)
				{
					provincia.setPais(paisDao.obtener(provincia.getPais().getId()));
				}
				
				paisDao.close();
				
				return provincias;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}
	
	
	/**
	 * Obtener todas las provincias que corresponden a un país con id determinado
	 * @param idPais
	 * @return
	 */
	public List<Provincia> obtenerDePaisId(int idPais)
	{

			try {
				IProvinciaDao provinciaDao = ProvinciaFactory.getImplementation("db");
				List<Provincia> provincias = provinciaDao.obtenerTodos();
				provinciaDao.close();
				
				for(Provincia provincia: provincias) {
					if(provincia.getPais().getId() != idPais) {
						provincias.remove(provincia);
					}
				}
				
				return provincias;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	}
	
	
	
	
}
