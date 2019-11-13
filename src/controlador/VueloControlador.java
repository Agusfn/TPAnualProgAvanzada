package controlador;

import java.util.List;

import dao.factory.AerolineaFactory;
import dao.factory.AeropuertoFactory;
import dao.factory.ClienteFactory;
import dao.factory.VentaFactory;
import dao.factory.VueloFactory;
import dao.interfaces.IAerolineaDao;
import dao.interfaces.IAeropuertoDao;
import dao.interfaces.IClienteDao;
import dao.interfaces.IVentaDao;
import dao.interfaces.IVueloDao;
import modelo.Cliente;
import modelo.Venta;
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
	 * Obtener un vuelo
	 */
	public Vuelo obtener(int id)
	{
				
		try {
			IVueloDao vueloDao = VueloFactory.getImplementation("db");
			Vuelo vuelo = vueloDao.obtener(id);
			vueloDao.close();
		
			return vuelo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}
	
	
	
	/**
	 * Obtener todos los vuelos
	 */
	public List<Vuelo> obtenerTodos()
	{
			
			
		try {
			IVueloDao vueloDao = VueloFactory.getImplementation("db");
			List<Vuelo> vuelos = vueloDao.obtenerTodos();
			vueloDao.close();
			
			return vuelos;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}

	/**
	 * Obtener vuelo con su respectiva aerolinea y aerops de salida y llegada.
	 */
	public Vuelo obtenerDetallado(int idVuelo)
	{
	
			try 
			{
				IVueloDao vueloDao = VueloFactory.getImplementation("db");
				IAeropuertoDao aeropDao = AeropuertoFactory.getImplementation("db");
				IAerolineaDao aerolineaDao = AerolineaFactory.getImplementation("db");
			
				Vuelo vuelo = vueloDao.obtener(idVuelo);
				
				vuelo.setAerolinea(aerolineaDao.obtener(vuelo.getAerolinea().getId()));
				vuelo.setAeropSalida(aeropDao.obtener(vuelo.getAeropSalida().getId()));
				vuelo.setAeropLlegada(aeropDao.obtener(vuelo.getAeropLlegada().getId()));

				vueloDao.close();
				aeropDao.close();
				aerolineaDao.close();
				
				return vuelo;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
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
					vuelo.setAeropLlegada(aeropDao.obtener(vuelo.getAeropLlegada().getId()));
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
	
	
	/**
	 * Comprobar si el vuelo tiene asientos libres.
	 * @param idVuelo
	 * @return
	 */
	public boolean vueloTieneDisponibilidad(Vuelo vuelo) {

		
		try {
			
			IVentaDao ventaDao = VentaFactory.getImplementation("db");
			List<Venta> ventas = ventaDao.obtenerTodos();
			
			
			int ventasEnVuelo = 0;
			
			for(Venta venta: ventas) {
				if(venta.getVuelo().getId() == vuelo.getId()) {
					ventasEnVuelo ++;
				}	
			}
			
			if(ventasEnVuelo >= vuelo.getCantAsientos()) 
				return false;
			else
				return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
}
	
