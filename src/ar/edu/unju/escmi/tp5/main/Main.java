package ar.edu.unju.escmi.tp5.main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionLibro;
import ar.edu.unju.escmi.tp5.collections.CollectionPrestamo;
import ar.edu.unju.escmi.tp5.collections.CollectionUsuario;
import ar.edu.unju.escmi.tp5.dominio.Alumno;
import ar.edu.unju.escmi.tp5.dominio.Bibliotecario;
import ar.edu.unju.escmi.tp5.dominio.Libro;
import ar.edu.unju.escmi.tp5.dominio.Prestamo;
import ar.edu.unju.escmi.tp5.utils.FechaUtil;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String opcion;
		CollectionLibro.precargarLibros();
		CollectionUsuario.precargarUsuarios();

		do {
			System.out.println("\n----- MENÚ PRINCIPAL -----");
			System.out.println("1. Agregar libro");
			System.out.println("2. Registrar usuario");
			System.out.println("3. Registrar préstamo");
			System.out.println("4. Actualizar disponibilidad de libro");
			System.out.println("5. Mostrar libros");
			System.out.println("6. Salir");
			System.out.print("Elige una opción (1-6): ");
			opcion = scanner.nextLine();

			switch (opcion) {
			case "1":
				registrarLibro(scanner);
				break;
			case "2":
				registrarUsuario(scanner);
				break;
			case "3":
				registrarPrestamo(scanner);
				break;
			case "4":
				actualizarDisponibilidadLibro(scanner);
				break;
			case "5":
				mostrarLibros();
				break;
			case "6":
				System.out.println("Saliendo del sistema. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, elige un número del 1 al 6.");
			}
		} while (!opcion.equals("6")); // Salir del bucle cuando se elige la opción 6
	}

	public static void registrarLibro(Scanner scanner) {
		Libro libro = new Libro();

		try {
			System.out.print("Ingrese el ID del libro: ");
			libro.setId(scanner.nextInt());
			scanner.nextLine();

			System.out.print("Ingrese el título del libro: ");
			libro.setTitulo(scanner.nextLine());

			System.out.print("Ingrese el autor del libro: ");
			libro.setAutor(scanner.nextLine());

			System.out.print("Ingrese el ISBN del libro: ");
			libro.setIsbn(scanner.nextLine());

			libro.setEstado(true);

			CollectionLibro.agregarLibros(libro);
			System.out.println("Libro registrado exitosamente.");
		} catch (InputMismatchException e) {
			System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
			scanner.nextLine();

		} catch (Exception e) {
			System.out.println("Ocurrió un error al registrar el libro: " + e.getMessage());
		} finally {
			System.out.println("Registro de libro finalizado.");
		}
	}

	public static void registrarUsuario(Scanner scanner) {
		String op;
		System.out.println("¿Es estudiante o bibliotecario? ");
		System.out.println("1- Alumno     2- Bibliotecario");
		op = scanner.nextLine();

		switch (op) {
		case "1":
			try {
				Alumno alumno = new Alumno();

				System.out.print("Ingrese el ID del alumno: ");
				alumno.setId(scanner.nextInt());
				scanner.nextLine();

				System.out.print("Ingrese el nombre del alumno: ");
				alumno.setNombre(scanner.nextLine());

				System.out.print("Ingrese el apellido del alumno: ");
				alumno.setApellido(scanner.nextLine());

				System.out.print("Ingrese el email del alumno: ");
				alumno.setEmail(scanner.nextLine());

				System.out.print("Ingrese el curso del alumno: ");
				alumno.setCurso(scanner.nextLine());

				System.out.print("Ingrese el número de libreta del alumno: ");
				alumno.setNumeroLibreta(scanner.nextInt());

				CollectionUsuario.agregarUsuario(alumno);
				System.out.println("Alumno registrado exitosamente.");
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Ocurrió un error al registrar el alumno: " + e.getMessage());
			} finally {
				System.out.println("Registro de alumno finalizado.");
			}
			break;

		case "2":
			try {
				Bibliotecario bibliotecario = new Bibliotecario();

				System.out.print("Ingrese el ID del bibliotecario: ");
				bibliotecario.setId(scanner.nextInt());
				scanner.nextLine();

				System.out.print("Ingrese el nombre del bibliotecario: ");
				bibliotecario.setNombre(scanner.nextLine());

				System.out.print("Ingrese el apellido del bibliotecario: ");
				bibliotecario.setApellido(scanner.nextLine());

				System.out.print("Ingrese el email del bibliotecario: ");
				bibliotecario.setEmail(scanner.nextLine());

				System.out.print("Ingrese el legajo del bibliotecario: ");
				bibliotecario.setLegajo(scanner.nextInt());

				CollectionUsuario.agregarUsuario(bibliotecario);
				System.out.println("Bibliotecario registrado exitosamente.");
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Ocurrió un error al registrar el bibliotecario: " + e.getMessage());
			} finally {
				System.out.println("Registro de bibliotecario finalizado.");
			}
			break;

		default:
			System.out.println("Opción no válida.");
			break;
		}
	}

	public static void registrarPrestamo(Scanner scanner) {
		Prestamo prestamo = new Prestamo();

		try {
			System.out.print("Ingrese el ID del Prestamo: ");
			prestamo.setId(scanner.nextInt());
			scanner.nextLine();

			System.out.print("Ingrese el ID del libro que desea buscar: ");
			try {
				int id=scanner.nextInt();
				CollectionLibro.buscarLibro(id);
				prestamo.setLibro(CollectionLibro.buscarLibroDisponible(id));
			} catch (Exception e) {
				System.out.println("Error al buscar el libro: " + e.getMessage());
				return;
			} finally {
				scanner.nextLine();

			}

			System.out.print("Ingrese el ID del usuario que desea buscar: ");
			try {
				prestamo.setUsuario(CollectionUsuario.buscarUsuario(scanner.nextInt()));
			} catch (Exception e) {
				System.out.println("Error al buscar el usuario: " + e.getMessage());
				return;
			} finally {
				scanner.nextLine();
			}

			System.out.print("Ingrese fecha de devolucion (formato dd/MM/yyyy): ");
			String fechaDevolucionStr = scanner.nextLine();
			LocalDate fechaDevolucion;
			try {
				fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaDevolucionStr);
				prestamo.setFechaDevolucion(fechaDevolucion);
			} catch (DateTimeParseException e) {
				System.out.println("Error en el formato de fecha: " + e.getMessage());

			}

			System.out.print("Ingrese fecha del prestamo (formato dd/MM/yyyy): ");
			String fechaPrestamoStr = scanner.nextLine();
			LocalDate fechaPrestamo;
			try {
				fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaPrestamoStr);
				prestamo.setFechaPrestamo(fechaPrestamo);
			} catch (DateTimeParseException e) {
				System.out.println("Error en el formato de fecha: " + e.getMessage());

			}
			prestamo.getLibro().setEstado(false);
			CollectionPrestamo.agregarPrestamo(prestamo);
			System.out.println("Préstamo registrado exitosamente.");

		} catch (InputMismatchException e) {
			System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Ocurrió un error al registrar el préstamo: " + e.getMessage());
		} finally {
			System.out.println("Registro de préstamo finalizado.");
		}

	}

	public static void actualizarDisponibilidadLibro(Scanner scanner) {
		Prestamo actualizarLibro = null;
		System.out.print("Ingrese el ID del libro que desea devolver para actualizar: ");
		try {
			int libroId = scanner.nextInt();
			scanner.nextLine();
			Libro libro = CollectionLibro.buscarLibro(libroId);

			if (libro == null) {
				System.out.println("Libro no encontrado.");
				return;
			}

			for (Prestamo prestamo : CollectionPrestamo.prestamos) {
				if (prestamo.getLibro().getId() == libro.getId()) {
					actualizarLibro = prestamo;
					System.out.print("¿Desea marcar el libro '" + actualizarLibro.getLibro().getTitulo()
							+ "' como disponible? (s/n): ");
					String respuesta = scanner.nextLine();
					if (respuesta.equals("s")) {
						System.out.print("Ingrese fecha de devolucion (formato dd/MM/yyyy): ");
						String fechaDevolucionStr = scanner.nextLine();
						LocalDate fechaDevolucion;
						try {
							fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaDevolucionStr);
							actualizarLibro.registrarDevolucion(fechaDevolucion, actualizarLibro);
							System.out.println("El libro ha sido marcado como disponible.");
						} catch (DateTimeParseException e) {
							System.out.println("Error en el formato de fecha: " + e.getMessage());
						}
					} else if (respuesta.equals("n")) {
						System.out.println("El libro no ha sufrido cambios.");
					} else {
						System.out.println("Respuesta no válida. El estado del libro no ha sido modificado.");
					}
					return;
				}
			}

			System.out.println("El libro no ha sido prestado.");

		} catch (InputMismatchException e) {
			System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void mostrarLibros() {
		System.out.println("Lista de libros disponibles:");
		for (Libro libro : CollectionLibro.libros) {
			System.out.println();
			libro.mostrarDatos(libro);
		}
	}
}
