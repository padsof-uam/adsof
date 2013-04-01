package menuPert.options;

import java.util.Scanner;
import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.Proyecto;

/**
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public class CargarDeFichero extends MenuOption {

	public CargarDeFichero() {
		super("Cargar de fichero un proyecto",
				"Carga un nuevo proyecto PERT desde un fichero especificado",
				true);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		String file;
		Scanner scanner = ConsoleUtils.getInputScanner();
		System.out.print("Introduzca la ruta del archivo: ");
		file = scanner.next();
		ProyectoContainer proj_act = ((ProyectoContainer) o);
		proj_act.proyecto = new Proyecto(file);

		try {
			proj_act.proyecto.setFile(file);
			proj_act.proyecto.readFile();
		} catch (Exception e) {
			throw new ExecutionException("File Error", "Couldnt open file");
		}

		return o;
	}

}
