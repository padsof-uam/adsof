package proyector;

import java.io.IOException;

/**
 * Clase "main" del programa.
 * 
 * @author Víctor de Juan Sanz
 * @author Guillermo Julián Moreno
 * 
 */
public class proyector
{

	/**
	 * Método principal del programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out
					.println("Es necesario pasar el nombre de archivo como argumento.");
			return;
		}

		Proyecto pert = new Proyecto(args[0]);

		try
		{
			pert.readFile();
		}
		catch (IOException e)
		{
			System.out.println("Error de I/O: " + e.getMessage());
			return;
		}
		catch (Exception e)
		{
			System.out.println("Error general: " + e.getMessage());
			return;
		}

		pert.printTareas();
		pert.printDuracionEstimada();
		pert.printTablaCritica();
	}
}
