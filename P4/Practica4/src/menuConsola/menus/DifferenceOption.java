package menuConsola.menus;

import java.util.Scanner;

import menuConsola.ConsoleUtils;
import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;

public class DifferenceOption extends MenuOption {

	public DifferenceOption()
	{
		super("Restar", "Resta dos n�meros", true);
	}
	
	@Override
	public Object execute(Object o) throws ExecutionException {
		Scanner scanner = ConsoleUtils.getInputScanner();
		int a, b;
		
		System.out.print("A: ");
		a = scanner.nextInt();
		System.out.print("B: ");
		b = scanner.nextInt();
		
		System.out.println("A - B = " + (a - b));
		
		return a - b;
	}

}
