package menuConsola;

import java.util.Scanner;

public class DifferenceOption extends MenuOption {

	public DifferenceOption()
	{
		super("Restar", "Resta dos nœmeros", true);
	}
	
	@Override
	public Object execute(Object o) throws ExecutionException {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		
		System.out.print("A: ");
		a = scanner.nextInt();
		System.out.print("B: ");
		b = scanner.nextInt();
		
		System.out.println("A - B = " + (a - b));
		
		scanner.close();
		
		return a - b;
	}

}
