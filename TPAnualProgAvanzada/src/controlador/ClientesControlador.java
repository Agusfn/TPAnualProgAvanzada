package controlador;

import java.sql.SQLException;
import java.util.List;

import dao.factory.ClienteFactory;
import dao.implementations.db.ClienteDaoImplDB;
import dao.interfaces.IClienteDao;
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
	
	
	public List<Cliente> obtenerListaClientes()
	{
		try {
			
			ClienteDaoImplDB clienteDao = new ClienteDaoImplDB();
			
			return clienteDao.obtenerTodos();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void mostrarVentanaModificar()
	{	
		
	}
	
	
}
