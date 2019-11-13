package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaVueloActions implements ActionListener{

	
	private VistaVuelo vuelo;
	
	public VistaVueloActions(VistaVuelo vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if(arg0.getSource() == this.vuelo.getAceptarBtn()) {
			 
			
			
			
		}
		
		
	}
	
	
}
