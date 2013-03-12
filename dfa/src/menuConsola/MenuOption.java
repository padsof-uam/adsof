/**
 * 
 */
package menuConsola;

/**
 * @author gjulianm
 *
 */
public abstract class MenuOption implements IExecutable, Comparable<MenuOption> {
	private String description;
	private String name;
	private boolean active;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public abstract Object execute(Object o) throws ExecutionException;

	public MenuOption(String name, String description, boolean isActive)
	{
		this.name = name;
		this.description = description;
		this.active = isActive;
	}
	
	public int compareTo(MenuOption o)
	{
		return name.compareToIgnoreCase(o.getName());
	}
	
}
