package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.time.LocalDate;

public abstract class Envio {
	
	// variables que tienen todos los envíos
	private LocalDate fechaDespacho;
	private String direccionOrigen;
	private String direccionDestino;
	private double pesoEnGramos;
	
	// constructor
	public Envio (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double pesoEnGramos) {
		this.fechaDespacho = fechaDespacho;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.pesoEnGramos = pesoEnGramos;
	}
	
	// NO SON NECESARIOS
	// getters
	public LocalDate getFechaDespacho() {
		return this.fechaDespacho;
	}
	
	public String getDireccionOrigen() {
		return this.direccionOrigen;
	}
	
	public String getDireccionDestino() {
		return this.direccionDestino;
	}
	
	public double getPesoEnGramos() {
		return this.pesoEnGramos;
	}
	
	// TRUE si el envío está entre las fechas
	
	// a.isBefore(b) corresponds to a.compareTo(b) < 0;
	// a.isAfter(b) corresponds to a.compareTo(b) > 0.
	public boolean seConsidera(LocalDate fechaInicial, LocalDate fechaFinal) {
		return (this.fechaDespacho.compareTo(fechaInicial) >= 0) && (this.fechaDespacho.compareTo(fechaFinal) <= 0);
	}
	
	// calcula costo de envío
	protected abstract double calcularCosto();
	
}
