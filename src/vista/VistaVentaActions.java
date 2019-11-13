package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Venta;
import modelo.Vuelo;
import util.ComboItem;
import util.Validation;

public class VistaVentaActions implements ActionListener {

	private VistaVenta vista;
	
	
	public VistaVentaActions(VistaVenta vista) {
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource() == this.vista.btnAceptar) 
		{
			
			if(validarFormulario()) {
				procesarFormulario();
				vista.ventasControlador.vistaInicio.recargarTablaVentas();
				vista.setVisible(false);
				vista.dispose();
			}
			
			
		}
		else if(arg0.getSource() == this.vista.comboBoxMedioPago) 
		{

			ComboItem item = (ComboItem)vista.comboBoxMedioPago.getSelectedItem();
			if(item.getKey() == 0) { // eft
				this.vista.comboBoxCuotas.removeAllItems();
				this.vista.comboBoxCuotas.addItem(new ComboItem(1, "1"));
			}
			else if(item.getKey() == 1) { // tarj
				this.vista.comboBoxCuotas.removeAllItems();
				this.vista.comboBoxCuotas.addItem(new ComboItem(1, "1"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(3, "3"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(6, "6"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(12, "12"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(24, "24"));
			}
		}
		
	}
	
	
	public boolean validarFormulario() 
	{
		
		if(vista.comboBoxCliente.getSelectedIndex() == 0) {
			tirarError("Selecciona un cliente");
			return false;
		}
		if(vista.comboBoxVuelo.getSelectedIndex() == 0) {
			tirarError("Selecciona un vuelo");
			return false;
		}

		
		if(!Validation.validNumeric(vista.textFieldMontoArs.getText()) ||
				vista.textFieldMontoArs.getText().length() > 8) {
			tirarError("Ingresa un monto numérico válido menor a $100.000.");
			return false;
		}
	
		
		ComboItem itemCliente = (ComboItem)vista.comboBoxCliente.getSelectedItem();
		Cliente cliente = vista.clienteControlador.obtenerConPasaporte(itemCliente.getKey());

		
		
		ComboItem itemVuelo = (ComboItem)vista.comboBoxVuelo.getSelectedItem();
		int idVuelo = itemVuelo.getKey();
		
		Vuelo vuelo = vista.vuelosControlador.obtener(idVuelo);
		
		
		if(cliente.getPasaporte().getFechaEmision().isAfter(LocalDate.now())) {
			tirarError("El cliente tiene un pasaporte con fecha de emisión posterior a hoy.");
			return false;
		}
		
		
		if(cliente.getPasaporte().getFechVencimiento().isBefore(vuelo.getFechaHoraLlegada().toLocalDate().plusMonths(6))) {
			tirarError("El cliente tiene un pasaporte que vence antes de los 6 meses posteriores a la llegada del vuelo.");
			return false;
		}
		

		if(!vista.vuelosControlador.vueloTieneDisponibilidad(idVuelo)) {
			tirarError("El vuelo no tiene más disponibilidad!");
			return false;
		}
		

		return true;
	}
	
	
	
	private void tirarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	/**
	 * Procesar la venta
	 */
	private void procesarFormulario()
	{
		
		Venta venta = new Venta();
		
		ComboItem itemCliente = (ComboItem)vista.comboBoxCliente.getSelectedItem();
		int idCliente = itemCliente.getKey();
		venta.setCliente(new Cliente(idCliente));
		
		
		ComboItem itemVuelo = (ComboItem)vista.comboBoxVuelo.getSelectedItem();
		int idVuelo = itemVuelo.getKey();
		venta.setVuelo(new Vuelo(idVuelo));
		
		venta.setFechaHora(LocalDateTime.now());
		
		ComboItem itemFormaPago = (ComboItem)vista.comboBoxMedioPago.getSelectedItem();
		venta.setFormaDePago(itemFormaPago.getValue());
		
		venta.setMonto(Double.parseDouble(vista.textFieldMontoArs.getText()));
		
		ComboItem itemCuotas = (ComboItem)vista.comboBoxCuotas.getSelectedItem();
		venta.setCuotas(itemCuotas.getKey());
		
		vista.ventasControlador.crearVenta(venta);
		
		
	}
	
}
