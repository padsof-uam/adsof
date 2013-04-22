package es.uam.padsof.batalla5ejercitos.criaturas;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */

public class Elfo extends CriaturaLibre {

	// Pasamos como argumento del cronstuctor 0.3 que es la probabilidad que
	// tienen los elfos de curarHeridas()
	public Elfo(int ataque, int defensa, int vida) {
		super(ataque, defensa, vida, 0.3);
	}

}
