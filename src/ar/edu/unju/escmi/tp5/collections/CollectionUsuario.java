package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Alumno;
import ar.edu.unju.escmi.tp5.dominio.Bibliotecario;
import ar.edu.unju.escmi.tp5.dominio.Usuario;
import ar.edu.unju.escmi.tp5.exceptions.UsuarioNoRegistradoException;


public class CollectionUsuario {
	static public List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static Usuario buscarUsuario(int id) throws UsuarioNoRegistradoException{
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				return usuario;
			}
		}
		throw new UsuarioNoRegistradoException("El usuario con codigo " + id + " no fue encontrado");
	}
	
    public static void precargarUsuarios() {
        Alumno alumno1 = new Alumno();
        alumno1.setId(1);
        alumno1.setNombre("Juan");
        alumno1.setApellido("Pérez");
        alumno1.setEmail("juan.perez@example.com");
        alumno1.setCurso("Matemáticas");
        alumno1.setNumeroLibreta(12345);
        
        Bibliotecario bibliotecario1 = new Bibliotecario();
        bibliotecario1.setId(2);
        bibliotecario1.setNombre("María");
        bibliotecario1.setApellido("Gómez");
        bibliotecario1.setEmail("maria.gomez@example.com");
        bibliotecario1.setLegajo(54321);

        CollectionUsuario.agregarUsuario(alumno1);
        CollectionUsuario.agregarUsuario(bibliotecario1);

    }
}

