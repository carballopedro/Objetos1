package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

public class Individuo extends Cliente {
	
	// variable propia de Individuos
	private int dni;
	
	// constructor
	public Individuo(String nombre, String direccion, int dni) {
		super(nombre, direccion);
		this.dni = dni;
	}
	
	// getters
	public int getDni() {
		return this.dni;
	}
	
	// descuento del 10%
	public double descuento() {
		return 0.9;
	}
}
