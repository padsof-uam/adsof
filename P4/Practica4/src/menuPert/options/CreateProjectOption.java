package menuPert.options;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.IUndoable;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.*;

public class CreateProjectOption extends MenuOption implements IUndoable {

	public CreateProjectOption(String name, String description, boolean isActive) {
		super(name, description, isActive);
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		ProyectoContainer container = (ProyectoContainer) o;
		System.out.print("T’tulo del proyecto: ");
		
		String title = ConsoleUtils.getInputScanner().nextLine();
		container.proyecto = new Proyecto(title);
		container.proyecto.addTarea(new TareaInicio());
		container.proyecto.addTarea(new TareaFinal());
		
		return container;
	}

	Proyecto deleted;
	
	@Override
	public Object undo(Object o) {
		ProyectoContainer container = (ProyectoContainer) o;
		deleted = container.proyecto;
		container.proyecto = null;
		return container;
	}

	@Override
	public Object redo(Object o) {
		ProyectoContainer container = (ProyectoContainer) o;
		container.proyecto = deleted;
		return container;
	}

}
