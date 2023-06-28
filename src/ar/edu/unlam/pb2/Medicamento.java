package ar.edu.unlam.pb2;

public class Medicamento {
	
	private Integer id;
	private String descripcion;
	private Double precio;

	public Medicamento(Integer id, String descripcion, Double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Double getPrecio() {
		return precio;
	}

}
