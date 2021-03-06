package menuConsola.menus;

import java.util.List;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;

/**
 * Opcion de mostrar ayuda.
 * 
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public class HelpOption extends MenuOption {

	public HelpOption(String name, String description, boolean isActive) {
		super(name, description, isActive);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		@SuppressWarnings("unchecked")
		List<MenuOption> options = (List<MenuOption>) o;
		int option = ConsoleUtils.readOption(options.size());
		MenuOption menu = options.get(option - 1);
		System.out.println(menu.getName() + ": " + menu.getDescription());
		return null;
	}

}
