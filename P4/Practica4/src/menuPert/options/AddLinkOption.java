/**
 * 
 */
package menuPert.options;

import java.util.Scanner;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.Proyecto;
import menuPert.proyector.Tarea;

/**
 * @author gjulianm
 *
 */
public class AddLinkOption extends MenuOption {

	public AddLinkOption(String name, String description, boolean isActive) {
		super(name, description, isActive);
	}

	/* (non-Javadoc)
	 * @see menuConsola.base.MenuOption#execute(java.lang.Object)
	 */
	@Override
	public Object execute(Object o) throws ExecutionException {
		Scanner scanner = ConsoleUtils.getInputScanner();
		String taskAName, taskBName;
		Tarea taskA, taskB;
		Proyecto p = ((ProyectoContainer) o).proyecto;
		
		System.out.println("Modificar: Establecer A como antecedente de B");
		System.out.print("Tarea A");
		taskAName = scanner.nextLine();
		System.out.print("Tarea B");
		taskBName = scanner.nextLine();
		
		taskA = p.getTarea(taskAName);
		
		if(taskA == null)
			throw new ExecutionException("No se puede encontrar la tarea " + taskAName, "AddLink");
		else if(taskAName == "Fin")
			throw new ExecutionException("No se pueden a–adir consecuentes a Fin", "AddLink");
		
		taskB = p.getTarea(taskBName);
		
		if(taskB == null)
			throw new ExecutionException("No se puede encontrar la tarea " + taskBName, "AddLink");
		else if(taskBName == "Inicio")
			throw new ExecutionException("No se pueden a–adir antecedentes a Inicio", "AddLink");
		
		taskA.anadirTareaConsecuente(taskB);
		taskB.anadirTareaAntecedente(taskA);
		
		return o;
	}

}
