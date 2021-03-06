package menuConsola;

import java.util.Scanner;

public class SumOption extends MenuOption {

	public SumOption()
	{
		super("Sumar", "Suma dos n�meros", true);
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
