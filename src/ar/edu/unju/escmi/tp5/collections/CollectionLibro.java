package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Libro;
import ar.edu.unju.escmi.tp5.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp5.exceptions.LibroNoEncontradoException;


public class CollectionLibro {
	static public List<Libro> libros = new ArrayList<Libro>();

	public static void agregarLibros(Libro libro) {
		libros.add(libro);
	}

	public static Libro buscarLibro(int id) throws LibroNoEncontradoException {
		for (Libro libro : libros) {
			if (libro.getId() == id ) {
				return libro;
			}
		}
		throw new LibroNoEncontradoException("El libro con codigo " + id + "  no se encuentre en la biblioteca");
	}

	public static Libro buscarLibroDisponible(int id) throws LibroNoDisponibleException {
		for (Libro libro : libros) {
			if (libro.getId() == id && libro.isEstado() ) {
				return libro;
			}
		}
		throw new LibroNoDisponibleException("El libro con codigo " + id + " no esta disponible");
	}
	

	public static void precargarLibros() {
		libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", "978-3-16-148410-0", true));
		libros.add(new Libro(2, "El ingenioso hidalgo Don Quijote de la Mancha", "Miguel de Cervantes",
				"978-3-16-148410-1", true));
		libros.add(new Libro(3, "1984", "George Orwell", "978-3-16-148410-2", true));
		libros.add(new Libro(4, "Orgullo y prejuicio", "Jane Austen", "978-3-16-148410-3", true));
		libros.add(new Libro(5, "Moby Dick", "Herman Melville", "978-3-16-148410-4", true));
	}
}

