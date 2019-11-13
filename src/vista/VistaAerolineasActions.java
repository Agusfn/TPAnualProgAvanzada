package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Aerolinea;
import modelo.Alianza;
import util.ComboItem;

public class VistaAerolineasActions implements ActionListener {

private VistaAerolinea vista;
	
	public VistaAerolineasActions(VistaAerolinea vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == vista.getAceptarBtn()) 
			{
				boolean validarFormulario = true; //validarFormulario()
				
				if(validarFormulario) {
					procesarEnvioFormulario();
					
					this.vista.aerolineasControlador.vistaInicio.recargarTablaAerolineas();
					
					
					vista.setVisible(false);
					vista.dispose();
				}
			}
	}
	
	
	public void procesarEnvioFormulario()
	{
		Alianza alianza = crearAlianzaDesdeCampos();
		
		Aerolinea aerolinea = new Aerolinea();	
		aerolinea.setNombre(vista.getTextField_nombre().getText());
		aerolinea.setAlianza(alianza);
		
		vista.getAerolineasControlador().crearAerolinea(aerolinea);
		
		
	}
	

	public Alianza crearAlianzaDesdeCampos() {
		Alianza alianza = new Alianza();
		ComboItem item = (ComboItem)vista.getComboBox_alianza().getSelectedItem();
		alianza.setId(item.getKey());
		return alianza;
	}
	

	

	
	
	
}
