package menuConsola.base;

import menuConsola.ExecutionException;

/**
 * Interfaz con un método que ejecuta una acción.
 * 
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public interface IExecutable {
	Object execute(Object o) throws ExecutionException;
}
