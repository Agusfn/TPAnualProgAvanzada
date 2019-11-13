package controlador;

import java.util.List;

import dao.factory.AeropuertoFactory;
import dao.factory.VueloFactory;
import dao.interfaces.IAeropuertoDao;
import dao.interfaces.IVueloDao;
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
	
	
	
	public List<Vuelo> obtenerTodas()
		{
			
			
			try {
				IVueloDao vueloaDao = VueloFactory.getImplementation("db");
				
				List<Vuelo> vuelos = vueloaDao.obtenerTodos();
				
				vueloaDao.close();
				
				
				
				
				
				
				
			
				
				IAeropuertoDao aeropuertoDao = AeropuertoFactory.getImplementation("db");
				for(Vuelo vuelo: vuelos)
				{
					
					vuelo.setAeropSalida(aeropuertoDao.obtener(vuelo.getAeropSalida().getId()));
					vuelo.setAeropLlegada(aeropuertoDao.obtener(vuelo.getAeropSalida().getId()));
					
				}
				
				vueloaDao.close();
			
				
				return vuelos;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
			
			
		}}
	
