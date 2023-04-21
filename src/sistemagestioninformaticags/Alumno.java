package sistemagestioninformaticags;

public class Alumno implements Comparable <Alumno> {
	private int nip;
	private String apellido;
	private String nombre;
	
	/**
	 * Pre:-----------
	 * Post: Constructor de Alumno.java
	 */
	public Alumno(int nip, String apellido, String nombre) {
		this.nip = nip;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo para ordenar alumnos por el nip de forma creciente
	 */
	public void ordenarNip(int nip, String apellido, String nombre) {
		this.nip = nip;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	//getters y setters
	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	/**
	 * Pre:-----------
	 * Post: Metodo compareTo para ordenar alumnos de forma alfabetica
	 */
	@Override
	public int compareTo(Alumno o) {
		int comparar = this.nombre.compareToIgnoreCase(o.getNombre());
	     if (comparar > 0) {
	         return 1;
	     }
	     else if (comparar < 0) {
	         return -1;
	     } else {
	    	 return 0;
	     }
	}

	@Override
	public String toString() {
		return "Alumno [nip=" + nip + ", apellido=" + apellido + ", nombre=" + nombre + "]";
	}
	
}