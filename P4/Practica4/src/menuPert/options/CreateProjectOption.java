package menuPert.options;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.IUndoable;
import menuConsola.base.MenuOption;
import menuPert.menu.ProyectoContainer;
import menuPert.proyector.*;

public class CreateProjectOption extends MenuOption {

	public CreateProjectOption() {
		super("Crear un nuevo proyecto", "Crea un nuevo proyecto. Si ya hay uno creado ", true);
	}


	@Override
	public Object execute(Object o) throws ExecutionException {
		ProyectoContainer container = (ProyectoContainer) o;
		System.out.print("T�tulo del proyecto: ");
		ConsoleUtils.getInputScanner().nextLine();
		String title = ConsoleUtils.getInputScanner().nextLine();
		container.proyecto = new Proyecto(title);
		System.out.println("Peso pesimista: ");
		container.proyecto.setPeso_pes(ConsoleUtils.getInputScanner().nextInt());
		System.out.println("Peso probable: ");
		container.proyecto.setPeso_prob(ConsoleUtils.getInputScanner().nextInt());
		System.out.println("Peso optimista: ");
		container.proyecto.setPeso_op(ConsoleUtils.getInputScanner().nextInt());
		container.proyecto.addTarea(new TareaInicio());
		container.proyecto.addTarea(new TareaFinal());
		
		return container;
	}

	Proyecto deleted;
	


}
