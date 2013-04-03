package menuConsola;

import menuConsola.base.ConsoleMenu;
import menuConsola.menus.DifferenceOption;
import menuConsola.menus.SumOption;

/**
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		ConsoleMenu menu = new ConsoleMenu("Aplicaci—n Suma Resta");
		menu.addOption(new SumOption());
		menu.addOption(new DifferenceOption());
		try {
			while ((int) menu.execute(null) != -2);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}