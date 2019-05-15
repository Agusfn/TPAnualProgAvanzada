package edu.usal.ar.dao.dominio;

import java.util.Date;

public class Pasaporte {

	private String numero;
	private String paisEmision;
	private String autoridadEmision;
	private Date fechaEmision;
	private Date fechVencimiento;
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(String paisEmision) {
		this.paisEmision = paisEmision;
	}
	public String getAutoridadEmision() {
		return autoridadEmision;
	}
	public void setAutoridadEmision(String autoridadEmision) {
		this.autoridadEmision = autoridadEmision;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechVencimiento() {
		return fechVencimiento;
	}
	public void setFechVencimiento(Date fechVencimiento) {
		this.fechVencimiento = fechVencimiento;
	}
	
}
