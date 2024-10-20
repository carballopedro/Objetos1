package ar.edu.unlp.info.oo1.ejercicio17_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	
	private String direccion;
	private String nombre;
	private double precioPorNoche;
	private List<Reserva> reservas;
	
	public Propiedad(String direccion, String nombre, double precioPorNoche) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioPorNoche = precioPorNoche;
		this.reservas = new ArrayList<Reserva>();
	}
	
	// getters
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	// setters
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	// addReserva
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	// CONSULTA DISPONIBILIDAD
	// devuelve TRUE si esta disponible, es decir, si el periodo pasado por parametros no se superpone con NINGUNA reserva
	public boolean estaDisponible(LocalDate fechaInicial, LocalDate fechaFinal) {
		// ALLMATCH = devuelve true si todos los elementos del stream satisfacen el predicado que se recibe como parámetro
		return this.reservas.stream().allMatch(reserva -> reserva.seSuperpone(fechaInicial, fechaFinal) == false);
	}
	
	// calcula ingresos de las reservas de una propiedad (dentro de un periodo de tiempo)
	public double calcularIngresosPropiedad(LocalDate fechaInicial, LocalDate fechaFinal) {
		return this.reservas.stream().
				filter(reserva -> reserva.estaEntre(fechaInicial, fechaFinal) == true).
				mapToDouble(reserva -> reserva.calcularPrecio()).
				sum();
	}
	
	// elimina reserva
	public void eliminar(Reserva reserva) {
		this.reservas.remove(reserva);
	}
}
