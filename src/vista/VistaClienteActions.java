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
			} else {
				vista.getTextFieldPaisPersonaliz().setVisible(false);
				vista.getLblPaisPersonaliz().setVisible(false);
			}
			
			if(item.getValue().equals("Argentina")) {
				vista.getTextFieldDirProvinciaCustom().setVisible(false);
				vista.getComboBoxDirProvincia().setVisible(true);
			} else {
				vista.getTextFieldDirProvinciaCustom().setVisible(true);
				vista.getComboBoxDirProvincia().setVisible(false);
			}
			
			
			
		}
		else if(arg0.getSource() == vista.getComboBoxPasaportePaisEmis()) // selección país de emisión de pasaporte
		{
			
			ComboItem item = (ComboItem)vista.getComboBoxPasaportePaisEmis().getSelectedItem();

			if(item.getValue().equals("Otros")) {
				vista.getTextFieldPsprtPaisPersonaliz().setVisible(true);
				vista.getLblPsprtPaisPersonaliz().setVisible(true);
			} else {
				vista.getTextFieldPsprtPaisPersonaliz().setVisible(false);
				vista.getLblPsprtPaisPersonaliz().setVisible(false);
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
				|| vista.textFieldEmail.getText().equals("") || vista.textFieldCuit.getText().equals("") || vista.textFieldDirCalle.getText().equals("") || vista.textFieldDirAltura.getText().equals("")
				|| vista.textFieldDirCiudad.getText().equals("") || vista.textFieldDirCodPostal.getText().equals("") || vista.textFieldPasaporteNro.getText().equals("")
				|| vista.textFieldPasaporteAutoridadEmis.getText().equals("") || vista.textFieldPasaporteFechaEmis.getText().equals("") || vista.textFieldPasaporteFechaVto.getText().equals("")) {
			tirarError("Completá todos los campos");
			return false;
		}
		
		
		if(vista.textFieldTelPersonal.getText().equals("") && vista.textFieldTelCelular.getText().equals("")
				&& vista.textFieldTelLaboral.getText().equals("")) {
			tirarError("Ingresá al menos un teléfono.");
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
				return false;
			}
			
			
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
		
		
		
		if(vista.modoModificarCliente == false) 
		{

			Telefono telefono = new Telefono();
			setearValoresATelefonoDesdeCampos(telefono);
			vista.telControlador.crearTelefono(telefono);
			
			Direccion direccion = new Direccion();
			setearValoresADireccionDesdeCampos(direccion);
			vista.direccionesControlador.crearDireccion(direccion);	
			
			Pasaporte pasaporte = new Pasaporte();
			setearValoresAPasaporteDesdeCampos(pasaporte);
			vista.pasaportesControlador.crearPasaporte(pasaporte);
			
			
			PasajeroFrecuente pasajFrec = null;
			
			ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
			if(item.getKey() != -1) {
				pasajFrec = new PasajeroFrecuente();
				setearValoresAPasajFrecuenteDesdeCampos(pasajFrec);
				vista.pasajFrecControlador.crearPasajeroFrecuente(pasajFrec);
			}
			
			Cliente cliente = new Cliente();
			setearValoresAClienteDesdeCampos(cliente);

			cliente.setTelefono(telefono);
			cliente.setDireccion(direccion);
			cliente.setPasaporte(pasaporte);
			cliente.setPasajeroFrecuente(pasajFrec);
			
			vista.clienteControlador.crearCliente(cliente);
			
		}
		else
		{
			
			Cliente cliente = vista.clienteAModificar;
			
			Telefono telefono = vista.telControlador.obtenerTelefono(cliente.getTelefono().getId());
			setearValoresATelefonoDesdeCampos(telefono);
			vista.telControlador.actualizarTelefono(telefono);
			
			Direccion direccion = vista.direccionesControlador.obtenerDireccion(cliente.getDireccion().getId());
			setearValoresADireccionDesdeCampos(direccion);
			vista.direccionesControlador.actualizarDireccion(direccion);
			
			Pasaporte pasaporte = vista.pasaportesControlador.obtenerPasaporte(cliente.getPasaporte().getId());
			setearValoresAPasaporteDesdeCampos(pasaporte);
			vista.pasaportesControlador.actualizarPasaporte(pasaporte);
			
			ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
			
			if(item.getKey() != -1) {
				
				PasajeroFrecuente pasajFrec;
				
				if(cliente.getPasajeroFrecuente() == null)  {
					pasajFrec = new PasajeroFrecuente();
					setearValoresAPasajFrecuenteDesdeCampos(pasajFrec);
					vista.pasajFrecControlador.crearPasajeroFrecuente(pasajFrec);
					cliente.setPasajeroFrecuente(pasajFrec);
				} 
				else  {
					pasajFrec = vista.pasajFrecControlador.obtenerPasajeroFrecuente(cliente.getPasajeroFrecuente().getId());
					setearValoresAPasajFrecuenteDesdeCampos(pasajFrec);
					vista.pasajFrecControlador.actualizarPasajeroFrecuente(pasajFrec);
				}

			} else {
				if(cliente.getPasajeroFrecuente() != null)  {
					PasajeroFrecuente pasajFrec = cliente.getPasajeroFrecuente();
					cliente.setPasajeroFrecuente(null);
					vista.clienteControlador.actualizarCliente(cliente); // esto es para remover la foreign key de pasajerofrecuente.
					vista.pasajFrecControlador.eliminarPasajeroFrecuente(pasajFrec);
					
				}
			}
			
			setearValoresAClienteDesdeCampos(cliente);
			vista.clienteControlador.actualizarCliente(cliente);

		}

		

	}
	
	
	
	public void setearValoresATelefonoDesdeCampos(Telefono telefono)
	{
		telefono.setNroCelular(vista.textFieldTelCelular.getText());
		telefono.setNroLaboral(vista.textFieldTelLaboral.getText());
		telefono.setNroPersonal(vista.textFieldTelPersonal.getText());
	}
	
	
	
	public void setearValoresADireccionDesdeCampos(Direccion direccion)
	{
		
		direccion.setCalle(vista.textFieldDirCalle.getText());
		direccion.setAltura(vista.textFieldDirAltura.getText());
		direccion.setCiudad(vista.textFieldDirCiudad.getText());
		direccion.setCodigoPostal(vista.textFieldDirCodPostal.getText());
		
		
		ComboItem itemPais = (ComboItem)vista.comboBoxDirPais.getSelectedItem();
		
		if(itemPais.getValue().equals("Otros"))  {  // pais custom
			direccion.setNombrePais(vista.textFieldPaisPersonaliz.getText());
			direccion.setPais(null);
		} else {
			direccion.setPais(new Pais(itemPais.getKey()));
			direccion.setNombrePais(null);
		}
		
		
		if(!itemPais.getValue().equals("Argentina")) { // not Argentina
			direccion.setNombreProvincia(vista.textFieldDirProvinciaCustom.getText());
			direccion.setProvincia(null);
		} else { // Argentina
			ComboItem itemProvincia = (ComboItem)vista.comboBoxDirProvincia.getSelectedItem();
			direccion.setProvincia(new Provincia(itemProvincia.getKey()));
			direccion.setNombreProvincia(null);
		}
		
	}
	
	
	public void setearValoresAPasaporteDesdeCampos(Pasaporte pasaporte)
	{		
		pasaporte.setNumero(vista.textFieldPasaporteNro.getText());
		pasaporte.setAutoridadEmision(vista.textFieldPasaporteAutoridadEmis.getText());
		
		ComboItem itemPaisPssprt = (ComboItem)vista.getComboBoxPasaportePaisEmis().getSelectedItem();
		
		if(itemPaisPssprt.getValue().equals("Otros")) {
			pasaporte.setPaisEmision(null);
			pasaporte.setNombrePaisEmision(vista.textFieldPsprtPaisPersonaliz.getText());
		} else {
			pasaporte.setPaisEmision(new Pais(itemPaisPssprt.getKey()));
			pasaporte.setNombrePaisEmision(null);
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pasaporte.setFechaEmision(LocalDate.parse(vista.textFieldPasaporteFechaEmis.getText(), dtf));
		pasaporte.setFechVencimiento(LocalDate.parse(vista.textFieldPasaporteFechaVto.getText(), dtf));
	}
	
	
	public void setearValoresAPasajFrecuenteDesdeCampos(PasajeroFrecuente pasajFrecuente)
	{
		pasajFrecuente.setNumero(vista.textFieldPasajFrecNro.getText());
		pasajFrecuente.setCategoria(vista.textFieldPasajFrecCategoria.getText());
		
		ComboItem item = (ComboItem)vista.comboBoxPasajFrecAerolinea.getSelectedItem();
		pasajFrecuente.setAerolinea(new Aerolinea(item.getKey()));
	}
	
	
	public void setearValoresAClienteDesdeCampos(Cliente cliente)
	{
		cliente.setNombreYApellido(vista.textFieldNombreYApellido.getText());
		cliente.setDni(vista.textFieldDni.getText());
		cliente.setEmail(vista.textFieldEmail.getText());
		cliente.setCuitOCuil(vista.textFieldCuit.getText());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		cliente.setFechaNacimiento(LocalDate.parse(vista.textFieldFechaNac.getText(), dtf));
	}
	
	
}
