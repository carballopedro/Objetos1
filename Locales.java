package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.time.LocalDate;

public class Locales extends Envio {

	// variable que tienen los Envios Locales
	private boolean entregaRapida;
	
	// constructor
	public Locales (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double pesoEnGramos, boolean entregaRapida) {
		super(fechaDespacho, direccionOrigen, direccionDestino, pesoEnGramos);
		this.entregaRapida = entregaRapida;
	}
	
	// getters
	public boolean getEntregaRapida() {
		return this.entregaRapida;
	}
	
	// Los envíos locales tienen un costo fijo de $1000 para las entregas estándar y $500 adicional por entrega rápida
	public double calcularCosto() {
		return (this.entregaRapida)? 1500 : 1000;
	}
}
