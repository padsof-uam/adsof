/**
 * 
 */
package proyector;

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
 * Clase que contiene toda la información de un proyecto PERT.
 * 
 * @author Víctor de Juan Sanz
 * @author Guillermo Julián Moreno
 * 
 */
public class Proyecto
{
	private String					file;
	private double					peso_op, peso_pes, peso_prob;
	private HashMap<String, Tarea>	tabla_tareas	= new HashMap<String, Tarea>();

	/**
	 * Constructor
	 * 
	 * @param file
	 *            Archivo con los datos de proyecto.
	 */
	public Proyecto(String file)
	{
		this.file = file;
	}

	/**
	 * Lee el archivo y carga todos los datos necesarios en memoria.
	 * 
	 * @throws IOException
	 *             Error de lectura del fichero
	 * @throws Exception
	 *             Error de interpretación del fichero.
	 */
	public void readFile() throws IOException, Exception
	{
		BufferedReader buffer = null;

		tabla_tareas.put("Inicio", new TareaInicio());
		tabla_tareas.put("Fin", new TareaFinal());

		try
		{
			buffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			processFile(buffer);

		}
		finally
		{
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
	 *             Error de interpretación del archivo.
	 */
	private void processFile(BufferedReader buffer) throws Exception
	{
		String buff = new String();
		char first;
		while ((buff = buffer.readLine()) != null)
		{
			if (buff.isEmpty())
				continue;

			first = buff.charAt(0);
			switch (first)
			{
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
	 * Procesa una línea que contiene una conexión.
	 * 
	 * @param buff
	 *            Línea.
	 */
	private void procesaConexion(String buff)
	{
		StringTokenizer tokens = new StringTokenizer(buff);
		tokens.nextToken();
		String tarea = tokens.nextToken();
		Tarea inicial = tabla_tareas.get(tarea);

		while (tokens.hasMoreTokens())
		{
			String siguienteNombre = tokens.nextToken();
			Tarea siguienteTarea = tabla_tareas.get(siguienteNombre);

			if (siguienteTarea != null)
			{
				inicial.anadirTareaConsecuente(siguienteTarea);
				siguienteTarea.anadirTareaAntecedente(inicial);
			}
		}

	}

	/**
	 * Procesa una línea que contiene una tarea.
	 * 
	 * @param buff
	 *            Línea.
	 * @throws Exception
	 *             Error de interpretación del fichero.
	 */
	private void procesaTarea(String buff) throws Exception
	{
		StringTokenizer tokenizer = new StringTokenizer(buff);

		if (tokenizer.countTokens() != 5)
			throw new Exception("Linea inválida" + buff);

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
	 * Procesa una línea que contiene los pesos.
	 * 
	 * @param buff
	 *            Línea.
	 */
	private void procesaPesos(String buff)
	{
		StringTokenizer tokens = new StringTokenizer(buff);

		// Descartamos la 'P'
		tokens.nextToken();

		peso_op = Double.parseDouble(tokens.nextToken());
		peso_prob = Double.parseDouble(tokens.nextToken());
		peso_pes = Double.parseDouble(tokens.nextToken());
	}

	/**
	 * Imprime una tarea crítica por pantalla.
	 * 
	 * @param t
	 *            Tarea
	 */
	private void printTareaCritica(Tarea t)
	{
		String additionalTab = t.getNombre().length() >= 8 ? "" : "\t";
		String line = String
				.format("%s%s\t%d\t%d\n", t.getNombre(), additionalTab, t
						.getComienzoOptimista(), t.getDuracionEstimada());
		System.out.print(line);
	}

	/**
	 * Imprime una tarea por pantalla
	 * 
	 * @param t
	 *            Tarea.
	 */
	private void printTarea(Tarea t)
	{
		String additionalTab = t.getNombre().length() >= 8 ? "" : "\t";
		String line = String.format("%s\t%s%d\t%d\t%d\t%d\t%d\t%d\n", t
				.getNombre(), additionalTab, t.getDuracionEstimada(), t
				.getComienzoOptimista(), t.getComienzoPesimista(), t
				.getFinOptimista(), t.getFinPesimista(), t.getHolgura());
		System.out.print(line);
	}

	/**
	 * Imprime la tabla de tareas por pantalla.
	 */
	public void printTareas()
	{
		Queue<Tarea> queue = new LinkedList<Tarea>();
		List<Tarea> printed = new ArrayList<Tarea>();
		Tarea task;

		System.out.println("Tabla resumen");
		System.out.println("-------------");
		System.out.println("Tarea\t\tDurac.\tcO\tcP\tfO\tfP\tHolgura");

		queue.add(tabla_tareas.get("Inicio"));

		do
		{
			task = queue.poll();

			if (printed.contains(task))
				continue;

			printTarea(task);
			printed.add(task);

			for (Tarea t : task.getConsecuentes())
			{
				queue.addAll(t.getConsecuentes());
				printTarea(t);
				printed.add(t);
			}
		} while (!queue.isEmpty());
	}

	/**
	 * Imprime por pantalla la duración estimada del proyecto.
	 */
	public void printDuracionEstimada()
	{
		Tarea fin = tabla_tareas.get("Fin");
		System.out.println();
		System.out.println("---------------");
		System.out.println("Duración estimada del proyecto : "
				+ fin.getFinOptimista());
		System.out.println("--------------");
	}

	/**
	 * Imprime la tabla de camino crítico del proyecto.
	 */
	public void printTablaCritica()
	{
		Queue<Tarea> queue = new LinkedList<Tarea>();
		List<Tarea> checked = new ArrayList<Tarea>();
		Tarea task;

		System.out.print("\nTabla crítica ordenada\n----------------------\n");
		System.out.println("Tarea\t\tc0\tDuracion");

		queue.add(tabla_tareas.get("Inicio"));

		do
		{
			task = queue.poll();

			if (checked.contains(task))
				continue;

			if (task.getHolgura() == 0)
				printTareaCritica(task);
			checked.add(task);

			for (Tarea t : task.getConsecuentes())
			{
				queue.addAll(t.getConsecuentes());
				if (t.getHolgura() == 0 && !checked.contains(t))
					printTareaCritica(t);
				checked.add(t);
			}
		} while (!queue.isEmpty());
	}
}
