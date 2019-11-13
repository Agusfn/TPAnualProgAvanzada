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
					vista.getAerolineasControlador().vistaInicio.recargarTablaAerolineas();
					vista.setVisible(false);
					vista.dispose();
				}
			}
	}
	
	
	public void procesarEnvioFormulario()
	{
		Alianza alianza = crearAlianzaDesdeCampos();
		
		//vista.alianzasControlador.crearAlianza(alianza);

		ComboItem item = (ComboItem)vista.getComboBox_alianza().getSelectedItem();
		
		/*
		if(item.getKey() != -1) {
			pasajFrec = crearPasajeroFrecuenteDesdeCampos();
			vista.pasajFrecControlador.crearPasajeroFrecuente(pasajFrec);
		}
		*/
		
		Aerolinea aerolinea = new Aerolinea();	
		aerolinea.setNombre(vista.getTextField_nombre().getText());
		aerolinea.setAlianza(alianza);
		
		vista.getAerolineasControlador().crearAerolinea(aerolinea);
		
	}
	

	public Alianza crearAlianzaDesdeCampos() {
		Alianza alianza = new Alianza();
		
		alianza.setId(1);
		alianza.setNombre("FlyBondi");
		
		return alianza;
	}
	

	

	
	
	
}
