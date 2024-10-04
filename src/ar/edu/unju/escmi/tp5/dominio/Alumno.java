package ar.edu.unju.escmi.tp5.dominio;

public class Alumno extends Usuario{
	private String curso;
	private int numeroLibreta;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(String curso, int numeroLibreta) {
		super();
		this.curso = curso;
		this.numeroLibreta = numeroLibreta;
	}
	
	@Override
	public void mostrarDatos() {
		// TODO Auto-generated method stub
		System.out.println("Id:"+this.id);
		System.out.println("Nombre"+this.nombre);
		System.out.println("Apellido:"+this.apellido);
		System.out.println("Email:"+this.email);
		System.out.println("Curso:"+this.curso);
		System.out.println("NumLibreta:"+this.numeroLibreta);
		
	}
	
	

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getNumeroLibreta() {
		return numeroLibreta;
	}

	public void setNumeroLibreta(int numeroLibreta) {
		this.numeroLibreta = numeroLibreta;
	}
	
	
	
}
