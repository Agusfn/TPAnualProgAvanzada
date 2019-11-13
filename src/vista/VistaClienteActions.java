package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import modelo.Aerolinea;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Pais;
import modelo.PasajeroFrecuente;
import modelo.Pasaporte;
import modelo.Provincia;
import modelo.Telefono;
import util.ComboItem;
import util.Validation;

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

			if(validarFormulario()) {
				procesarEnvioFormulario();
				vista.clienteControlador.vistaInicio.recargarTablaClientes();
				vista.setVisible(false);
				vista.dispose();
			}
			
		}
		else if(arg0.getSource() == vista.getComboBoxDirPais())  // selección país dirección
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
		else if(arg0.getSource() == vista.comboBoxPasajFrecAerolinea) // selección de aerolínea de pasajero frecuente.
		{
			
			ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
			
			if(item.getKey() == -1) {
				vista.textFieldPasajFrecNro.setEnabled(false);
				vista.textFieldPasajFrecCategoria.setEnabled(false);
			}
			else {
				vista.textFieldPasajFrecNro.setEnabled(true);
				vista.textFieldPasajFrecCategoria.setEnabled(true);
			}
			
		}
		
		
	}
	
	
	
	private boolean validarFormulario()
	{
		
		if(vista.textFieldNombreYApellido.getText().equals("") || vista.textFieldDni.getText().equals("") || vista.textFieldFechaNac.getText().equals("")
				|| vista.textFieldEmail.getText().equals("") || vista.textFieldCuit.getText().equals("") || vista.textFieldTelPersonal.getText().equals("") || vista.textFieldTelCelular.getText().equals("")
				|| vista.textFieldTelLaboral.getText().equals("") || vista.textFieldDirCalle.getText().equals("") || vista.textFieldDirAltura.getText().equals("")
				|| vista.textFieldDirCiudad.getText().equals("") || vista.textFieldDirCodPostal.getText().equals("") || vista.textFieldPasaporteNro.getText().equals("")
				|| vista.textFieldPasaporteAutoridadEmis.getText().equals("") || vista.textFieldPasaporteFechaEmis.getText().equals("") || vista.textFieldPasaporteFechaVto.getText().equals("")) {
			tirarError("Completá todos los campos");
			return false;
		}
		
		
		// Fecha nacimiento
		
		if(!Validation.validDate(vista.textFieldFechaNac.getText(), "dd/MM/yyyy")) {
			tirarError("Ingresa fecha de nacimiento con formato mm/dd/aaaa");
			return false;
		}
		
		// País y provincia dirección
		
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
		else { // otros paises, incluyendo opcion "otros"
			
			if(item.getValue().equals("Otros")) {
				if(vista.textFieldPaisPersonaliz.getText().equals("")) {
					tirarError("Ingresa un país en la dirección");
					return false;
				}
			}

			if(vista.textFieldDirProvinciaCustom.getText().equals("")) {
				tirarError("Ingresa una provincia en la dirección");
				return false;
			}
		}
		
		
		// País pasaporte
		
		item = (ComboItem)vista.comboBoxPasaportePaisEmis.getSelectedItem();
		if(item.getKey() == -1) { // ningún país
			tirarError("Seleccioná un pais de emisión de pasaporte");
			return false;
		}
		else if(item.getValue().equals("Otros")) {
			
			if(vista.textFieldPsprtPaisPersonaliz.getText().equals("")) {
				tirarError("Ingresa un pais de emisión de pasaporte");
			}
			return false;
			
		}
		
		// Fechas pasaporte
		
		if(!Validation.validDate(vista.textFieldPasaporteFechaEmis.getText(), "dd/MM/yyyy") || 
				!Validation.validDate(vista.textFieldPasaporteFechaVto.getText(), "dd/MM/yyyy")) {
			tirarError("Ingresa fechas de pasaporte válidas en formato mm/dd/aaaa");
			return false;
		}
		
		// pasajero frecuente
		
		item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
		
		if(item.getKey() != -1) { // alguna aerolinea
			
			if(vista.textFieldPasajFrecNro.getText().equals("") || vista.textFieldPasajFrecCategoria.getText().equals("")) {
				tirarError("Ingresa el número y categoría de pasajero frecuente");
				return false;
			}
			
		}

		
		return true;
		
		
	}
	
	
	private void tirarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	public void procesarEnvioFormulario()
	{
		
		Telefono telefono = crearTelefonoDesdeCampos();
		vista.telControlador.altaTelefono(telefono);
		
		Direccion direccion = crearDireccionDesdeCampos();
		vista.direccionesControlador.crearDireccion(direccion);	
		
		Pasaporte pasaporte = crearPasaporteDesdeCampos();
		vista.pasaportesControlador.crearPasaporte(pasaporte);
		
		PasajeroFrecuente pasajFrec = null;
		ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
		if(item.getKey() != -1) {
			pasajFrec = crearPasajeroFrecuenteDesdeCampos();
			vista.pasajFrecControlador.crearPasajeroFrecuente(pasajFrec);
		}
		
		
		Cliente cliente = new Cliente();
		
		cliente.setNombreYApellido(vista.textFieldNombreYApellido.getText());
		cliente.setDni(vista.textFieldDni.getText());
		cliente.setEmail(vista.textFieldEmail.getText());
		cliente.setCuitOCuil(vista.textFieldCuit.getText());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		cliente.setFechaNacimiento(LocalDate.parse(vista.textFieldFechaNac.getText(), dtf));
		
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		cliente.setPasaporte(pasaporte);
		cliente.setPasajeroFrecuente(pasajFrec);
		
		vista.clienteControlador.crearCliente(cliente);
	}
	
	
	
	public Telefono crearTelefonoDesdeCampos()
	{
		Telefono telefono = new Telefono();
		
		telefono.setNroCelular(vista.textFieldTelCelular.getText());
		telefono.setNroLaboral(vista.textFieldTelLaboral.getText());
		telefono.setNroPersonal(vista.textFieldTelPersonal.getText());
		
		return telefono;
	}
	
	
	
	public Direccion crearDireccionDesdeCampos()
	{
		Direccion direccion = new Direccion();
		
		direccion.setCalle(vista.textFieldDirCalle.getText());
		direccion.setAltura(vista.textFieldDirAltura.getText());
		direccion.setCiudad(vista.textFieldDirCiudad.getText());
		direccion.setCodigoPostal(vista.textFieldDirCodPostal.getText());
		
		if(customDirPais) {
			direccion.setNombrePais(vista.textFieldPaisPersonaliz.getText());
		} else {
			ComboItem item = (ComboItem)vista.comboBoxDirPais.getSelectedItem();
			int idPais = item.getKey();
			direccion.setPais(new Pais(idPais));
		}
		
		if(customDirProvincia) {
			direccion.setNombreProvincia(vista.textFieldDirProvinciaCustom.getText());
		} else {
			ComboItem item = (ComboItem)vista.comboBoxDirProvincia.getSelectedItem();
			int idProvincia = item.getKey();
			direccion.setProvincia(new Provincia(idProvincia));
		}
		
		return direccion;
	}
	
	
	public Pasaporte crearPasaporteDesdeCampos()
	{
		Pasaporte pasaporte = new Pasaporte();
		
		pasaporte.setNumero(vista.textFieldPasaporteNro.getText());
		pasaporte.setAutoridadEmision(vista.textFieldPasaporteAutoridadEmis.getText());
		
		if(customPsprtPais) {
			pasaporte.setNombrePaisEmision(vista.textFieldPsprtPaisPersonaliz.getText());
		} else {
			ComboItem item = (ComboItem)vista.comboBoxPasaportePaisEmis.getSelectedItem();
			int idPais = item.getKey();
			pasaporte.setPaisEmision(new Pais(idPais));
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pasaporte.setFechaEmision(LocalDate.parse(vista.textFieldPasaporteFechaEmis.getText(), dtf));
		pasaporte.setFechVencimiento(LocalDate.parse(vista.textFieldPasaporteFechaVto.getText(), dtf));
		
		return pasaporte;
	}
	
	
	public PasajeroFrecuente crearPasajeroFrecuenteDesdeCampos()
	{
		
		PasajeroFrecuente pasajFrecuente = new PasajeroFrecuente();
		
		pasajFrecuente.setNumero(vista.textFieldPasajFrecNro.getText());
		pasajFrecuente.setCategoria(vista.textFieldPasajFrecCategoria.getText());
		
		ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
		pasajFrecuente.setAerolinea(new Aerolinea(item.getKey()));
		
		
		return pasajFrecuente;
	}
	
	
	
}
