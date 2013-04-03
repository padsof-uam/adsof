/**
 * 
 */
package menuPert.proyector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Clase que contiene toda la informaci??n de un proyecto PERT.
 * 
 * @author V??ctor de Juan Sanz
 * @author Guillermo Juli??n Moreno
 * 
 */
public class Proyecto {
	private String file;
	private double peso_op, peso_pes, peso_prob;
	private HashMap<String, Tarea> tabla_tareas = new HashMap<String, Tarea>();

	/**
	 * 
	 * @return El peso optimista
	 */
	public double getPeso_op() {
		return peso_op;
	}

	/**
	 * 
	 * @param peso_op
	 *            el peso optimista para establecer.
	 */
	public void setPeso_op(double peso_op) {
		this.peso_op = peso_op;
	}

	/**
	 * 
	 * @return el peso pesimista .
	 */
	public double getPeso_pes() {
		return peso_pes;
	}

	/**
	 * 
	 * @param peso_pesimista
	 *            para set establecido.
	 */
	public void setPeso_pes(double peso_pes) {
		this.peso_pes = peso_pes;
	}

	/**
	 * 
	 * @return el peso probable.
	 */
	public double getPeso_prob() {
		return peso_prob;
	}

	/**
	 * 
	 * @param peso_prob
	 *            para ser establecido.
	 */
	public void setPeso_prob(double peso_prob) {
		this.peso_prob = peso_prob;
	}

	/**
	 * Constructor
	 * 
	 * @param file
	 *            Archivo con los datos de proyecto.
	 */
	public Proyecto(String file) {
		this.file = file;
	}

	/**
	 * Lee el archivo y carga todos los datos necesarios en memoria.
	 * 
	 * @throws IOException
	 *             Error de lectura del fichero
	 * @throws Exception
	 *             Error de interpretaci??n del fichero.
	 */
	public void readFile() throws IOException, Exception {
		BufferedReader buffer = null;

		tabla_tareas.put("Inicio", new TareaInicio());
		tabla_tareas.put("Fin", new TareaFinal());

		try {
			buffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			processFile(buffer);

		} finally {
			if (buffer != null)
				buffer.close();
		}
	}

	/**
	 * Procesa el archivo.
	 * 
	 * @param buffer
	 *            Buffer de lectura ya creado.
	 * @throws Exception
	 *             Error de interpretaci??n del archivo.
	 */
	private void processFile(BufferedReader buffer) throws Exception {
		String buff = new String();
		char first;
		while ((buff = buffer.readLine()) != null) {
			if (buff.isEmpty())
				continue;

			first = buff.charAt(0);
			switch (first) {
			case 'P':
				procesaPesos(buff);
				break;
			case 'T':
				procesaTarea(buff);
				break;
			case 'C':
				procesaConexion(buff);
				break;
			case '#':
			default:
				break;
			}
		}
	}

	/**
	 * Procesa una l??nea que contiene una conexi??n.
	 * 
	 * @param buff
	 *            L??nea.
	 */
	private void procesaConexion(String buff) {
		StringTokenizer tokens = new StringTokenizer(buff);
		tokens.nextToken();
		String tarea = tokens.nextToken();
		Tarea inicial = tabla_tareas.get(tarea);

		while (tokens.hasMoreTokens()) {
			String siguienteNombre = tokens.nextToken();
			Tarea siguienteTarea = tabla_tareas.get(siguienteNombre);

			if (siguienteTarea != null) {
				inicial.anadirTareaConsecuente(siguienteTarea);
				siguienteTarea.anadirTareaAntecedente(inicial);
			}
		}

	}

	/**
	 * Procesa una l??nea que contiene una tarea.
	 * 
	 * @param buff
	 *            L??nea.
	 * @throws Exception
	 *             Error de interpretaci??n del fichero.
	 */
	private void procesaTarea(String buff) throws Exception {
		StringTokenizer tokenizer = new StringTokenizer(buff);

		if (tokenizer.countTokens() != 5)
			throw new Exception("Linea inv??lida" + buff);

		tokenizer.nextToken();

		String name = tokenizer.nextToken();

		if (name == "Inicio" || name == "Fin")
			throw new Exception(
					"No se pueden redefinir las tareas inicial o final.");

		int dO = Integer.parseInt(tokenizer.nextToken());
		int dM = Integer.parseInt(tokenizer.nextToken());
		int dP = Integer.parseInt(tokenizer.nextToken());

		Tarea task = new Tarea(dO, dP, dM, name, peso_op, peso_pes, peso_prob);
		tabla_tareas.put(name, task);
	}

	/**
	 * Procesa una l??nea que contiene los pesos.
	 * 
	 * @param buff
	 *            L??nea.
	 */
	private void procesaPesos(String buff) {
		StringTokenizer tokens = new StringTokenizer(buff);

		// Descartamos la 'P'
		tokens.nextToken();

		peso_op = Double.parseDouble(tokens.nextToken());
		peso_prob = Double.parseDouble(tokens.nextToken());
		peso_pes = Double.parseDouble(tokens.nextToken());
	}

