package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.ComboItem;

public class VistaVentaActions implements ActionListener {

	private VistaVenta vista;
	
	
	public VistaVentaActions(VistaVenta vista) {
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource() == this.vista.btnAceptar) 
		{
			
		}
		else if(arg0.getSource() == this.vista.comboBoxMedioPago) 
		{

			ComboItem item = (ComboItem)vista.comboBoxMedioPago.getSelectedItem();
			if(item.getKey() == 0) { // eft
				this.vista.comboBoxCuotas.removeAllItems();
				this.vista.comboBoxCuotas.addItem(new ComboItem(1, "1"));
			}
			else if(item.getKey() == 1) { // tarj
				this.vista.comboBoxCuotas.removeAll();
				this.vista.comboBoxCuotas.addItem(new ComboItem(1, "1"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(3, "3"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(6, "6"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(12, "12"));
				this.vista.comboBoxCuotas.addItem(new ComboItem(24, "24"));
			}
		}
		
	}
	
}
