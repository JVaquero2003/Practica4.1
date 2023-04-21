package sistemagestioninformaticags;

public class Matriculado {
	private int  nip;
	private String nombre;
	private String apellidos;
	private int asignaturas;
	
	/**
	 * Pre:-----------
	 * Post: Constructor de Matriculado.java
	 */
	Matriculado (int nip, String nombre, String apellidos, int asignaturas) {
		this.nip = nip;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.asignaturas = asignaturas;
	}

	//getters y setters
	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}
