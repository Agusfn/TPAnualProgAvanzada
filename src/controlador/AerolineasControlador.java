package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.factory.AerolineaFactory;
import dao.implementations.db.AlianzaDaoImplDB;
import dao.interfaces.IAerolineaDao;
import modelo.Aerolinea;
import modelo.Alianza;
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
	
	/**
	 * Obtener las aerolineas únicamente que poseen alianzas, con sus respectivas alianzas asociadas.
	 * @return
	 */
	public List<Aerolinea> obtenerUnicamenteConAlianzas()
	{
		
		try {
			
			IAerolineaDao aerolineaDao = AerolineaFactory.getImplementation("db");
			List<Aerolinea> aerolineas = aerolineaDao.obtenerTodos();
			aerolineaDao.close();
			
			AlianzaDaoImplDB alianzaDao = new AlianzaDaoImplDB();
			
			
			List<Aerolinea> aerolineasFiltradas = new ArrayList<Aerolinea>();
			
			for(Aerolinea aerolinea: aerolineas) {
				if(aerolinea.getAlianza() != null) {
					aerolineasFiltradas.add(aerolinea);
					aerolinea.setAlianza(alianzaDao.obtener(aerolinea.getAlianza().getId()));
				}
			}
			
			alianzaDao.close();
			
			
			return aerolineasFiltradas;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Obtener todas las aerolineas CON ALIANZA.
	 * @return
	 */
	public List<Aerolinea> obtenerTodosConAlianza()
	{
		try {
			
			IAerolineaDao aerolineaDao = AerolineaFactory.getImplementation("db");
			List<Aerolinea> aerolineas = aerolineaDao.obtenerTodos();
			aerolineaDao.close();
			
			// Asignamos Alianza /////// MODIFICAR CON FACTORY
			AlianzaDaoImplDB alianzaDao = new AlianzaDaoImplDB();
			////////////////////////////////////////////////////////
			
			for(Aerolinea aerolinea: aerolineas) {
				
				if (aerolinea.getAlianza() != null) {
				
					int id = aerolinea.getAlianza().getId();
				
					Alianza valorAlianza = alianzaDao.obtener(id);
				
					aerolinea.setAlianza(valorAlianza);
				}
			}
			
			alianzaDao.close();
			
			return aerolineas;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
