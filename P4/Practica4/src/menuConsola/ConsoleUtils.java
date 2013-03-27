package menuConsola;

import java.util.Scanner;

public class ConsoleUtils {
	static Scanner token = null;

	public static Scanner getInputScanner() {
		if (token == null)
			token = new Scanner(System.in);

		return token;
	}

	public static int readOptionAdditional(int max, boolean addUndoOption, boolean addRedoOption) {
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
				else if(input.compareTo("z") == 0)
					option = -3;
				else if(input.compareTo("y")==0)
					option = -4;
				else
					option = -5; // Para que repita.
			}
		} while (option == 0 || option > max || option < -5 || (!addUndoOption && option == -3) || (!addRedoOption && option == -4));

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