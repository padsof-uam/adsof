package menuConsola;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleMenu menu = new ConsoleMenu();
		menu.addOption(new SumOption());
		menu.addOption(new DifferenceOption());
		try {
			menu.execute(null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
