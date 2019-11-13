package controlador;

import java.util.List;

import dao.factory.AerolineaFactory;
import dao.factory.AeropuertoFactory;
import dao.factory.ClienteFactory;
import dao.factory.VueloFactory;
import dao.interfaces.IAerolineaDao;
import dao.interfaces.IAeropuertoDao;
import dao.interfaces.IClienteDao;
import dao.interfaces.IVueloDao;
import modelo.Cliente;
import modelo.Vuelo;
import vista.VistaCliente;
import vista.VistaVuelo;

public class VueloControlador {



	public VueloControlador() {}
	
	
	
	public void mostrarVentanaCrear()
	{	
		VistaVuelo vista = new VistaVuelo(this);
		vista.setVisible(true);
	}
	
	
	
	public void mostrarVentanaModificar(int idVuelo)
	{	
		VistaVuelo vista = new VistaVuelo(this);
		vista.setVisible(true);
	}
	
	public void crearVuelo(Vuelo vuelo)
	{
		try {
			IVueloDao vueloDao = VueloFactory.getImplementation("db");
			vueloDao.agregar(vuelo);
			vueloDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Obtener todos los vuelos con su respectiva aerolinea y aerops de salida y llegada.
	 */
	public List<Vuelo> obtenerTodosDetallados()
	{
			
			
			try {
				IVueloDao vueloDao = VueloFactory.getImplementation("db");
				IAeropuertoDao aeropDao = AeropuertoFactory.getImplementation("db");
				IAerolineaDao aerolineaDao = AerolineaFactory.getImplementation("db");
				
				
				List<Vuelo> vuelos = vueloDao.obtenerTodos();
				
				
				for(Vuelo vuelo: vuelos)
				{
					vuelo.setAerolinea(aerolineaDao.obtener(vuelo.getAerolinea().getId()));
					vuelo.setAeropSalida(aeropDao.obtener(vuelo.getAeropSalida().getId()));
					vuelo.setAeropLlegada(aeropDao.obtener(vuelo.getAeropSalida().getId()));
				}
				
				vueloDao.close();
				aeropDao.close();
				aerolineaDao.close();
				
				return vuelos;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

			
		}
	
}
	
