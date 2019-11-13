package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Aerolinea;
import modelo.Alianza;
import util.ComboItem;

public class VistaAerolineasActions implements ActionListener {

private VistaAerolinea vista;
	
	public VistaAerolineasActions(VistaAerolinea vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == vista.getAceptarBtn()) 
		{
				
			if(validarFormulario()) {
				procesarEnvioFormulario();
				
				this.vista.aerolineasControlador.vistaInicio.recargarTablaAerolineas();
				
				
				vista.setVisible(false);
				vista.dispose();
			}
		}
	}
	
	
	public boolean validarFormulario() 
	{
		
		if(vista.getTextField_nombre().getText().equals("")) {
			tirarError("Ingresa el nombre de la aerolinea.");
			return false;
		}
		
		if(vista.getComboBox_alianza().getSelectedIndex() == 0) {
			tirarError("Selecciona una alianza.");
			return false;
		}
		
		return true;
		
	}
	
	public void procesarEnvioFormulario()
	{
		
		Aerolinea aerolinea = new Aerolinea();	
		aerolinea.setNombre(vista.getTextField_nombre().getText());
		
		if(vista.getComboBox_alianza().getSelectedIndex() >= 2) { // Seleccinó alianza.
			aerolinea.setAlianza(crearAlianzaDesdeCampos());
		}
		
		vista.getAerolineasControlador().crearAerolinea(aerolinea);
		
		
	}
	

	public Alianza crearAlianzaDesdeCampos() {
		Alianza alianza = new Alianza();
		ComboItem item = (ComboItem)vista.getComboBox_alianza().getSelectedItem();
		alianza.setId(item.getKey());
		return alianza;
	}
	

	private void tirarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	
	
	
}
