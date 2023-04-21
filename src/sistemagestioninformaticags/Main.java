package sistemagestioninformaticags;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	/**
	 * Pre:-----------
	 * Post: Metodo que el cual muestra un manual de los diferentes comandos
	 */
	public static void manualUsuario(String o) {
		String[] orden = o.split(" ");
		try {
			if (orden.length == 2) {
				if (orden[1].equalsIgnoreCase("asignaturas")) {
					System.out.println("\n	Comando que muestra las asignaturas del alumno cuyo nip es igual"
							+ "al nip del alumno especificado por el usuario, "
							+ "\n	se puede ordenar en forma creciente al codigo de las asignaturas sin añadir ninguno "
							+ "parametro o añadiendo el parametro 'C' y de "
							+ "\n 	forma alfabetica añadiendo el parametro 'A', según la especificación del usuario "
							+ "mostrara la lista de asignaturas "
							+ "\n	del alumno de la manera que el usuario lo haya especificado. ejemplos de utilización:");
					System.out.println(
							"\n		'Asignaturas 512223 [A]' //muestra a las asignaturas del alumno con nip 512223 "
									+ "ordenados alfabeticamente por el nombre de las asignaturas. "
									+ "\n		'Asignaturas 565453' //muestra a las asignaturas del alumno con nip 565453 por orden "
									+ "creciente del codigo de las asignaturas. "
									+ "\n		'Asignaturas 656722 (C)' //muestra a las asignaturas del alumno con nip 656722 por orden "
									+ "creciente del codigo de las asignaturas. "
									+ "\n		'Asignaturas 565453 <a>' //muestra a las asignaturas del alumno con nip 565453 "
									+ "ordenados alfabeticamente por el nombre de las asignaturas.");
				} else if (orden[1].equalsIgnoreCase("alumnos")) {
					System.out.println("\n	Comando que muestra a los alumnos de la asignatura cuyo codigo es igual"
							+ "al codigo de asignatura especificado por el usuario, "
							+ "\n	se puede ordenar en forma creciente al NIP de los alumnos sin añadir ninguno "
							+ "parametro o añadiendo el parametro 'N' y de "
							+ "\n 	forma alfabetica añadiendo el parametro 'A', según la especificación del usuario "
							+ "mostrara la lista de alumnos de la "
							+ "\n	manera que el usuario lo haya especificado. ejemplos de utilización:");
					System.out.println(
							"\n		'Alumnos 30201 [A]' //muestra a los alumnos de la materia 30201 ordenados"
									+ " alfabeticamente por el nombre. "
									+ "\n		'Alumnos 30216' //muestra a los alumnos de la materia 30216 ordenados por orden"
									+ "creciente del nip de los alumnos. "
									+ "\n		'Alumnos 30204 (N)' //muestra a los alumnos de la materia 30204 ordenados por orden"
									+ "creciente del nip de los alumnos. "
									+ "\n		'Alumnos 30214 <a>' //muestra a los alumnos de la materia 30214 ordenados"
									+ " alfabeticamente por el nombre.");
				} else if (orden[1].equalsIgnoreCase("eliminar")) {
					System.out.println("\n	Comando para eliminar o "
							+ "remover un alumno de una asignatura del grado, se eliminara "
							+ "\n	siempre y cuando el alumno ya este matriculado en "
							+ " la asignatura.");
					System.out.println("\n	Para usar el comando podemos usar la siguiente sintaxis: "
							+ "'Eliminar nip { codigo, codigo, codigo }', se pueden remplazar los  "
							+ "\n	separadores por el anexor que guste o pueden ser omitidos: 'Eliminar nip codigo, codigo, codigo', "
							+ "ejemplos de utilización: ");
					System.out.println(
							"\n		'Eliminar 627867 [30201, 30216, 30204]' //eliminara a 6278767 a las materias en el "
									+ "anexor "
									+ "\n		'Eliminar 565453 (30209)' //eliminara a 565453 a la materia dentro del añexor "
									+
									"\n		'Eliminar 612111 30213, 30216, 30204' //eliminara a 612111 a las materias especificadas despues"
									+ " de su nip"
									+ "\n		'Eliminar 676543 30204' //eliminara a 676543 en la materia despues del nip");
				} else if (orden[1].equalsIgnoreCase("matricular")) {
					System.out.println("\n	Comando para matricular o "
							+ "añadir un alumno a una asignatura del grado, se añadira "
							+ "\n	siempre y cuando no estuviera ya presente"
							+ " o matriculado ese alumno en la asignatura y "
							+ "\n	dicha asignatura e alumnos han de existir "
							+ "(Los alunmos tienen que estar en el alumnos.csv y "
							+ "la asignatura en el fichero.txt)");
					System.out.println("\n	Para usar el comando podemos usar la siguiente sintaxis: "
							+ "'Matricular nip { codigo, codigo, codigo }', se pueden remplazar los "
							+ "\n	separadores por el anexor que guste o pueden ser omitidos: 'Matricular nip codigo, codigo, codigo', "
							+ "ejemplos de utilización: ");
					System.out.println(
							"\n		'matricular 627867 {30201, 30216, 30204}' //añadira a 6278767 a las materias en el "
									+ "anexor "
									+ "\n		'matricular 565453 <30209>' //añade a 565453 a la materia dentro del añexor "
									+
									"\n		'matricular 612111 30213, 30216, 30204' //añadira a 612111 a las materias especificadas despues"
									+ " de su nip"
									+ "\n		'matricular 676543 30204' //añadira a 676543 en la materia despues del nip");
				} else if (orden[1].equalsIgnoreCase("matriculas")) {

				} else if (orden[1].equalsIgnoreCase("manual") || orden[1].equalsIgnoreCase("apoyo")
						|| orden[1].equalsIgnoreCase("ayuda")) {
					System.out.println("\n	Comando para mostrar por pantalla del programa un resumen "
							+ "de como emplear cada comando. Sí, 'manual', 'apoyo' o 'ayuda' "
							+ "\n	va seguido de el nombre de una orden o funcion del sistema " +
							"se mostrara por pantalla información más a fondo y detallada "
							+ "\n	del comando, ejemplo:");
					System.out.println("\n		'Manual Eliminar' //Mostrara información más completa del comando "
							+ "eliminar" +
							"\n		'Manual' //escribe información resumida de todas las ordenes que se pueden interpretar");
				} else if (orden[1].equalsIgnoreCase("fin")) {
					System.out.println("\n	Comando para detener el programa, usalo cuando consideres que has acabo "
							+ "tu trabajo.");
				}
			} else if (orden.length == 1) {
				System.out.println(
						"\n	'matriculas': muestra por pantalla a los alumnos que estan matriculados en el grado");
				System.out.println("\n	'asignaturas': muestra a las asignaturas del alumno con nip igual al"
						+ "\n	  campo nip, se puede ordenar alfebeticamente con el parametro [A] o se "
						+ "\n	  ordenara presentado los valores de los codigos de las asignaturas en forma "
						+ "\n	  crecientes con [C]; sintaxis: 'Asignaturas codigo { A | C }'");
				System.out.println("\n	'alumnos': muestra a los alumnos de la asignatura con codigo igual al"
						+ "\n	  campo codigo, se puede ordenar alfebeticamente con el parametro [A] o se "
						+ "\n	  ordenara presentado los valores NIPs en forma crecientes con [N]; "
						+ "\n	  sintaxis: 'alumnos codigo { A | N }'");
				System.out.println(
						"\n	'eliminar': elimina a el alumno con el nip especificado de la asignatura con codigo "
								+ "\n	 igual al campo codigo; sintaxis: 'Eliminar nip { código, código, código }'");
				System.out.println(
						"\n	'matricular': añade a el alumno con el nip especificado a la asignatura con codigo "
								+ "\n	 igual al campo código; sintaxis: 'Matricular nip { código, código, código }'");
				System.out.println(
						"\n	'Apoyo', 'Manual' o 'Ayuda': Comando que muestra un resumen de cada accion disponible, "
								+ "\n	 escriba 'ayuda manual' si desea conocer más afondo.");
				System.out.println("\n	'Fin': Comando que finaliza el programa.");
			} else {
				System.out.println("\n Error de sintaxis o campos mal especificados "
						+ "consulte la 'ayuda' o el 'manual' para mas información \n");
			}
		} catch (Exception e) {
			System.out.println("\n Error de sintaxis o campos mal especificados "
					+ "consulte la 'ayuda' o el 'manual' para mas información \n");
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que añade al fichero matriculas.dat a los alumnos
	 * con el nip y con la asignatura especificados por el usuario
	 */
	public static void introducirAlumno(String o, ArrayList<Asignaturasalumnos> l, String nombre) {
		o = o.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\<", "").replaceAll("\\>", "");
		ArrayList<Alumno> al = new ArrayList<Alumno>();
		ArrayList<Asignatura> as = new ArrayList<Asignatura>();
		ArrayList<Asignatura> asm = new ArrayList<Asignatura>();
		ArrayList<Integer> cas = new ArrayList<Integer>();
		String[] orden = o.split(" ");
		String cUnidos = "";
		try {
			int nip = Integer.parseInt(orden[1]);
			try {
				File alumnos = new File("C:\\sistema_gestion_informaticaGS\\alumnos.csv");
				File asignaturas = new File("C:\\sistema_gestion_informaticaGS\\asignaturas.txt");
				Scanner f = new Scanner(alumnos);
				Scanner f2 = new Scanner(asignaturas);
				boolean primera = false;
				while (f.hasNextLine()) {
					String parrafo = f.nextLine();
					if (primera == true) {
						String[] linea = parrafo.split(";");
						al.add(new Alumno(Integer.parseInt(linea[0].trim()), linea[1].trim(), linea[2].trim()));
					} else {
						primera = true;
					}
				}
				f.close();
				for (int i = 0; i < l.size(); i++) {
					if (nip == l.get(i).getNip()) {
						cas.add(l.get(i).getAsignatura());
					}
				}
				while (f2.hasNextLine()) {
					String parrafo = f2.nextLine().trim();
					String[] linea = parrafo.split(" ");
					String asNombre = "";
					if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
						for (int i = 4; i < linea.length; i++) {
							asNombre = asNombre + " " + linea[i];
						}
						for (int i = 0; i < cas.size(); i++) {
							if (cas.get(i).equals(Integer.parseInt(linea[0]))) {
								asm.add(new Asignatura(Integer.parseInt(linea[0]), linea[1],
										Integer.parseInt(linea[2]), linea[3], asNombre));
							}
						}
						as.add(new Asignatura(Integer.parseInt(linea[0]), linea[1],
								Integer.parseInt(linea[2]), linea[3], asNombre));
					}
				}
				for (int i = 0; i < asm.size(); i++) {
					for (int j = 0; j < as.size(); j++) {
						if (as.get(j).getCodigo() == asm.get(i).getCodigo()) {
							as.remove(j);
						}
					}
				}
				f2.close();
			} catch (IOException e) {
				System.out.println("Error al escribir en el fichero");
			}
			try {
				int contadorIntro = 0;
				if (orden.length >= 3) {
					if (orden[2].contains(",")) {
						for (int i = 2; i < orden.length; i++) {
							cUnidos = cUnidos + orden[i];
						}
						String[] cStrs = { orden[0], orden[1], cUnidos };
						String[] codigos = cStrs[2].trim().split(",");
						for (int i = 0; i < codigos.length; i++) {
							for (int j = 0; j < al.size(); j++) {
								for (int k = 0; k < as.size(); k++) {
									if (nip == al.get(j).getNip()
											&& as.get(k).getCodigo() == Integer.parseInt(codigos[i])) {
										l.add(new Asignaturasalumnos(nip, as.get(k).getCodigo()));
										contadorIntro++;
									}
								}
							}
						}
						try {
							DataOutputStream f3 = new DataOutputStream(new FileOutputStream(nombre));
							try {
								for (int i = 0; i < l.size(); i++) {
									f3.writeInt(l.get(i).getNip());
									f3.writeInt(l.get(i).getAsignatura());
								}
								f3.flush();
								f3.close();
								if (contadorIntro == 1) {
									System.out.println("\n  El alumno con NIP: " + nip + "," + " ha sido añadido"
											+ "con exito en 1 asignatura \n");
								} else if (contadorIntro > 1) {
									System.out.print("\n  El alumno con NIP: " + nip + "," + " ha sido añadido"
											+ " con exito en " + contadorIntro + " asignaturas ");
								} else {
									System.out.println("\n  El alumno con NIP: " + nip + "," + " no ha sido añadido"
											+ " a ninguna asignatura \n");
								}
							} catch (IOException e) {
								System.out.println("Error al escribir en el fichero");
							}
						} catch (FileNotFoundException e) {
							System.out.println("El fichero " + nombre + " no ha podido ser abierto");
						}
					} else if (!orden[2].contains(",")) {
						for (int i = 0; i < al.size(); i++) {
							for (int j = 0; j < as.size(); j++) {
								if (nip == al.get(i).getNip() && as.get(j).getCodigo() == Integer.parseInt(orden[2])) {
									l.add(new Asignaturasalumnos(nip, as.get(j).getCodigo()));
									contadorIntro++;
								}
							}
						}
						try {
							DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
							try {
								for (int i = 0; i < l.size(); i++) {
									f.writeInt(l.get(i).getNip());
									f.writeInt(l.get(i).getAsignatura());
								}
								f.flush();
								f.close();
								if (contadorIntro == 1) {
									System.out.println("\n  El alumno con NIP: " + nip + "," + " ha sido añadido"
											+ " con exito en 1 asignatura \n");
								} else {
									System.out.println("\n  El alumno con NIP: " + nip + "," + " no ha sido añadido"
											+ " a ninguna asignatura \n");
								}
							} catch (IOException e) {
								System.out.println("Error al escribir en el fichero");
							}
						} catch (FileNotFoundException e) {
							System.out.println("El fichero " + nombre + " no ha podido ser abierto");
						}
					}
				} else {
					System.out.println("\n Error de sintaxis o campos mal especificados "
							+ "consulte la 'ayuda' o el 'manual' para usar correctamente la función 'matricular' \n");
				}
			} catch (Exception e) {
				System.out.println("\n Error de sintaxis o campos mal especificados "
						+ "consulte la 'ayuda' o el 'manual' para usar correctamente la función 'matricular' \n");
			}
		} catch (Exception e) {
			System.out.println("\n Error de sintaxis o campos mal especificados "
					+ "consulte la 'ayuda' o el 'manual' para usar correctamente la función 'matricular' \n");
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que elimina del fichero matriculas.dat a los alumnos
	 * con el nip y con la asignatura especificados por el usuario
	 */
	public static void eliminarAlumno(String o, ArrayList<Asignaturasalumnos> l, String nombre) {
		o = o.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\<", "").replaceAll("\\>", "");
		String[] orden = o.split(" ");
		String cUnidos = "";
		try {
			int nip = Integer.parseInt(orden[1]);
			if (orden.length >= 3) {
				if (orden[2].contains(",")) {
					for (int i = 2; i < orden.length; i++) {
						cUnidos = cUnidos + orden[i];
					}
					String[] cStrs = { orden[0], orden[1], cUnidos };
					String[] codigos = cStrs[2].trim().split(",");
					for (int i = 0; i < codigos.length; i++) {
						for (int j = 0; j < l.size(); j++) {
							if (nip == l.get(j).getNip() && Integer.parseInt(codigos[i]) == l.get(j).getAsignatura()) {
								l.remove(j);
							}
						}
					}
					try {
						DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
						try {
							for (int i = 0; i < l.size(); i++) {
								f.writeInt(l.get(i).getNip());
								f.writeInt(l.get(i).getAsignatura());
							}
							f.flush();
							f.close();
							System.out.print("\n  El alumno con NIP: " + nip + "," + " ha sido removido "
									+ "con exito de las asignaturas:");
							for (int i = 0; i < codigos.length; i++) {
								if (i < codigos.length - 2) {
									System.out.print(" " + codigos[i] + ",");
								} else if (i == codigos.length - 2) {
									System.out.print(" " + codigos[i]);
								} else if (i == codigos.length - 1) {
									System.out.print(" y " + codigos[i] + "\n");
								}
							}
							System.out.print("\n");
						} catch (IOException e) {
							System.out.println("Error al escribir en el fichero");
						}
					} catch (FileNotFoundException e) {
						System.out.println("El fichero " + nombre + " no ha podido ser abierto");
					}
				} else if (!orden[2].contains(",")) {
					for (int i = 0; i < l.size(); i++) {
						if (nip == l.get(i).getNip() && Integer.parseInt(orden[2]) == l.get(i).getAsignatura()) {
							l.remove(i);
						}
					}
					try {
						DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
						try {
							for (int i = 0; i < l.size(); i++) {
								f.writeInt(l.get(i).getNip());
								f.writeInt(l.get(i).getAsignatura());
							}
							f.flush();
							f.close();
							System.out.println("\n  El alumno con NIP: " + nip + "," + " ha sido removido "
									+ "con exito de la asignatura: " + orden[2] + "\n");
						} catch (IOException e) {
							System.out.println("Error al escribir en el fichero");
						}
					} catch (FileNotFoundException e) {
						System.out.println("El fichero " + nombre + " no ha podido ser abierto");
					}
				}
			} else if (orden.length == 2) {
				try {
					DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
					try {
						for (int i = 0; i < l.size(); i++) {
							if (nip != l.get(i).getNip()) {
								f.writeInt(l.get(i).getNip());
								f.writeInt(l.get(i).getAsignatura());
							}
						}
						f.flush();
						f.close();
						System.out.println("\n  El alumno con NIP: " + nip + "," + " ha sido removido "
								+ "con exito de todas las asignaturas\n");
					} catch (IOException e) {
						System.out.println("Error al escribir en el fichero");
					}
				} catch (FileNotFoundException e) {
					System.out.println("El fichero " + nombre + " no ha podido ser abierto");
				}
			}
		} catch (Exception e) {
			System.out.println("\n Error de sintaxis o campos mal especificados "
					+ "consulte la 'ayuda' o el 'manual' para usar correctamente la función 'eliminar' \n");
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que muestra por pantalla a las asignaturas en las que el alumno
	 * especificado
	 * por el usuario este matriculado y los ordena por el interprete de la ultima
	 * entrada del usuario
	 */
	public static void alumnosAsignaturas(String o, ArrayList<Asignaturasalumnos> l) {
		o = o.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\<", "").replaceAll("\\>", "");
		ArrayList<Alumno> la = new ArrayList<Alumno>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Alumno almacen = new Alumno(0, "", "");
		File file = new File("C:\\sistema_gestion_informaticaGS\\alumnos.csv");
		String[] orden = o.split(" ");
		try {
			int codigo = Integer.parseInt(orden[1]);
			if (orden.length == 3) {
				if (orden[2].equalsIgnoreCase("n")) {
					for (int i = 0; i < l.size(); i++) {
						if (codigo == l.get(i).getAsignatura()) {
							a.add(l.get(i).getNip());
						}
					}
					System.out.println("\nAsignatura:" + codigo);
					System.out.println("\n    Alumnos de la asignatura:");
					System.out.println("\n    NIP:" + "		NOMBRE:" + "			APELLIDOS:" +
							"\n   ===============================================================");
					try {
						Scanner f = new Scanner(file);
						boolean primera = false;
						while (f.hasNextLine()) {
							String parrafo = f.nextLine().trim();
							if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
								if (primera == true) {
									String[] linea = parrafo.split(";");
									for (int i = 0; i < a.size(); i++) {
										if (a.get(i).equals(Integer.parseInt(linea[0]))) {
											la.add(new Alumno(Integer.parseInt(linea[0]), linea[1], linea[2]));
										}
									}
								} else {
									primera = true;
								}
							}
						}
						for (int i = 0; i < la.size(); i++) {
							for (int j = i + 1; j < la.size(); j++) {
								if (la.get(i).getNip() > la.get(j).getNip()) {
									almacen.ordenarNip(la.get(j).getNip(), la.get(j).getApellido(),
											la.get(j).getNombre());
									la.get(j).ordenarNip(la.get(i).getNip(), la.get(i).getApellido(),
											la.get(i).getNombre());
									la.get(i).ordenarNip(almacen.getNip(), almacen.getApellido(), almacen.getNombre());
								}
							}
						}
						for (int i = 0; i < la.size(); i++) {
							if (la.get(i).getNombre().length() > 8) {
								if (la.get(i).getApellido().length() > 13) {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
								} else {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
								}
							} else {
								if (la.get(i).getApellido().length() < 13) {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
								} else {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
								}
							}
						}
						f.close();
					} catch (FileNotFoundException e) {
						System.out.println("\n No se ha encontrado el fichero alumnos.csv");
					}
				} else if (orden[2].equalsIgnoreCase("a")) {
					for (int i = 0; i < l.size(); i++) {
						if (codigo == l.get(i).getAsignatura()) {
							a.add(l.get(i).getNip());
						}
					}
					System.out.println("\nAsignatura:" + codigo);
					System.out.println("\n    Alumnos de la asignatura:");
					System.out.println("\n    NIP:" + "		NOMBRE:" + "			APELLIDOS:" +
							"\n   ===============================================================");
					try {
						Scanner f = new Scanner(file);
						boolean primera = false;
						while (f.hasNextLine()) {
							String parrafo = f.nextLine().trim();
							String[] linea = parrafo.split(";");
							if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
								if (primera == true) {
									for (int i = 0; i < a.size(); i++) {
										if (a.get(i).equals(Integer.parseInt(linea[0]))) {
											la.add(new Alumno(Integer.parseInt(linea[0]), linea[1], linea[2]));
										}
									}
								} else {
									primera = true;
								}
							}
						}
						Collections.sort(la);
						for (int i = 0; i < la.size(); i++) {
							if (la.get(i).getNombre().length() > 8) {
								if (la.get(i).getApellido().length() > 13) {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
								} else {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
								}
							} else {
								if (la.get(i).getApellido().length() < 13) {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
								} else {
									System.out.println("   " + la.get(i).getNip() + "		"
											+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
								}
							}
						}
						f.close();
					} catch (FileNotFoundException e) {
						System.out.println("\n No se ha encontrado el fichero alumnos.csv");
					}
				}
			} else if (orden.length == 2) {
				for (int i = 0; i < l.size(); i++) {
					if (codigo == l.get(i).getAsignatura()) {
						a.add(l.get(i).getNip());
					}
				}
				System.out.println("\nAsignatura:" + codigo);
				System.out.println("\n    Alumnos de la asignatura:");
				System.out.println("\n    NIP:" + "		NOMBRE:" + "			APELLIDOS:" +
						"\n   ===============================================================");
				try {
					Scanner f = new Scanner(file);
					boolean primera = false;
					while (f.hasNextLine()) {
						String parrafo = f.nextLine().trim();
						if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
							if (primera == true) {
								String[] linea = parrafo.split(";");
								for (int i = 0; i < a.size(); i++) {
									if (a.get(i).equals(Integer.parseInt(linea[0]))) {
										la.add(new Alumno(Integer.parseInt(linea[0]), linea[1], linea[2]));
									}
								}
							} else {
								primera = true;
							}
						}
					}
					for (int i = 0; i < la.size(); i++) {
						for (int j = i + 1; j < la.size(); j++) {
							if (la.get(i).getNip() > la.get(j).getNip()) {
								almacen.ordenarNip(la.get(j).getNip(), la.get(j).getApellido(), la.get(j).getNombre());
								la.get(j).ordenarNip(la.get(i).getNip(), la.get(i).getApellido(),
										la.get(i).getNombre());
								la.get(i).ordenarNip(almacen.getNip(), almacen.getApellido(), almacen.getNombre());
							}
						}
					}
					for (int i = 0; i < la.size(); i++) {
						if (la.get(i).getNombre().length() > 8) {
							if (la.get(i).getApellido().length() > 13) {
								System.out.println("   " + la.get(i).getNip() + "		"
										+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
							} else {
								System.out.println("   " + la.get(i).getNip() + "		"
										+ la.get(i).getNombre() + "		" + la.get(i).getApellido());
							}
						} else {
							if (la.get(i).getApellido().length() < 13) {
								System.out.println("   " + la.get(i).getNip() + "		"
										+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
							} else {
								System.out.println("   " + la.get(i).getNip() + "		"
										+ la.get(i).getNombre() + "			" + la.get(i).getApellido());
							}
						}
					}
					f.close();
				} catch (FileNotFoundException e) {
					System.out.println("\n No se ha encontrado el fichero alumnos.csv");
				}
			}
		} catch (Exception e) {
			System.out.println("\n Error de sintaxis consulte la 'ayuda' o el 'manual' "
					+ "para usar correctamente la función 'asignaturas'");
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que muestra por pantalla a los alumnos matriculados en la
	 * asignatura que
	 * haya especificado el usuario y los ordena por el interprete la ultima entra
	 * del usuario
	 */
	public static void asignaturasAlumnos(String o, ArrayList<Asignaturasalumnos> l) {
		o = o.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\<", "").replaceAll("\\>", "");
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Asignatura> la = new ArrayList<Asignatura>();
		File file = new File("C:\\sistema_gestion_informaticaGS\\asignaturas.txt");
		String[] orden = o.split(" ");
		try {
			int nip = Integer.parseInt(orden[1]);
			if (orden.length == 3) {
				if (orden[2].equalsIgnoreCase("c")) {
					for (int i = 0; i < l.size(); i++) {
						if (nip == l.get(i).getNip()) {
							a.add(l.get(i).getAsignatura());
						}
					}
					Collections.sort(a);
					System.out.println("\nAlumno:" + nip);
					System.out.println(
							"\n    Asignaturas:" + "\n   ====================================================");
					try {
						Scanner f = new Scanner(file);
						while (f.hasNextLine()) {
							String parrafo = f.nextLine().trim();
							if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
								String[] linea = parrafo.split(" ");
								for (int i = 0; i < a.size(); i++) {
									if (a.get(i).equals(Integer.parseInt(linea[0]))) {
										System.out.println("   " + parrafo);
									}
								}
							}
						}
						f.close();
					} catch (FileNotFoundException e) {
						System.out.println("\n No se ha encontrado el fichero asignaturas.txt");
					}
				} else if (orden[2].equalsIgnoreCase("a")) {
					for (int i = 0; i < l.size(); i++) {
						if (nip == l.get(i).getNip()) {
							a.add(l.get(i).getAsignatura());
						}
					}
					System.out.println("\nAlumno:" + nip);
					System.out.println(
							"\n    Asignaturas:" + "\n   ====================================================");
					try {
						Scanner f = new Scanner(file);
						while (f.hasNextLine()) {
							String parrafo = f.nextLine().trim();
							String[] linea = parrafo.split(" ");
							String nombre = "";
							if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
								for (int i = 4; i < linea.length; i++) {
									nombre = nombre + " " + linea[i];
								}
								for (int i = 0; i < a.size(); i++) {
									if (a.get(i).equals(Integer.parseInt(linea[0]))) {
										la.add(new Asignatura(Integer.parseInt(linea[0]), linea[1],
												Integer.parseInt(linea[2]), linea[3], nombre));
									}
								}
							}
						}
						Collections.sort(la);
						for (int i = 0; i < la.size(); i++) {
							System.out.println("   " + la.get(i).getCodigo() + " " + la.get(i).getCreditos() + " "
									+ la.get(i).getCuatrimestre() + " " + la.get(i).getModalidad() + " " +
									la.get(i).getNombre());
						}
						f.close();
					} catch (FileNotFoundException e) {
						System.out.println("\n No se ha encontrado el fichero asignaturas.txt");
					}
				} else {
					System.out.println("\n ¡Vaya!, parece que '" + orden[2] +
							"' no es una funcion valida...\n "
							+ "Para conocer mas a fondo la función 'asignaturas'\n "
							+ "Consulte el manual escribiendo 'ayuda', 'apoyo' o 'manual'");
				}
			} else if (orden.length == 2) {
				for (int i = 0; i < l.size(); i++) {
					if (nip == l.get(i).getNip()) {
						a.add(l.get(i).getAsignatura());
					}
				}
				Collections.sort(a);
				System.out.println("\nAlumno:" + nip);
				System.out.println("\n    Asignaturas:" + "\n   ====================================================");
				try {
					Scanner f = new Scanner(file);
					while (f.hasNextLine()) {
						String parrafo = f.nextLine().trim();
						if (!parrafo.isEmpty()) { // if (parrafo.length() != 0) {
							String[] linea = parrafo.split(" ");
							for (int i = 0; i < a.size(); i++) {
								if (a.get(i).equals(Integer.parseInt(linea[0]))) {
									System.out.println("   " + parrafo);
								}
							}
						}
					}
					f.close();
				} catch (FileNotFoundException e) {
					System.out.println("\n No se ha encontrado el fichero asignaturas.txt");
				}
			}
		} catch (Exception e) {
			System.out.println("\n Error de sintaxis consulte la 'ayuda' o el 'manual' para "
					+ "usar correctamente la función 'asignaturas'");
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que muestra por pantalla a los alumnos matriculados y sus datos,
	 * ademas de mostrar el numero de asignaturas en las que esta matriculado cada
	 * alumno
	 */
	public static void contarMatriculados(String binario, ArrayList<Asignaturasalumnos> l) {
		ArrayList<Matriculado> m = new ArrayList<Matriculado>();
		ArrayList<Alumno> a = new ArrayList<Alumno>();
		boolean anadido = false;
		int asigContador = 0;
		try {
			DataInputStream f = new DataInputStream(new FileInputStream(binario));
			try {
				File alumnos = new File("C:\\sistema_gestion_informaticaGS\\alumnos.csv");
				Scanner f2 = new Scanner(alumnos);
				boolean primera = false;
				while (f2.hasNextLine()) {
					String parrafo = f2.nextLine();
					if (primera == true) {
						String[] linea = parrafo.split(";");
						a.add(new Alumno(Integer.parseInt(linea[0].trim()), linea[1].trim(), linea[2].trim()));
					} else {
						primera = true;
					}
				}
				f2.close();
				while (true) {
					int nip = f.readInt();
					@SuppressWarnings("unused")
					int asignatura = f.readInt(); // valor no usado
					asigContador = 0;
					for (int i = 0; i < l.size(); i++) {
						if (nip == l.get(i).getNip()) {
							asigContador++;
						}
					}
					for (int i = 0; i < m.size(); i++) {
						if (nip == m.get(i).getNip()) {
							anadido = true;
						}
					}
					if (anadido == false) {
						for (int i = 0; i < a.size(); i++) {
							if (a.get(i).getNip() == nip) {
								m.add(new Matriculado(nip, a.get(i).getNombre(), a.get(i).getApellido(), asigContador));
							}
						}
					} else {
						anadido = false;
					}
				}
			} catch (EOFException e) {
			}
			System.out.println("\n  " + " NIP " + "              " + "NOMBRE" + "              " + "APELLIDOS"
					+ "              " + "ASIGNATURAS");
			System.out.println(" " + "=======" + "        " + "================" + "        " + "===============" +
					"        " + "=============");
			for (int i = 0; i < m.size(); i++) {
				if (m.get(i).getNombre().length() > 8) {
					if (m.get(i).getApellidos().length() > 13) {
						System.out.println(" " + m.get(i).getNip() + "		" + m.get(i).getNombre() + "		"
								+ m.get(i).getApellidos() + "	" + m.get(i).getAsignaturas());
					} else {
						System.out.println(" " + m.get(i).getNip() + "		" + m.get(i).getNombre() + "		"
								+ m.get(i).getApellidos() + "		" + m.get(i).getAsignaturas());
					}
				} else {
					if (m.get(i).getApellidos().length() < 13) {
						System.out.println(" " + m.get(i).getNip() + "		" + m.get(i).getNombre() + "			"
								+ m.get(i).getApellidos() + "		" + m.get(i).getAsignaturas());
					} else {
						System.out.println(" " + m.get(i).getNip() + "		" + m.get(i).getNombre() + "			"
								+ m.get(i).getApellidos() + "		" + m.get(i).getAsignaturas());
					}
				}
				if (i == m.size() - 1) {
					System.out.println("\n Total alumnos matriculados: " + (i + 1));
				}
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + binario + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + binario);
		}
	}

	/**
	 * Pre:-----------
	 * Post: Metodo que lee constantemente el fichero matriculas.dat y mediante el
	 * se consigue la lista matriculas con alumnos y sus materias
	 */
	public static ArrayList<Asignaturasalumnos> leerBinario(String nombre) {
		ArrayList<Asignaturasalumnos> l = new ArrayList<Asignaturasalumnos>();
		try {
			DataInputStream f = new DataInputStream(new FileInputStream(nombre));
			try {
				while (true) {
					int nip = f.readInt();
					int asignatura = f.readInt();
					l.add(new Asignaturasalumnos(nip, asignatura));
				}
			} catch (EOFException e) {
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
		return l;
	}

	/**
	 * Pre:-----------
	 * Post: Metodo Main donde el usuario envia una orden y esta es interpretada y
	 * esta es interpretada y enviada a su metodo adecuado para tratar la
	 * informacion
	 * y ejecutar el comando que el usuario desea
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		new File("C:\\sistema_gestion_informaticaGS").mkdirs(); // creo la carpeta
		System.out.println("Si es su primera vez usando el programa...");
		System.out.println(
				"Por favor, Introduzca los ficheros primero en la carpeta (C:\\\\sistema_gestion_informaticaGS)"
						+ " antes de su utilización.");
		System.out
				.println("Cualquier duda o problema que le surja, consular escribiendo uno de los siguientes comandos: "
						+ "'manual', 'apoyo' o 'ayuda'.");
		String binario = "C:\\sistema_gestion_informaticaGS\\matriculas.dat";
		while (true) {
			ArrayList<Asignaturasalumnos> l = leerBinario(binario);
			System.out.print("\norden> ");
			String orden = s.nextLine().trim();
			if (orden.toLowerCase().contains("ayuda")
					|| orden.toLowerCase().contains("apoyo")
					|| orden.toLowerCase().contains("manual")) {
				manualUsuario(orden);
			} else if (orden.toLowerCase().contains("matriculas")) {
				contarMatriculados(binario, l);
			} else if (orden.toLowerCase().contains("alumnos")) {
				alumnosAsignaturas(orden, l);
			} else if (orden.toLowerCase().contains("asignaturas")) {
				asignaturasAlumnos(orden, l);
			} else if (orden.toLowerCase().contains("eliminar")) {
				eliminarAlumno(orden, l, binario);
			} else if (orden.toLowerCase().contains("matricular")) {
				introducirAlumno(orden, l, binario);
			} else if (orden.equalsIgnoreCase("fin")) {
				s.close();
				break;
			} else {
				System.out.println(" Error de sintaxis, campos mal especificados/ilegibles"
						+ " o comando introduccido de forma incorrecta. \n "
						+ "Si necesita detalles para usar un comando escriba 'ayuda', 'apoyo' o 'manual'.");
			}
		}
	}
}
