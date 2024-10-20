package ar.edu.unlp.info.oo1.ejercicio17_alquilerDePropiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	// “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
	// uso (int) para castear a integer ya que ChronoUnit.DAYS.between devuelve double
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(to, from);
	}
	
	
	// PARA COMPARAR FECHAS TENGO DOS OPCIONES
	
	// a.isBefore(b) corresponds to a.compareTo(b) < 0;
	// a.isAfter(b) corresponds to a.compareTo(b) > 0.
	
	
	
	// “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
	
	// INCLUSIVE: tambien devuelve verdadero si la fecha OTHER es igual a FROM o igual a TO
	public boolean includesDate(LocalDate other) {
		return (other.compareTo(this.from) >= 0) && (other.compareTo(this.to) <= 0);
		
		// usando metodos que devuelven booleans
		// return (other.isEqual(this.from) || other.isAfter(this.from)) && (other.isEqual(this.to) || other.isBefore(this.to));
	}
	
	// Retorna TRUE si el período de tiempo del receptor se superpone con el recibido por parámetro
	// devuelve FALSE en caso contrario
	// overlaps si se cumple: (StartDate1 <= EndDate2) and (StartDate2 <= EndDate1)
	public boolean overlaps (DateLapse periodo) {
		return (this.from.compareTo(periodo.getTo()) <= 0) && (this.to.compareTo(periodo.getFrom()) >= 0);
	}
	
	// retorna TRUE si la reserva esta dentro del periodo pasado por parametro
	public boolean estaEntre(DateLapse periodo) {
		return periodo.includesDate(this.to) && periodo.includesDate(this.from);
	}

	
	// devuelve TRUE si el periodo esta en curso (si la fecha de hoy esta dentro del periodo)(o es igual) 

	// a.isBefore(b) corresponds to a.compareTo(b) < 0;
	// a.isAfter(b) corresponds to a.compareTo(b) > 0.
	public boolean estaEnCurso() {
		return (this.from.compareTo(LocalDate.now()) <= 0) && (this.to.compareTo(LocalDate.now()) >= 0);
	}
 
}


// Investigue cómo hacer para crear una fecha determinada, por ejemplo 15/09/1972.

// LocalDate fecha = LocalDate.of(1972, 9, 15);
// System.out.println("La fecha es: " + fecha);
