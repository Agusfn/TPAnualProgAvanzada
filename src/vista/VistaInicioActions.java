package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class VistaInicioActions implements ActionListener {
	
	private VistaInicio vista;
	
	public VistaInicioActions(VistaInicio vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// ***********Clientes***********
		
		if(arg0.getSource() == this.vista.getAgregarCliente()) 
		{
			 vista.clientesControlador.mostrarVentanaCrear();
		}
		else if(arg0.getSource() == vista.btnModificarCliente) 
		{
			
			int fila = vista.tableClientes.getSelectedRow();
			
			if(fila == -1) {
				JOptionPane.showMessageDialog(null, "Selecciona un cliente");
				return;
			}
			
			int idCliente = Integer.parseInt(vista.tableClientes.getModel().getValueAt(fila, 0).toString());
			vista.clientesControlador.mostrarVentanaModificar(idCliente);
			
		}
		else if(arg0.getSource() == this.vista.btnEliminarCliente)
		{
			
			int fila = vista.tableClientes.getSelectedRow();
			
			if(fila == -1) {
				JOptionPane.showMessageDialog(null, "Selecciona un cliente");
				return;
			}
			
			int idCliente = Integer.parseInt(vista.tableClientes.getModel().getValueAt(fila, 0).toString());
			
			int dialogResult = JOptionPane.showConfirmDialog (null, "¿Eliminar?","", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				if(vista.clientesControlador.tieneVentasAsociadas(idCliente)) {
					JOptionPane.showMessageDialog(null, "El cliente tiene ventas asociadas, no se puede eliminar.");
					return;
				}
				vista.clientesControlador.eliminarClientePorId(idCliente);
				vista.recargarTablaClientes();
			}
			
		}
		
		// ***********Aerolineas***********
		
		else if(arg0.getSource() ==  this.vista.getAgregarAerolinea()) 
		{
			vista.aerolineaControlador.mostrarVentanaCrear();
		}

		// *********** VENTAS ***********
		
		
		else if(arg0.getSource() == this.vista.btnCrearVenta) {
			this.vista.ventasControlador.mostrarVentanaRegistrarVenta();
		}
		else if(arg0.getSource() == this.vista.btnDetallesVenta) {

			
			int fila = vista.tableVentas.getSelectedRow();
			
			if(fila == -1) {
				JOptionPane.showMessageDialog(null, "Selecciona una venta");
				return;
			}
			
			int idVenta = Integer.parseInt(vista.tableVentas.getModel().getValueAt(fila, 0).toString());
			
			vista.ventasControlador.mostrarVentanaDetallesVenta(idVenta);
			
		}
	}
	
	 

}
