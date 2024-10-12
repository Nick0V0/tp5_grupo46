package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Prestamo;

public class CollectionPrestamo {
	static public List<Prestamo> prestamos = new ArrayList<Prestamo>();

	public static void agregarPrestamo(Prestamo prestamo) {
		prestamos.add(prestamo);
	}


}
