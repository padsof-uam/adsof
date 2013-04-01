/**
 * 
 */
package menuPert.options;

import java.util.Scanner;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.IUndoable;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.Proyecto;
import menuPert.proyector.Tarea;

/**
 * @author gjulianm
 * 
 */
public class AddLinkOption extends MenuOption implements IUndoable {

	public AddLinkOption() {
		super(
				"Añade un enlace entre tareas",
				"Añade un enlace entre 2 tareas previamente añadidas al proyecto",
				false);
	}

	Tarea precedenteRedo = null;
	Tarea consecuenteRedo = null;
	Tarea precedenteUndo = null;
	Tarea consecuenteUndo = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see menuConsola.base.MenuOption#execute(java.lang.Object)
	 */
	@Override
	public Object execute(Object o) throws ExecutionException {
		Scanner scanner = ConsoleUtils.getInputScanner();
		String taskAName, taskBName;
		Tarea taskA, taskB;
		Proyecto p = ((ProyectoContainer) o).proyecto;
		taskAName = scanner.nextLine();
		System.out.println("Modificar: Establecer A como antecedente de B");
		System.out.println("Nombre de la tarea A: ");
		taskAName = scanner.nextLine();
		System.out.print("Nombre de la tarea B");
		taskBName = scanner.nextLine();

		taskA = p.getTarea(taskAName);

		if (taskA == null)
			throw new ExecutionException("No se puede encontrar la tarea "
					+ taskAName, "AddLink");
		else if (taskAName == "Fin")
			throw new ExecutionException(
					"No se pueden a�adir consecuentes a Fin", "AddLink");

		taskB = p.getTarea(taskBName);

		if (taskB == null)
			throw new ExecutionException("No se puede encontrar la tarea "
					+ taskBName, "AddLink");
		else if (taskBName == "Inicio")
			throw new ExecutionException(
					"No se pueden a�adir antecedentes a Inicio", "AddLink");

		precedenteUndo = taskA;
		consecuenteUndo = taskB;

		taskA.anadirTareaConsecuente(taskB);
		taskB.anadirTareaAntecedente(taskA);

		return o;
	}

	@Override
	public Object undo(Object o) {
		Proyecto p = ((ProyectoContainer) o).proyecto;
		p.getTarea(consecuenteUndo.getNombre()).getAntecedentes()
				.remove(precedenteUndo);
		p.getTarea(precedenteUndo.getNombre()).getConsecuentes()
				.remove(consecuenteUndo);
		precedenteRedo = precedenteUndo;
		precedenteUndo = null;
		consecuenteRedo = consecuenteUndo;
		consecuenteUndo = null;
		return o;
	}

	@Override
	public Object redo(Object o) {
		Proyecto p = ((ProyectoContainer) o).proyecto;
		p.getTarea(consecuenteRedo.getNombre()).getAntecedentes()
				.add(precedenteRedo);
		p.getTarea(precedenteRedo.getNombre()).getConsecuentes()
				.add(consecuenteRedo);
		precedenteUndo = precedenteRedo;
		precedenteRedo = null;
		consecuenteUndo = consecuenteRedo;
		consecuenteRedo = null;
		return o;
	}

}
