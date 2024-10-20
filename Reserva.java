package ar.edu.unlp.info.oo1.ejercicio17_alquilerDePropiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	
	private DateLapse fecha;
	private int cantNoches;
	private Propiedad propiedad;
	
	// podria no tener a la propiedad como instancia de reserva
	// podria solo guardarme el precio por noche
	
	
	public Reserva(LocalDate fechaInicial, LocalDate fechaFinal, Propiedad propiedad) {
		this.fecha = new DateLapse(fechaInicial, fechaFinal);
		this.cantNoches = (int) ChronoUnit.DAYS.between(fechaFinal, fechaInicial);
		this.propiedad = propiedad;
	}
	
	// getters
	public LocalDate getFechaInicial() {
		return this.fecha.getFrom();
	}
	
	public LocalDate getFechaFinal() {
		return this.fecha.getTo();
	}
	
	public DateLapse getFechaPeriodo() {
		return this.fecha;
	}
	
	// Dada una reserva, se calcula su precio.  El mismo se obtiene multiplicando la cantidad de noches por el precio por noche.
	public double calcularPrecio() {
		return this.cantNoches * this.propiedad.getPrecioPorNoche();
	}
	
	// consulta si la reserva es entre 2 fechas
	// devuelve TRUE si el periodo pasado por parametros se superpone con la fecha de la reserva
	// devuelve FALSE en caso contrario
	public boolean seSuperpone(LocalDate fechaInicial, LocalDate fechaFinal) {
		DateLapse periodo = new DateLapse(fechaInicial, fechaFinal);
		return this.fecha.overlaps(periodo);
	}
	
	// devuelve TRUE si la reserva esta dentro del periodo pasado por parametro
	public boolean estaEntre(LocalDate fechaInicial, LocalDate fechaFinal) {
		DateLapse periodo = new DateLapse(fechaInicial, fechaFinal);
		return fecha.estaEntre(periodo);
	}
	
	// devuelve true si la reserva esta en curso
	public boolean estaEnCurso() {
		return this.fecha.estaEnCurso();
	}
	
	// hace que la propiedad la elimine de su lista de reservas
	public void eliminarReservaDePropiedad(Reserva reserva) {
		this.propiedad.eliminar(reserva);
	}
}
