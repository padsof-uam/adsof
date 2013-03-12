package menuConsola;

import java.util.Scanner;

public class ConsoleUtils {
	static Scanner token = null;

	private static Scanner getInputScanner() {
		if (token == null)
			token = new Scanner(System.in);

		return token;
	}

	public static int readOptionAdditional(int max) {
		int option;
		String input;
		Scanner scanner = getInputScanner();
		do {
			System.out.print("Introduzca una opción > ");
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
			} else {
				input = scanner.next();
				if (input.compareTo("a") == 0)
					option = -1;
				else if (input.compareTo("s") == 0)
					option = -2;
				else
					option = -5; // Para que repita.
			}
		} while (option == 0 || option > max || option < -2);

		return option;
	}

	public static int readOption(int max) {
		int option;
		Scanner scanner = getInputScanner();
		do {
			System.out.print("Introduzca la opcion de la que quiere solicitar ayuda > ");
			option = scanner.nextInt();
		} while ((option <= 0 && option > max) || option == -1 || option == -2);

		return option;
	}
}