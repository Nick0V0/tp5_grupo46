package ar.edu.unju.escmi.tp5.main;


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
			// Mostrar el menú principal
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
		} while (!opcion.equals("6"));
	}

	public static void registrarLibro(Scanner scanner) {
		Libro libro = new Libro();
		try {
			// Bucle para solicitar el ID del libro con un número válido
			while (true) {
				System.out.print("Ingrese el ID del libro: ");
				try {
					libro.setId(scanner.nextInt());
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
					scanner.nextLine();
				}
			}
			// Solicitar el título del libro
			System.out.print("Ingrese el título del libro: ");
			libro.setTitulo(scanner.nextLine());

			// Solicitar el autor del libro
			System.out.print("Ingrese el autor del libro: ");
			libro.setAutor(scanner.nextLine());

			// Solicitar el ISBN del libro
			System.out.print("Ingrese el ISBN del libro: ");
			libro.setIsbn(scanner.nextLine());

			// Agregar el libro a la colección
			libro.setEstado(true);
			CollectionLibro.agregarLibros(libro);
			System.out.println("Libro registrado exitosamente.");

		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al registrar el libro: " + e.getMessage());
		}
	}

	
	public static void registrarUsuario(Scanner scanner) {
	    // Solicitar el tipo de usuario a registrar
		String op;
		System.out.println("¿Es estudiante o bibliotecario? ");
		System.out.println("1- Alumno     2- Bibliotecario     3- Ninguno");
		op = scanner.nextLine();

		switch (op) {
		case "1":	// Opción para registrar un alumno
			try {
				Alumno alumno = new Alumno();
				
                // Bucle para solicitar el ID del alumno con un valor válido
				while (true) {
					System.out.print("Ingrese el ID del alumno: ");
					try {
						alumno.setId(scanner.nextInt());
						scanner.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
						scanner.nextLine();
					}
				}

				// Solicitar el nombre del alumno
				System.out.print("Ingrese el nombre del alumno: ");
				alumno.setNombre(scanner.nextLine());


                // Solicitar el apellido del alumno
				System.out.print("Ingrese el apellido del alumno: ");
				alumno.setApellido(scanner.nextLine());

                // Solicitarr el email del alumno
				System.out.print("Ingrese el email del alumno: ");
				alumno.setEmail(scanner.nextLine());

				// Solicitar el curso del alumno
				System.out.print("Ingrese el curso del alumno: ");
				alumno.setCurso(scanner.nextLine());

				// Solicitar el número de libreta del alumno
				System.out.print("Ingrese el número de libreta del alumno: ");
				alumno.setNumeroLibreta(scanner.nextInt());

				// Agregar el alumno a la colección 
				CollectionUsuario.agregarUsuario(alumno);
				System.out.println("Alumno registrado exitosamente.");

			} catch (Exception e) {
				System.out.println("Ocurrió un error inesperado al registrar el alumno: " + e.getMessage());
			}
			break;

		case "2":
			try {	// Opción para registrar un bibliotecario
				Bibliotecario bibliotecario = new Bibliotecario();

                // Bucle para solicitar el ID con un valor válido
				while (true) {
					System.out.print("Ingrese el ID del bibliotecario: ");
					try {
						bibliotecario.setId(scanner.nextInt());
						scanner.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
						scanner.nextLine();
					}
				}
				
				// Solicitar el nombre del bibliotecario
				System.out.print("Ingrese el nombre del bibliotecario: ");
				bibliotecario.setNombre(scanner.nextLine());

				// Solicitar el apellido del bibliotecario
				System.out.print("Ingrese el apellido del bibliotecario: ");
				bibliotecario.setApellido(scanner.nextLine());

				// Solicitar el email del bibliotecario
				System.out.print("Ingrese el email del bibliotecario: ");
				bibliotecario.setEmail(scanner.nextLine());

	            // Bucle para solicitar el legajo del bibliotecario con un valor válido
				while (true) {
					System.out.print("Ingrese el legajo del bibliotecario: ");
					try {
						bibliotecario.setLegajo(scanner.nextInt());
						scanner.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Error: Debe ingresar un número entero para el legajo del libro.");
						scanner.nextLine();
					}
				}
				
				// Agregar el bibliotecario a la colección 
				CollectionUsuario.agregarUsuario(bibliotecario);
				System.out.println("Bibliotecario registrado exitosamente.");
			} catch (Exception e) {
				System.out.println("Ocurrió un error inesperado al registrar el bibliotecario: " + e.getMessage());
			}
			break;
		case "3":	// Opción para salir del registro
			System.out.println("Saliendo del registro...");
			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}
	}

	
	public static void registrarPrestamo(Scanner scanner) {
		Prestamo prestamo = new Prestamo();
		try {
			// Bucle para solicitar el ID del prestamo con un valor válido
			while (true) {
				System.out.print("Ingrese el ID del Prestamo: ");
				try {
					prestamo.setId(scanner.nextInt());
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Error: Debe ingresar un número entero para el ID del Prestamo.");
					scanner.nextLine();
				}
			}

			int id = 0;
			
			// Bucle para solicitar ID del libro con un valor válido
			while (true) {
				System.out.print("Ingrese el ID del libro que desea buscar: ");
				try {
					id = scanner.nextInt();
					scanner.nextLine();
					CollectionLibro.buscarLibro(id);
					prestamo.setLibro(CollectionLibro.buscarLibroDisponible(id));
					break;
				} catch (InputMismatchException e) {
					System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
					scanner.nextLine();
				} catch (Exception e) {
					System.out.println("Error al buscar el libro: " + e.getMessage());
				} finally {
					
					// Si el libro no se encuentra, se pregunta si desea volver a buscar
					if (prestamo.getLibro() == null) {
						if (!mostrarMenuBuscar("el libro", scanner))return;
					} else {
						prestamo.getLibro().mostrarDatos(prestamo.getLibro());
					}
				}
			}

			// Bucle para solicitar ID del usuario con un valor válido
			while (true) {
				System.out.print("Ingrese el ID del usuario que desea buscar: ");
				try {
					prestamo.setUsuario(CollectionUsuario.buscarUsuario(scanner.nextInt()));
					scanner.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Error: Debe ingresar un número entero para el ID del usuario.");
					scanner.nextLine();
				} catch (Exception e) {
					System.out.println("Error al buscar el usuario: " + e.getMessage());
				} finally {
					// Si el usuario no se encuentra, se pregunta si desea volver a buscar
					if (prestamo.getUsuario() == null) {
						if (!mostrarMenuBuscar("el usuario", scanner))return;
					} else {
						prestamo.getUsuario().mostrarDatos();
					}
				}
			}

			// Bucle para solicitar fecha del préstamo con un valor válido
			while (true) {
				System.out.print("Ingrese fecha del prestamo (formato dd/MM/yyyy): ");
				try {
					prestamo.setFechaPrestamo(FechaUtil.convertirStringLocalDate(scanner.nextLine()));
					break;
				} catch (Exception e) {
					System.out.println("Error en el formato de fecha: " + e.getMessage());

				}
			}
			
			// Agregar el prestamo a la colección 
			prestamo.getLibro().setEstado(false);
			CollectionPrestamo.agregarPrestamo(prestamo);
			System.out.println("Préstamo registrado exitosamente.");

		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado al registrar el prestamo: " + e.getMessage());
		}
	}

	
	public static void actualizarDisponibilidadLibro(Scanner scanner) {
	    try {
	        Libro libro = null; 
	        
	        // Bucle para buscar el libro con un ID válido
	        while (true) {
	            System.out.print("Ingrese el ID del libro que desea devolver para actualizar: ");
	            try {
	                libro = CollectionLibro.buscarLibro(scanner.nextInt());
	                scanner.nextLine(); 
	                break;
	            } catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar un número entero para el ID del libro.");
	            } catch (Exception e) {
	                System.out.println("Error al buscar el libro: " + e.getMessage());
	            } finally {
	            	
	                // Si el libro no se encuentra, se pregunta si desea volver a buscar
	                if (libro == null) {
	                    scanner.nextLine();
	                    if (!mostrarMenuBuscar("el libro", scanner)) return; 
	                } else {
	                    libro.mostrarDatos(libro);
	                }
	            }
	        }
	        
	        Prestamo actualizarLibro = null;
	        for (Prestamo prestamo : CollectionPrestamo.prestamos) {
	            if (prestamo.getLibro().getId() == libro.getId()) {
	                actualizarLibro = prestamo; 
	                break; 
	            }
	        }
	        
	        // Verificar si el libro no ha sido prestado
	        if (actualizarLibro == null) {
	            System.out.println("El libro no ha sido prestado.");
	            return; 
	        }

	        String op; 
	
	        while (true) {
	            System.out.print("¿Desea marcar el libro '" + actualizarLibro.getLibro().getTitulo() + "' como disponible? (s/n): ");
	            op = scanner.nextLine(); 
	            switch (op) {
	                case "s":	// Opción para marcar el libro como disponible
	                    try {
	                        System.out.print("Ingrese fecha de devolucion (formato dd/MM/yyyy): ");
	                        actualizarLibro.registrarDevolucion(FechaUtil.convertirStringLocalDate(scanner.nextLine()), actualizarLibro);
	                        actualizarLibro.getLibro().setEstado(true);
	                        CollectionPrestamo.prestamos.remove(actualizarLibro);
	                        System.out.println("El libro ha sido marcado como disponible.");
	                        return;
	                    } catch (Exception e) {
	                        System.out.println("Error en el formato de fecha: " + e.getMessage());
	                    }
	                    break;

	                case "n":	// Opción para no realizar cambios
	                    System.out.println("El libro no ha sufrido cambios.");
	                    return; 

	                default:	// Opción no válida
	                    System.out.println("Respuesta no válida. El estado del libro no ha sido modificado.");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error inesperado al registrar el préstamo: " + e.getMessage());
	    }
	}

	
	public static void mostrarLibros() {
		System.out.println("Lista de libros disponibles:");
		for (Libro libro : CollectionLibro.libros) {
			System.out.println();
			libro.mostrarDatos(libro);
		}
	}

	
	public static boolean mostrarMenuBuscar(String string, Scanner scanner) {
		String op;
		while (true) {
			System.out.println("Seguir buscando " + string);
			System.out.println("1. Buscar");
			System.out.println("2. Salir");
			System.out.print("Seleccione una opción: ");
			op = scanner.nextLine();

			switch (op) {
			case "1":	// Opción para continuar buscando
				System.out.println("Buscar seleccionado.");
				return true;
			case "2":	// Opción para salir del menú
				System.out.println("Saliendo....");
				return false;
			default:	// Opción no válida
				System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
				break;
			}
		}
	}

}
