package sistemagestioninformaticags;

public class Asignaturasalumnos {
	private int nip;
	private int asignatura;
	
	/**
	 * Pre:-----------
	 * Post: Constructor de Asignaturasalumnos.java
	 */
	Asignaturasalumnos(int nip, int asignatura){
		this.nip = nip;
		this.asignatura = asignatura;
	}
	
	//setters y getters
	public int getNip() {
		return nip;
	}
	
	public void setNip(int nip) {
		this.nip = nip;
	}
	
	public int getAsignatura() {
		return asignatura;
	}
	
	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
	}
	
}
