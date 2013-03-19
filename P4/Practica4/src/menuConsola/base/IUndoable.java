/**
 * 
 */
package menuConsola.base;

/**
 * @author gjulianm
 *
 */
public interface IUndoable {
	public Object undo(Object o);
	public Object redo(Object o);
}
