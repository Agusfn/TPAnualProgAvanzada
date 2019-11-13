package controlador;

import java.util.List;

import dao.factory.AeropuertoFactory;
import dao.factory.ClienteFactory;
import dao.factory.VentaFactory;
import dao.factory.VueloFactory;
import dao.interfaces.IAeropuertoDao;
import dao.interfaces.IClienteDao;
import dao.interfaces.IVentaDao;
import dao.interfaces.IVueloDao;
import modelo.Aeropuerto;
import modelo.Venta;
import vista.VistaInicio;
import vista.VistaVenta;

public class VentasControlador {

	
	public VistaInicio vistaInicio;
	
	public VentasControlador(VistaInicio vistaInicio) {
		this.vistaInicio = vistaInicio;
	}
	
	
	public void mostrarVentanaRegistrarVenta()
	{
		VistaVenta vistaVenta = new VistaVenta(this);
		vistaVenta.setVisible(true);
		
	}
	
	
	
	
	
	/**
	 * Obtener todas las ventas con detalles del cliente, del vuelo (y de este último, aerop salida y llegada)
	 * @return
	 */
	public List<Venta> obtenerTodasConDetalles()
	{
		
		try {
			IVentaDao ventaDao = VentaFactory.getImplementation("db");
			IVueloDao vueloDao = VueloFactory.getImplementation("db");
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			IAeropuertoDao aeropDao = AeropuertoFactory.getImplementation("db");
			
			
			List<Venta> ventas = ventaDao.obtenerTodos();
			
			for(Venta venta: ventas) {
				
				venta.setCliente(clienteDao.obtener(venta.getCliente().getId()));
				venta.setVuelo(vueloDao.obtener(venta.getVuelo().getId()));
				
				Aeropuerto aeropSalida = aeropDao.obtener(venta.getVuelo().getAeropSalida().getId());
				Aeropuerto aeropLlegada = aeropDao.obtener(venta.getVuelo().getAeropLlegada().getId());
				
				venta.getVuelo().setAeropSalida(aeropSalida);
				venta.getVuelo().setAeropLlegada(aeropLlegada);

			}

			
			ventaDao.close();
			vueloDao.close();
			clienteDao.close();
			aeropDao.close();
			
			return ventas;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
