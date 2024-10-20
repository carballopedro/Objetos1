package ar.edu.unlp.info.oo1.ejercicio17_alquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String direccion;
	private int dni;
	
	// propiedades propias
	private List<Propiedad> propiedades;
	
	// reservas que realiza
	private List<Reserva> reservas;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<Propiedad>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	// getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	
	// setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	// addPropiedad
	public void addPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	// Si la propiedad está disponible, se crea la reserva y la propiedad pasa a estar ocupada durante ese período.
	// Si no lo está, la reserva no será creada.
	public void crearReserva(Propiedad propiedad, LocalDate fechaInicial, LocalDate fechaFinal) {
		if (propiedad.estaDisponible(fechaInicial, fechaFinal)){
			Reserva r = new Reserva(fechaInicial, fechaFinal, propiedad);
			this.reservas.add(r);
			propiedad.addReserva(r);
		}
	}
	
	// calcula la retribución a un propietario
	// la cual es el 75% de la suma de precio totales de las reservas incluidas en un período específico de tiempo.
	public double calcularIngresos(LocalDate fechaInicial, LocalDate fechaFinal) {
		return (this.propiedades.stream()
				.mapToDouble(propiedad -> propiedad.calcularIngresosPropiedad(fechaInicial, fechaFinal))
				.sum()) * 0.75;
	}
	
	// Se debe permitir cancelar una reserva.  En este caso, la propiedad pasa a estar disponible durante 
	// el período de tiempo indicado en la reserva.  Esta operación sólo es permitida si el 
	// período de la reserva no está en curso.
	public void cancelarReserva(Reserva reserva) {
		// si la reserva no esta en curso
		if (reserva.estaEnCurso() == false){
			// elimino la reserva de mi lista de reservas
			this.reservas.remove(reserva);
			// elimina reserva de la lista de reservas que tiene la propiedad
			reserva.eliminarReservaDePropiedad(reserva);
		}
	}
	
}
