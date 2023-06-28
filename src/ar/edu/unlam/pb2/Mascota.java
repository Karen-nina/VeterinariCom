package ar.edu.unlam.pb2;
import java.util.Objects;

public class Mascota extends OrdenarMascotaPorApodo{
	
	private Integer id;
	private String nombre;
	private String apodo;
	TipoDeMascota tipoDeMascota;

	public Mascota(Integer id, String nombre, String apodo, TipoDeMascota tipoDeMascota) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.tipoDeMascota = tipoDeMascota;
	}
	
	public String getApodo() {
		return apodo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public TipoDeMascota getTipoDeMascota() {
		return tipoDeMascota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apodo, id, nombre, tipoDeMascota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(apodo, other.apodo) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && tipoDeMascota == other.tipoDeMascota;
	}



	

}
