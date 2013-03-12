package menuConsola.menus;

import java.util.Scanner;

import menuConsola.ExecutionException;
import menuConsola.base.MenuOption;

public class SumOption extends MenuOption {

	public SumOption()
	{
		super("Sumar", "Suma dos números", true);
	}
	
	@Override
	public Object execute(Object o) throws ExecutionException {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		
		System.out.println("A: ");
		a = scanner.nextInt();
		System.out.println("B: ");
		b = scanner.nextInt();
		
		System.out.println("A + B = " + (a + b));
		
		scanner.close();
		
		return a + b;
	}

}
