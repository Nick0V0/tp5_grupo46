package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Prestamo;
import ar.edu.unju.escmi.tp5.exceptions.LibroNoDisponibleException;

public class CollectionPrestamo {
	static public List<Prestamo> prestamos = new ArrayList<Prestamo>();

	public static void agregarPrestamo(Prestamo prestamo) {
		prestamos.add(prestamo);
	}

	public static Prestamo buscarPrestamoLibro(int id) throws LibroNoDisponibleException {
		for (Prestamo prestamo : prestamos) {
			if (prestamo.getLibro().getId() == id ) {
				return prestamo;
			}
		}
		throw new LibroNoDisponibleException("El libro con codigo " + id + " no fue encontrado");
	}

}
