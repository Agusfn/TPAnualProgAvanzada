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
		
		// Clientes
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
		else if(arg0.getSource() ==  this.vista.getAgregarAerolinea()) 
		{
			vista.aerolineaControlador.mostrarVentanaCrear();
		}
		
	}
	
	 

}
