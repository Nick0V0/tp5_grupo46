package ar.edu.unju.escmi.tp5.dominio;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private String isbn;
	private boolean estado;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(int id, String titulo, String autor, String isbn, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void mostrarDatos(Libro libro) {
		System.out.println("Id:" + libro.id);
		System.out.println("Titulo:" + libro.titulo);
		System.out.println("Autor:" + libro.autor);
		System.out.println("Isbn:" + libro.isbn);
		System.out.println("Estado:" + libro.estado);

	}
}
