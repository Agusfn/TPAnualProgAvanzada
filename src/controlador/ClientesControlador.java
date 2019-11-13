package controlador;

import java.util.List;

import dao.factory.ClienteFactory;
import dao.factory.PasaporteFactory;
import dao.interfaces.IClienteDao;
import dao.interfaces.IPasaporteDao;
import modelo.Cliente;
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
