package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.time.LocalDate;

public class Internacionales extends Envio {
	
	// constructor
	public Internacionales(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double pesoEnGramos) {
		super(fechaDespacho, direccionOrigen, direccionDestino, pesoEnGramos);
	}
	
	// Los envíos internacionales tienen un costo que depende del país destino y del peso del paquete.
	// Por ahora, utilice $5000 para cualquier destino y $10 por gramo de peso para envios de hasta 1 kg y $12 para envíos de más de 1 kg.
	public double calcularCosto() {
		double costo = 5000;
		double pesoEnGramos = this.getPesoEnGramos();
		double pesoEnKg = pesoEnGramos / 1000;
		return (pesoEnKg > 1)? costo + (pesoEnGramos * 12) : costo + (pesoEnGramos * 10);
	}

}
