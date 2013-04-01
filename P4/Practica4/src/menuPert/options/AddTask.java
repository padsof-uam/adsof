package menuPert.options;

import java.util.Scanner;
import java.util.Stack;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.IUndoable;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.*;

/**
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public class AddTask extends MenuOption implements IUndoable {

	public AddTask() {
		super("Añadir tarea", "Añade una tarea al proyecto", true);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		if (o.getClass() != ProyectoContainer.class) {
			throw new ExecutionException("Bad parameter", "Can't add a task");
		}
		ProyectoContainer proj = (ProyectoContainer) o;
		Scanner scanner = ConsoleUtils.getInputScanner();

		System.out.print("Nombre de la tarea: ");
		String name;
		name = scanner.next();
		int p_op, p_pes, p_prob;
		System.out.print("Peso optimista de la tarea: ");
		p_op = scanner.nextInt();
		System.out.print("Peso pesimista de la tarea: ");
		p_pes = scanner.nextInt();
		System.out.print("Peso probable de la tarea: ");
		p_prob = scanner.nextInt();

		Tarea task = new Tarea(p_op, p_pes, p_prob, name,
				proj.proyecto.getPeso_op(), proj.proyecto.getPeso_pes(),
				proj.proyecto.getPeso_prob());
		proj.proyecto.addTarea(task);
		done.push(task);
		return o;
	}

	Stack<Tarea> done = new Stack<Tarea>();
	Stack<Tarea> undone = new Stack<Tarea>();

	/**
	 * Métodos deshacer y rehacer crear crear una tarea.
	 */
	@Override
	public Object undo(Object o) {
		ProyectoContainer p = (ProyectoContainer) o;
		Tarea aux = done.pop();
		p.proyecto.eliminarTarea(aux);
		undone.push(aux);
		return o;
	}

	@Override
	public Object redo(Object o) {
		ProyectoContainer p = (ProyectoContainer) o;
		Tarea aux = undone.pop();
		p.proyecto.addTarea(aux);
		done.push(aux);
		return o;
	}

}
