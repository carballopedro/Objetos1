package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

public class Pais {
	
	private String nombrePais;
	private double costoEnvio;

	public Pais(String nombrePais, double costoEnvio) {
		this.nombrePais = nombrePais;
		this.costoEnvio = costoEnvio;
	}
	
	// getters
	public String getNombrePais() {
		return this.nombrePais;
	}
	
	public double getCostoEnvio() {
		return this.costoEnvio;
	}
	
	// setters (x si se cambia el costo de envío del país en algun momento
	public void setCostoEnvio(double nuevoCosto) {
		this.costoEnvio = nuevoCosto;
	}
	
}
