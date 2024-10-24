package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

public class Empresa extends Cliente {

	// variable propia de Empresas
	private int cuit;
	
	// constructor
	public Empresa(String nombre, String direccion, int cuit) {
		super(nombre, direccion);
		this.cuit = cuit;
	}
	
	// getters
	public int getCuit() {
		return this.cuit;
	}
	
	// no tiene descuento
	public double descuento() {
		return 1;
	}

}
