package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.time.LocalDate;

public class Interurbanos extends Envio {

	// variable propia de Envios Interurbanos
	private double distanciaEnKms;
	
	// constructor
	public Interurbanos (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino,
			double pesoEnGramos, double distanciaEnKms) {
		super(fechaDespacho, direccionOrigen, direccionDestino, pesoEnGramos);
		this.distanciaEnKms = distanciaEnKms;
	}
	
	// getters
	public double getDistanciaEnKms() {
		return this.distanciaEnKms;
	}
	
	// Los envíos interurbanos tienen un costo que depende de la distancia entre el origen y el destino
	// (utilice $20 para menos de 100 km por cada gramo de peso, $25 para distancias entre 100 km y 500 km 
	// por gramo de peso, y $30 para distancias de más de 500 km por gramo de peso). 
	public double calcularCosto() {
		double kmPorCadaGramo = this.distanciaEnKms / this.getPesoEnGramos();
		return (kmPorCadaGramo > 500)? 30 : ((kmPorCadaGramo >= 100)? 25 : 20);
	}
	
}
