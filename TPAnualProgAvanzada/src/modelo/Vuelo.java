package modelo;

import java.util.Date;

public class Vuelo {

	private String numero;
	private int cantAsientos;
	private Aeropuerto aeropSalida;
	private Aeropuerto aeropLlegada;
	private Date fechaHoraSalida;
	private Date fechaHoraLlegada;
	private String tiempoDeVuelo;
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCantAsientos() {
		return cantAsientos;
	}
	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}
	public Aeropuerto getAeropSalida() {
		return aeropSalida;
	}
	public void setAeropSalida(Aeropuerto aeropSalida) {
		this.aeropSalida = aeropSalida;
	}
	public Aeropuerto getAeropLlegada() {
		return aeropLlegada;
	}
	public void setAeropLlegada(Aeropuerto aeropLlegada) {
		this.aeropLlegada = aeropLlegada;
	}
	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}
	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}
	public String getTiempoDeVuelo() {
		return tiempoDeVuelo;
	}
	public void setTiempoDeVuelo(String tiempoDeVuelo) {
		this.tiempoDeVuelo = tiempoDeVuelo;
	}
	
	
}
