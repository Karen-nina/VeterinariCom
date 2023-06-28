package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Veterinaria {

	private String nombre;
	private ArrayList <Persona> dueniosConMascotas;
	private HashSet <Atencion> atenciones;
 	
	public Veterinaria(String nombre) {
		this.nombre = nombre;
		this.dueniosConMascotas = new ArrayList<Persona>();
		this.atenciones = new HashSet<Atencion>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregarDuenioQueTengaMascota(Persona duenio) {
		if(duenio.getMascotas() != null) {
			this.dueniosConMascotas.add(duenio);
		}
	}
	
	public ArrayList<Persona> getDueniosConMascotas() {
		return dueniosConMascotas;
	}
	
	public HashSet<Atencion> getAtenciones() {
		return atenciones;
	}

	public Double precioFinalDeLaAtencion(Atencion atencion) {
		Double totalPrecio = 0.0;
		for (Atencion atencion2 : atenciones) {
			if(atencion.getIdAt().equals(atencion2.getIdAt())) {
				totalPrecio+=(atencion.getPrecio() + atencion.getTotalPrecioMedicamentos());
			}
		}
		return totalPrecio;
	}

	public void agregarAtencion(Atencion atencion) {
		this.atenciones.add(atencion);
		
	}

	public HashMap<Integer, Integer> obtenerUnMapaConUnIdAtencionYUnIdMascota() {
		HashMap <Integer,Integer> atencionMascotas = new HashMap <Integer,Integer>();
		for (Atencion atencion : atenciones) {
			atencionMascotas.put(atencion.getIdAt(), atencion.getMascota().getId());
		}
		return atencionMascotas;
	}


}
