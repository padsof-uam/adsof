package menuConsola;

public class SubMenuOption extends MenuOption {
	ConsoleMenu menu;
	
	public SubMenuOption(String name, String description, boolean isActive) {
		super(name, description, isActive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(Object o) throws ExecutionException {
		if(menu == null)
			throw new ExecutionException("Execute submenu", "Submenu is null");
		
		return menu.execute(o);
	}

	/**
	 * @return the menu
	 */
	public ConsoleMenu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(ConsoleMenu menu) {
		this.menu = menu;
	}

}