	/**
	 * Imprime una tarea cr??tica por pantalla.
	 * 
	 * @param t
	 *            Tarea
	 */
	private void printTareaCritica(Tarea t) {
		String additionalTab = t.getNombre().length() >= 8 ? "" : "\t";
		String line = String.format("%s%s\t%d\t%d\n", t.getNombre(),
				additionalTab, t.getComienzoOptimista(),
				t.getDuracionEstimada());
		System.out.print(line);
	}

	/**
	 * Imprime una tarea por pantalla
	 * 
	 * @param t
	 *            Tarea.
	 */
	private void printTarea(Tarea t) {
		String additionalTab = t.getNombre().length() >= 8 ? "" : "\t";
		String line = String.format("%s\t%s%d\t%d\t%d\t%d\t%d\t%d\n",
				t.getNombre(), additionalTab, t.getDuracionEstimada(),
				t.getComienzoOptimista(), t.getComienzoPesimista(),
				t.getFinOptimista(), t.getFinPesimista(), t.getHolgura());
		System.out.print(line);
	}

	/**
	 * Imprime la tabla de tareas por pantalla.
	 */
	public void printTareas() {
		Queue<Tarea> queue = new LinkedList<Tarea>();
		List<Tarea> printed = new ArrayList<Tarea>();
		Tarea task;

		System.out.println("Tabla resumen");
		System.out.println("-------------");
		System.out.println("Tarea\t\tDurac.\tcO\tcP\tfO\tfP\tHolgura");

		queue.add(tabla_tareas.get("Inicio"));

		do {
			task = queue.poll();

			if (printed.contains(task))
				continue;

			printTarea(task);
			printed.add(task);

			for (Tarea t : task.getConsecuentes()) {
				queue.addAll(t.getConsecuentes());
				printTarea(t);
				printed.add(t);
			}
		} while (!queue.isEmpty());
	}

	/**
	 * Imprime por pantalla la duraci??n estimada del proyecto.
	 */
	public void printDuracionEstimada() {
		Tarea fin = tabla_tareas.get("Fin");
		System.out.println();
		System.out.println("---------------");
		System.out.println("Duraci??n estimada del proyecto : "
				+ fin.getFinOptimista());
		System.out.println("--------------");
	}

	/**
	 * Imprime la tabla de camino cr??tico del proyecto.
	 */
	public void printTablaCritica() {
		Queue<Tarea> queue = new LinkedList<Tarea>();
		List<Tarea> checked = new ArrayList<Tarea>();
		Tarea task;

		System.out.print("\nTabla cr??tica ordenada\n----------------------\n");
		System.out.println("Tarea\t\tc0\tDuracion");

		queue.add(tabla_tareas.get("Inicio"));

		do {
			task = queue.poll();

			if (checked.contains(task))
				continue;

			if (task.getHolgura() == 0)
				printTareaCritica(task);
			checked.add(task);

			for (Tarea t : task.getConsecuentes()) {
				queue.addAll(t.getConsecuentes());
				if (t.getHolgura() == 0 && !checked.contains(t))
					printTareaCritica(t);
				checked.add(t);
			}
		} while (!queue.isEmpty());
	}

	/**
	 * 
	 * @param t
	 *            : Tarea para ser añadida al proyecto
	 */
	public void addTarea(Tarea t) {
		tabla_tareas.put(t.getNombre(), t);
	}

	/**
	 * 
	 * @param nombre
	 *            de la tarea.
	 * @return la tarea con el nombre pasado como argumentos.
	 */
	public Tarea getTarea(String name) {
		return tabla_tareas.get(name);
	}

	/**
	 * 
	 * @param aux
	 *            , la tarea para ser eliminada.
	 */
	public void eliminarTarea(Tarea aux) {
		this.tabla_tareas.remove(aux.getNombre());
	}

	public void calcularAux(Tarea t) {
		t.getComienzoOptimista();
		t.getFinOptimista();
		t.calculaComienzoPesimista();
		t.calculaFinPesimista();
		t.getDuracionEstimada();
		t.getHolgura();
	}

	/**
	 * Calcula los tiempos pesimistas,optimistas y probables de las tareas del
	 * proyecto
	 */
	public void calcularTiempos() {

		Queue<Tarea> queue = new LinkedList<Tarea>();
		List<Tarea> checked = new ArrayList<Tarea>();
		Tarea task;
		queue.add(tabla_tareas.get("Inicio"));
		do {
			task = queue.poll();

			if (checked.contains(task))
				continue;

			if (task.getHolgura() == 0)
				calcularAux(task);
			checked.add(task);

			for (Tarea t : task.getConsecuentes()) {
				queue.addAll(t.getConsecuentes());
				if (t.getHolgura() == 0 && !checked.contains(t)) {
					calcularAux(t);
				}
				checked.add(t);
			}
		} while (!queue.isEmpty());

	}

	public void setFile(String file) {
		this.file = file;
	}
}
