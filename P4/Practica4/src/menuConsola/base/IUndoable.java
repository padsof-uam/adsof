/**
 * 
 */
package menuConsola.base;

/**
 * Interfaz con métodos para deshacer y rehacer.
 * 
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 * 
 */
public interface IUndoable {
	public Object undo(Object o);

	public Object redo(Object o);
}
