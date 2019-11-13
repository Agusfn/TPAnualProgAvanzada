package controlador;

import java.util.List;

import dao.factory.ClienteFactory;
import dao.factory.DireccionFactory;
import dao.factory.PasajeroFrecuenteFactory;
import dao.factory.PasaporteFactory;
import dao.factory.TelefonoFactory;
import dao.interfaces.IClienteDao;
import dao.interfaces.IDireccionDao;
import dao.interfaces.IPasajeroFrecuenteDao;
import dao.interfaces.IPasaporteDao;
import dao.interfaces.ITelefonoDao;
import modelo.Cliente;
import modelo.Direccion;
import modelo.PasajeroFrecuente;
import modelo.Pasaporte;
import modelo.Telefono;
import vista.VistaCliente;
import vista.VistaInicio;

public class ClientesControlador {

	
	public VistaInicio vistaInicio;
	
	
	public ClientesControlador() 
	{
		
	}
	
	public ClientesControlador(VistaInicio vistaInicio) 
	{
		this.vistaInicio = vistaInicio;
	}
	
	/**
	 * Mostrar ventana para dar de alta nuevo cliente.
	 */
	public void mostrarVentanaCrear()
	{	
		VistaCliente vista = new VistaCliente(this);
		vista.setVisible(true);
	}
	
	
	
	
	/**
	 * Mostrar ventana para dar de alta nuevo cliente.
	 */
	public void mostrarVentanaModificar(int idCliente)
	{	
		
		try {
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			Cliente cliente = clienteDao.obtener(idCliente);
			clienteDao.close();
			
			VistaCliente vista = new VistaCliente(this);
			vista.setModoModificarCliente(cliente);
			vista.setVisible(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	
	public void crearCliente(Cliente cliente)
	{
		try {
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			clienteDao.agregar(cliente);
			clienteDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void actualizarCliente(Cliente cliente)
	{
		try {
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			clienteDao.actualizar(cliente);
			clienteDao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void eliminarClientePorId(int id)
	{
		try 
		{
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			IDireccionDao dirDao = DireccionFactory.getImplementation("db");
			IPasajeroFrecuenteDao pasajFrecDao = PasajeroFrecuenteFactory.getImplementation("db");
			IPasaporteDao pasaporteDao = PasaporteFactory.getImplementation("db");
			ITelefonoDao telDao = TelefonoFactory.getImplementation("db");
			
			Cliente cliente = clienteDao.obtener(id);
			
			Direccion direccion = cliente.getDireccion();
			Pasaporte pasaporte = cliente.getPasaporte();
			Telefono telefono = cliente.getTelefono();
			PasajeroFrecuente pasajFrec = cliente.getPasajeroFrecuente();
			
			clienteDao.eliminar(cliente); // se eliminan las relaciones FK
			
			dirDao.eliminar(direccion);
			pasaporteDao.eliminar(pasaporte);
			telDao.eliminar(telefono);
			if(pasajFrec != null) {
				pasajFrecDao.eliminar(pasajFrec);
			}

			clienteDao.close();
			dirDao.close();
			pasajFrecDao.close();
			pasaporteDao.close();
			telDao.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Obtener un cliente junto con su pasaporte, a partir de su ID.
	 * @return
	 */
	public Cliente obtenerConPasaporte(int id)
	{
		try {
			
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			Cliente cliente = clienteDao.obtener(id);
			clienteDao.close();
			
			// Asignamos pasaporte
			IPasaporteDao pasaporteDao = PasaporteFactory.getImplementation("db");
			cliente.setPasaporte(pasaporteDao.obtener(cliente.getPasaporte().getId()));
			pasaporteDao.close();			
			
			return cliente;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Obtener listado de clientes, con pasaportes.
	 * @return
	 */
	public List<Cliente> obtenerTodos()
	{
		try {
			
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			List<Cliente> clientes = clienteDao.obtenerTodos();
			clienteDao.close();
			
			return clientes;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Obtener listado de clientes, con pasaportes.
	 * @return
	 */
	public List<Cliente> obtenerTodosConPasaportes()
	{
		try {
			
			IClienteDao clienteDao = ClienteFactory.getImplementation("db");
			List<Cliente> clientes = clienteDao.obtenerTodos();
			clienteDao.close();
			
			// Asignamos pasaporte
			IPasaporteDao pasaporteDao = PasaporteFactory.getImplementation("db");
			
			for(Cliente cliente: clientes) {
				cliente.setPasaporte(pasaporteDao.obtener(cliente.getPasaporte().getId()));
			}
			
			pasaporteDao.close();
			
			return clientes;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}
