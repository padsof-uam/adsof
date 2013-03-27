package menuConsola;

import java.io.File;

import menuConsola.base.ConsoleMenu;
import menuPert.menu.*;
import menuPert.options.*;
import menuConsola.menus.DifferenceOption;
import menuConsola.menus.SumOption;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int i, opcion;
		boolean proyectoActivo = false, tiemposCalculados = false;
		ProyectoContainer container = new ProyectoContainer();
		ConsoleMenu menu = new ConsoleMenu("Aplicaci�n Pert");
		menu.addOption(new CreateProjectOption());
		menu.addOption(new AddLinkOption());
		menu.addOption(new AddTask());
		menu.addOption(new CalcularTiempos());
		menu.addOption(new MostrarTablaResumen());
		menu.addOption(new CargarDeFichero());

		try {
			do {
				/**
				 * Comprobaciones y marcacion de las opciones activas o no
				 * activas.
				 */
				if (!proyectoActivo) {
					for (i = 1; i < 6; ++i)
						menu.setActive(false, i);
					menu.setActive(true, 0);
					menu.setActive(true, 5);
				} else {
					for (i = 1; i < 6; ++i)
						menu.setActive(true, i);
					menu.setActive(false, 0);
					menu.setActive(false, 5);
				}
				if (tiemposCalculados)
					menu.setActive(true, 4);
				else
					menu.setActive(false, 4);

				/**
				 * Ejecucion
				 */

				opcion = (int) menu.execute(container);

				/**
				 * Comprobacion y marcacion de los flags en funcion de la opcion
				 * elegida.
				 */
				if (opcion == 1 || opcion == 6) {
					proyectoActivo = true;
				}
				if (opcion == 4) {
					tiemposCalculados = true;
					menu.setActive(true, 4);
				} else {
					/**
					 * La tabla no esta actualizada porque hemos añadido una
					 * tarea o un nuevo enlace.
					 */
					tiemposCalculados = false;
					menu.setActive(false, 4);
				}

			} while (opcion != -2);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
