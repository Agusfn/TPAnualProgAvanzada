package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaClienteActions implements ActionListener {

	private VistaCliente vista;
	
	public VistaClienteActions(VistaCliente vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if(arg0.getSource() == this.vista.getAceptarBtn()) {
			 
			
			
			
		}
		
		
	}
	
	
}
