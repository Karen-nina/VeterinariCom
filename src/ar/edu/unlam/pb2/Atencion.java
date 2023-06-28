package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Atencion {
	
	Integer idAt;
	private Persona duenio;
	private Mascota mascota;
	private Double precio;
	private ArrayList <Medicamento> medicamento;

	public Atencion(Integer idAt, Persona duenio, Mascota mascota, Double precio) {
		this.idAt = idAt;
		this.duenio = duenio;
		this.mascota = mascota;
		this.precio = precio;
		this.medicamento = new ArrayList<Medicamento>();
	}

	public Integer getIdAt() {
		return idAt;
	}
	
	public Persona getDuenio() {
		return duenio;
	}
	
	public Mascota getMascota() {
		return mascota;
	}
	
	public Double getPrecio() {
		return precio;
	}

	public void agregarMedicamento(Medicamento medicamento) {
		this.medicamento.add(medicamento);
	}
	
	public ArrayList<Medicamento> getMedicamento() {
		return medicamento;
	}

	public Double getTotalPrecioMedicamentos() {
		Double total = 0.0;
		for (Medicamento medicamento2 : medicamento) {
			total+=medicamento2.getPrecio();
		}
		return total;
	}
}
