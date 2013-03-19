/**
 * 
 */
package menuConsola.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.menus.HelpOption;

/**
 * @author gjulianm
 * 
 */
public class ConsoleMenu implements IExecutable {
	private ArrayList<MenuOption> options = new ArrayList<MenuOption>();
	private HelpOption help = new HelpOption("Ayuda", "Muestra la ayuda", true);
	private IUndoable lastOption = null;
	private Object lastArg = null;
	private String title;

	public ConsoleMenu(String title)
	{
		this.title = title;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see practica4.IExecutable#ejecutar(java.lang.Object)
	 */
	@Override
	public Object execute(Object o) throws ExecutionException {
		int counter = 0;
		int option;

		String header = new String(new char[title.length() + 3 * 2]).replace('\0', '*');
		System.out.println(header);
		System.out.println("** " + title  + " **");
		System.out.println(header);
		System.out.println("Opciones:");

		for (MenuOption mo : options) {
			counter++;
			mo.print(counter);
		}

		System.out.println("-------------------------");
		System.out.println("a.- Ayuda");
		System.out.println("s.- Salir");
		if (lastOption != null)
		{
			System.out.println("z.- Deshacer");
			System.out.println("y.- Rehacer");
		}
		System.out.println();

		option = ConsoleUtils.readOptionAdditional(counter, lastOption != null);

		try {
			if (option > 0) {
				MenuOption mo = options.get(option - 1);
				mo.execute(o);
				if (IUndoable.class.isInstance(mo)) {
					lastOption = (IUndoable) mo;
					lastArg = o;
				}
			}
			else if (option == -1) {
				help.execute(options);
			} else if (option == -3) {
				lastOption.undo(lastArg);
				lastOption = null;
				lastArg = null;
			} else
				System.out.println("Saliendo.");
		} catch (ExecutionException e) {
			System.out.println("Error de ejecución en " + e.getMethod() + ": "
					+ e.getMessage());
		} catch (Exception e) {
			System.out.println("Error general " + e.getClass().getName() + ": "
					+ e.getMessage());
		}

		return option;
	}

	public void addOption(MenuOption option) {
		options.add(option);
	}

	public void addOptions(Collection<MenuOption> list) {
		options.addAll(list);
	}

	public void sortOptions() {
		Collections.sort(options);
	}

	public void deleteOption(MenuOption o) {
		options.remove(o);
	}
}
