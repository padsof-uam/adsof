package es.uam.padsof.batalla5ejercitos;

public class Main {
	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {		
		Batalla batalla = new Batalla();
		
		batalla.simular(500);
		
		System.out.println("Fin de la batalla.");
	}

}
