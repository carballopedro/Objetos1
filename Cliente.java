package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	// variables que tienen todos los Clientes
	private String nombre;
	private String direccion;
	private List<Envio> envios;
	
	// constructor
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<Envio>();
	}
	
	// NO SON NECESARIOS LOS GETTERS
	// getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public List<Envio> getEnvios() {
		return this.envios;
	}
	
	// Agregar un envío para un cliente: dado un cliente y un envío, se agrega ese envío al cliente indicado.
	public void addEnvio(Envio envio) {
		this.envios.add(envio);
	}
	
	
	// Monto a pagar por los envíos realizados dentro de un período
	// Se indica el cliente para el cual se quiere calcular el monto y las fechas de inicio y fin del período a considerar
	// Para calcular el monto total a pagar, se suma el costo de todos los envíos despachados durante el período especificado.
	public double montoAPagar(LocalDate fechaInicio, LocalDate fechaFin) {
		return (this.envios.stream().filter(envio -> envio.seConsidera(fechaInicio, fechaFin) == true)
				.mapToDouble(envio -> envio.calcularCosto()).sum()) * this.descuento();
	}
	
	// las clases hijas deben implementar este método
	protected abstract double descuento();	
	
}
