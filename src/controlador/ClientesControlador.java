package controlador;

import java.util.List;

import dao.factory.ClienteFactory;
import dao.factory.PasaporteFactory;
import dao.interfaces.IClienteDao;
import dao.interfaces.IPasaporteDao;
import modelo.Cliente;
import vista.VistaCliente;

public class ClientesControlador {

	
	
	
	public ClientesControlador() 
	{
		
	}
	
	
	public void mostrarVentanaCrear()
	{	
		VistaCliente frame = new VistaCliente(this);
		frame.setVisible(true);
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
	
	
	public void mostrarVentanaModificar()
	{	
		
	}
	
	
}
