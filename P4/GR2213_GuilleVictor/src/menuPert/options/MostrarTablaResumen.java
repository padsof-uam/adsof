package menuPert.options;

import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;

/**
 * Muestra la tabla con las tareas y sus tiempos.
 * 
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public class MostrarTablaResumen extends MenuOption {

	public MostrarTablaResumen() {
		super("Muestrar tabla resumen",
				"Muestra la tabla resumen del proyecto", false);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		ProyectoContainer proj = (ProyectoContainer) o;
		proj.proyecto.printTareas();
		return o;
	}

}
