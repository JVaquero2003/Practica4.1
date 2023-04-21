package sistemagestioninformaticags;

public class Asignatura implements Comparable<Asignatura> {
	private int codigo;
	private String creditos;
	private int cuatrimestre;
	private String modalidad;
	private String nombre;

	/**
	 * Pre:-----------
	 * Post: Constructor de Asignatura.java
	 */
	public Asignatura(int codigo, String creditos, int cuatrimestre, String modalidad, String nombre) {
		this.codigo = codigo;
		this.creditos = creditos;
		this.cuatrimestre = cuatrimestre;
		this.modalidad = modalidad;
		this.nombre = nombre;
	}

	// getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Pre:-----------
	 * Post: Metodo compareTo para ordenar las asignaturas de forma alfabetica
	 */
	@Override
	public int compareTo(Asignatura o) {
		int comparar = this.nombre.compareToIgnoreCase(o.getNombre());
		if (comparar > 0) {
			return 1;
		} else if (comparar < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
