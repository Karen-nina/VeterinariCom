package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.TreeSet;

public class Persona {

	
	private String nombre;
	private Integer dni;
	private ArrayList <Mascota> mascotas;
	private Integer cantidadDeMascotas;
	
	public Persona(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.mascotas = new ArrayList <Mascota>();
		this.cantidadDeMascotas = 0;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getDni() {
		return this.dni;
	}
	
	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void agregarMascotas(Mascota mascota) throws MascotaDuplicadaException {
		verificarQueLaMascotaNoExista(mascota); 
			this.mascotas.add(mascota);
			this.cantidadDeMascotas++;	
	}

	private boolean verificarQueLaMascotaNoExista(Mascota mascota2) throws MascotaDuplicadaException {
		for (Mascota mascota : mascotas) {
			if(mascota.getId().equals(mascota2.getId())) {
				throw new MascotaDuplicadaException("Esta mascota ya existe");
			}
		}
		return true;
	}

	public Integer getCantidadDeMascotas() {
		return cantidadDeMascotas;
	}

	public TreeSet<Mascota> obtenerMascotasDomesticas() {
		TreeSet <Mascota> mascotasDomesticas = new TreeSet<Mascota>(new OrdenarMascotaPorApodo());
			for (Mascota mascota : mascotas) {
				if(mascota.tipoDeMascota.equals(TipoDeMascota.DOMESTICA)) {
					mascotasDomesticas.add(mascota);
				}
			}
		return mascotasDomesticas;	
	}
	
}
