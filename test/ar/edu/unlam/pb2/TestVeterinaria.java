package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		assertEquals(nombre, vet.getNombre());
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		String nombre = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombre, dni);
		assertEquals(nombre, duenio.getNombre());
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		// El tipo de mascota puede ser solamente doméstica y exótica (enum)
		Integer id = 1;
		String nombre = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota perro = new Mascota (id, nombre, apodo, tipoDeMascota);
		
		assertEquals(id, perro.getId());
		assertEquals(nombre, perro.getNombre());
		assertEquals(apodo, perro.getApodo());
		assertEquals(tipoDeMascota, perro.getTipoDeMascota());
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws MascotaDuplicadaException {
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombreDuenio, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota perro = new Mascota (id, nombreMascota, apodo, tipoDeMascota);
		
		Integer id2 = 2;
		String nombreMascota2 = "Rolly";
		String apodo2 = "Ro";
		TipoDeMascota tipoDeMascota2 = TipoDeMascota.DOMESTICA; 
		Mascota perro2 = new Mascota (id2, nombreMascota2, apodo2, tipoDeMascota2);
		
		
		duenio.agregarMascotas(perro);
		duenio.agregarMascotas(perro2);
	
		assertEquals((Integer)2, duenio.getCantidadDeMascotas());
		
	}
	
	@Test (expected = MascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException() throws MascotaDuplicadaException {
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombre, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota perro = new Mascota (id, nombre, apodo, tipoDeMascota);
		
		Integer id2 = 1;
		String nombreMascota2 = "Rolly";
		String apodo2 = "Ro";
		TipoDeMascota tipoDeMascota2 = TipoDeMascota.DOMESTICA; 
		Mascota perro2 = new Mascota (id2, nombreMascota2, apodo2, tipoDeMascota2);
		
		duenio.agregarMascotas(perro);
		duenio.agregarMascotas(perro2);		
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		
		Integer id = 1;
		String descripcion = "Ibuprofeno";
		Double precio = 2000.0;
		Medicamento medicamento = new Medicamento (id, descripcion, precio);
		assertEquals(id, medicamento.getId());
		
	}
	
	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() throws MascotaDuplicadaException {
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombre, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota perro = new Mascota (id, nombre, apodo, tipoDeMascota);
		
		Integer id2 = 2;
		String nombreMascota2 = "Rolly";
		String apodo2 = "Ro";
		TipoDeMascota tipoDeMascota2 = TipoDeMascota.DOMESTICA; 
		Mascota perro2 = new Mascota (id2, nombreMascota2, apodo2, tipoDeMascota2);
		
		duenio.agregarMascotas(perro);
		duenio.agregarMascotas(perro2);
		
		vet.agregarDuenioQueTengaMascota(duenio);
		ArrayList <Persona> dueniosConMascota = new ArrayList <Persona>();
		dueniosConMascota.add(duenio);
		
		assertEquals(dueniosConMascota, vet.getDueniosConMascotas());
		
	}	
	
	@Test
	public void queSePuedaCrearUnaAtencionConUnDuenioMascotaYPrecio() throws DuenioInexistenteException, MascotaNoEncontradaException{
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombre, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota mascota = new Mascota (id, nombre, apodo, tipoDeMascota);
		
		Double precio = 2000.0;
		Integer idAt = 1;

		Atencion atencion = new Atencion(idAt, duenio, mascota, precio);
		
		assertEquals(idAt, atencion.getIdAt());
		
	}
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() {
		// Para asignar un medicamento necesita el id de la atencion y el id del medicamento
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombre, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota mascota = new Mascota (id, nombre, apodo, tipoDeMascota);
		
		Double precio = 2000.0;
		Integer idAt = 1;

		Atencion atencion = new Atencion(idAt, duenio, mascota, precio);
		
		Integer idMed = 1;
		String descripcion = "Ibuprofeno";
		Double precioMed = 2000.0;
		Medicamento medicamento = new Medicamento (idMed, descripcion, precioMed);
		
		Integer idMed2 = 2;
		String descripcion2 = "Ibuprofeno";
		Double precioMed2 = 2000.0;
		Medicamento medicamento2 = new Medicamento (idMed, descripcion, precioMed);
		
		atencion.agregarMedicamento(medicamento);
		atencion.agregarMedicamento(medicamento2);
		
		ArrayList <Medicamento> medicamentosEnLaAtencion = new ArrayList <Medicamento>();
		medicamentosEnLaAtencion.add(medicamento);
		medicamentosEnLaAtencion.add(medicamento2);
		
		assertEquals(medicamentosEnLaAtencion, atencion.getMedicamento());
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() {
		// El precio total de la atencion será la suma del precio de la atencion mas la suma del precio de todos los medicamentos
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombreDuenio, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota mascota = new Mascota (id, nombreMascota, apodo, tipoDeMascota);
		
		Double precio = 2000.0;
		Integer idAt = 1;

		Atencion atencion = new Atencion(idAt, duenio, mascota, precio);
		
		Integer idMed = 1;
		String descripcion = "Ibuprofeno";
		Double precioMed = 2000.0;
		Medicamento medicamento = new Medicamento (idMed, descripcion, precioMed);
		
		Integer idMed2 = 2;
		String descripcion2 = "Ibuprofeno";
		Double precioMed2 = 2000.0;
		Medicamento medicamento2 = new Medicamento (idMed, descripcion, precioMed);
		
		atencion.agregarMedicamento(medicamento);
		atencion.agregarMedicamento(medicamento2);
		vet.agregarAtencion(atencion);
		Double precioAtencion = vet.precioFinalDeLaAtencion(atencion);
		Double precioEsperado = 6000.0;
		
		assertEquals(precioEsperado, precioAtencion);
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() throws MascotaDuplicadaException {
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombreDuenio, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota mascota = new Mascota (id, nombreMascota, apodo, tipoDeMascota);
		
		Integer id2 = 2;
		String nombreMascota2 = "Rolly";
		String apodo2 = "Ro";
		TipoDeMascota tipoDeMascota2 = TipoDeMascota.EXOTICA; 
		Mascota perro2 = new Mascota (id2, nombreMascota2, apodo2, tipoDeMascota2);
		
		Integer id3 = 3;
		String nombreMascota3 = "Lolly";
		String apodo3 = "Lo";
		TipoDeMascota tipoDeMascota3 = TipoDeMascota.DOMESTICA; 
		Mascota mascota3 = new Mascota (id3, nombreMascota3, apodo3, tipoDeMascota3);
		
		duenio.agregarMascotas(mascota);
		duenio.agregarMascotas(perro2);
		duenio.agregarMascotas(mascota3);
		
		TreeSet<Mascota> mascotas2 = duenio.obtenerMascotasDomesticas();
		
		assertEquals(apodo3, mascotas2.first().getApodo());
		assertEquals(apodo, mascotas2.last().getApodo());
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() throws MascotaDuplicadaException {
		String nombre = "Alicia";
		Veterinaria vet = new Veterinaria(nombre);
		
		String nombreDuenio = "Raul";
		Integer dni = 45671234;
		Persona duenio = new Persona(nombreDuenio, dni);
		
		Integer id = 1;
		String nombreMascota = "Rolly";
		String apodo = "Ro";
		TipoDeMascota tipoDeMascota = TipoDeMascota.DOMESTICA; 
		Mascota mascota = new Mascota (id, nombreMascota, apodo, tipoDeMascota);
		
		Integer id2 = 2;
		String nombreMascota2 = "Rolly";
		String apodo2 = "Ro";
		TipoDeMascota tipoDeMascota2 = TipoDeMascota.EXOTICA; 
		Mascota perro2 = new Mascota (id2, nombreMascota2, apodo2, tipoDeMascota2);
		
		Double precio = 2000.0;
		Integer idAt = 1;
		Integer idAt2 = 2;

		Atencion atencion = new Atencion(idAt, duenio, mascota, precio);
		Atencion atencion2 = new Atencion(idAt2, duenio, perro2, precio);
		vet.agregarAtencion(atencion);
		vet.agregarAtencion(atencion2);
		
		duenio.agregarMascotas(mascota);
		duenio.agregarMascotas(perro2);
		
		HashMap <Integer,Integer> atencionMascotas = new HashMap<Integer,Integer>();
		atencionMascotas.put(idAt, id);
		atencionMascotas.put(idAt2, id2);
		
		assertEquals(atencionMascotas, vet.obtenerUnMapaConUnIdAtencionYUnIdMascota());
	}
	
}
