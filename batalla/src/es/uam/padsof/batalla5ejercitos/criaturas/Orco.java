package es.uam.padsof.batalla5ejercitos.criaturas;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
public class Orco extends CriaturaOscura {
	// Pasamos como argumento 0.2 que es la probabilidad de curarHeridas() de
	// los orcos
	public Orco(int ataque, int defensa, int vida) {
		super(ataque, defensa, vida, 0.2);
	}

}
