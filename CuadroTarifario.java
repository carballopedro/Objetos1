package ar.edu.unlp.info.oo1.ejercicio19_envioDePaquetes;

import java.util.ArrayList;
import java.util.List;

public class CuadroTarifario {

	private List<Pais> paises;
	
	// constructor
	public CuadroTarifario() {
		this.paises = new ArrayList<Pais>();
	}
	
	// agrega nueva tarifa
	public void addTarifa(Pais pais) {
		this.paises.add(pais);
	}
	
	// calcular costo del pais pasado por parametro
	public double calculaCostoPais(String nombrePais) {
		return this.paises.stream()
				.filter(pais -> pais.getNombrePais().contains(nombrePais))
				.mapToDouble(pais -> pais.getCostoEnvio()).sum();
	}
}
