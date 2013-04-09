package es.uam.padsof.batalla5ejercitos;

import es.uam.padsof.batalla5ejercitos.criaturas.*;
import es.uam.padsof.batalla5ejercitos.factorias.*;
import es.uam.padsof.batalla5ejercitos.util.Dependency;

public class Main {
	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
		Dependency.Register(Elfo.class, ElfoFactoria.class);
		Dependency.Register(Enano.class, EnanoFactoria.class);
		Dependency.Register(Huargo.class, HuargoFactoria.class);
		Dependency.Register(Humano.class, HumanoFactoria.class);
		Dependency.Register(Orco.class, OrcoFactoria.class);
		
		Batalla batalla = new Batalla();
		
		batalla.simular(500);
		
		System.out.println("Fin de la batalla.");
	}

}
