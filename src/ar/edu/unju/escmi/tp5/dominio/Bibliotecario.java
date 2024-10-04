package ar.edu.unju.escmi.tp5.dominio;

public class Bibliotecario extends Usuario {
	private int legajo;

	public Bibliotecario() {
		// TODO Auto-generated constructor stub
	}

	public Bibliotecario(int legajo) {
		super();
		this.legajo = legajo;
	}

	@Override
	public void mostrarDatos() {

		System.out.println("Id:" + this.id);
		System.out.println("Nombre:" + this.nombre);
		System.out.println("Apellido:" + this.apellido);
		System.out.println("Email:" + this.email);
		System.out.println("Legajo:" + this.legajo);

	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

}
