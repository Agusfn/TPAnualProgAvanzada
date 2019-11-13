package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import util.ComboItem;

public class VistaClienteActions implements ActionListener {

	private VistaCliente vista;
	
	private boolean customDirPais = false;
	private boolean customDirProvincia = true;
	private boolean customPsprtPais = false;
	
	public VistaClienteActions(VistaCliente vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if(arg0.getSource() == vista.getAceptarBtn()) 
		{

			validarFormulario();
			
		}
		else if(arg0.getSource() == vista.getComboBoxDirPais()) 
		{
			
			ComboItem item = (ComboItem)vista.getComboBoxDirPais().getSelectedItem();

			if(item.getValue().equals("Otros")) {
				vista.getTextFieldPaisPersonaliz().setVisible(true);
				vista.getLblPaisPersonaliz().setVisible(true);
				customDirPais = true;
			} else {
				vista.getTextFieldPaisPersonaliz().setVisible(false);
				vista.getLblPaisPersonaliz().setVisible(false);
				customDirPais = false;
			}
			
			if(item.getValue().equals("Argentina")) {
				vista.getTextFieldDirProvinciaCustom().setVisible(false);
				vista.getComboBoxDirProvincia().setVisible(true);
				customDirProvincia = false;
			} else {
				vista.getTextFieldDirProvinciaCustom().setVisible(true);
				vista.getComboBoxDirProvincia().setVisible(false);
				customDirProvincia = true;
			}
			
			
			
		}
		else if(arg0.getSource() == vista.getComboBoxPasaportePaisEmis()) // selección país de emisión de pasaporte
		{
			
			ComboItem item = (ComboItem)vista.getComboBoxPasaportePaisEmis().getSelectedItem();

			if(item.getValue().equals("Otros")) {
				vista.getTextFieldPsprtPaisPersonaliz().setVisible(true);
				vista.getLblPsprtPaisPersonaliz().setVisible(true);
				customPsprtPais = true;
			} else {
				vista.getTextFieldPsprtPaisPersonaliz().setVisible(false);
				vista.getLblPsprtPaisPersonaliz().setVisible(false);
				customPsprtPais = false;
			}
			
		}
		
		
	}
	
	
	
	private boolean validarFormulario()
	{
		
		if(vista.textFieldNombreYApellido.getText().equals("") || vista.textFieldDni.getText().equals("") || vista.textFieldFechaNac.getText().equals("")
				|| vista.textFieldEmail.getText().equals("") || vista.textFieldTelPersonal.getText().equals("") || vista.textFieldTelCelular.getText().equals("")
				|| vista.textFieldTelLaboral.getText().equals("") || vista.textFieldDirCalle.getText().equals("") || vista.textFieldDirAltura.getText().equals("")
				|| vista.textFieldDirCiudad.getText().equals("") || vista.textFieldDirCodPostal.getText().equals("") || vista.textFieldPasaporteNro.getText().equals("")
				|| vista.textFieldPasaporteAutoridadEmis.getText().equals("") || vista.textFieldPasaporteFechaEmis.getText().equals("") || vista.textFieldPasaporteFechaVto.getText().equals("")
				|| vista.textFieldPasajFrecNro.getText().equals("") || vista.textFieldPasajFrecCategoria.getText().equals("")) {
			tirarError("Completá todos los campos");
			return false;
		}
		
		ComboItem item = (ComboItem)vista.comboBoxDirPais.getSelectedItem();
		
		if(item.getKey() == -1) { // ningún país
			tirarError("Seleccioná un pais de la dirección");
			return false;
		}
		else if(item.getKey() == 1) // pais Argentina
		{
			item = (ComboItem)vista.comboBoxDirProvincia.getSelectedItem();
			
			if(item.getKey() == -1) {
				tirarError("Selecciona una provincia de la dirección");
				return false;
			}
			
		}
		else { // "otros" países
			if(vista.textFieldPaisPersonaliz.getText().equals("")) {
				tirarError("Ingresa un país en la dirección");
				return false;
			}
			if(vista.textFieldDirProvinciaCustom.getText().equals("")) {
				tirarError("Ingresa una provincia en la dirección");
				return false;
			}
		}
		
		
		
		
		
		
		
		
		return true;
		
		
	}
	
	
	private void tirarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
}
