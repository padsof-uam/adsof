package menuPert.options;

import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;

/**
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public class CalcularTiempos extends MenuOption {

	public CalcularTiempos() {
		super(
				"Calcular tiempos: ",
				"Calcula los tiempos optimistas, pesimistas y las holguras del proyecto.",
				true);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		ProyectoContainer proj = (ProyectoContainer) o;
		proj.proyecto.calcularTiempos();
		return o;
	}

}
