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
			while ((int) menu.execute(null) != -2)
				;
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
