/**
 * 
 */
package menuConsola;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author gjulianm
 * 
 */
public class ConsoleMenu implements IExecutable {
	ArrayList<MenuOption> options = new ArrayList<MenuOption>();
	HelpOption help = new HelpOption("Ayuda", "Muestra la ayuda", true);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see practica4.IExecutable#ejecutar(java.lang.Object)
	 */
	@Override
	public Object execute(Object o) throws ExecutionException {
		int counter = 0;
		int option;
		System.out.println("***************************");
		System.out.println("** Aplicaci�n Suma Resta **");
		System.out.println("***************************");
		System.out.println("Opciones:");

		for (MenuOption mo : options) {
			counter++;
			if (mo.isActive())
				System.out.println(counter + ".- " + mo.getName());
			else
				System.out.println(" .- [" + mo.getName() + "]");
		}
		
		System.out.println("-------------------------");
		System.out.println("a.- Ayuda");
		System.out.println("s.- Salir");
		System.out.println();
		
		
		option = ConsoleUtils.readOptionAdditional(counter);
		
		try
		{
			if(option > 0)
				options.get(option - 1).execute(null);
			else if(option == -1)
				help.execute(options);
			else{
				System.out.println("Saliendo.");
				
			}
		}
		catch(ExecutionException e)
		{
			System.out.println("Error de ejecuci�n en " + e.getMethod() + ": " + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Error general " + e.getClass().getName() + ": " + e.getMessage());
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
