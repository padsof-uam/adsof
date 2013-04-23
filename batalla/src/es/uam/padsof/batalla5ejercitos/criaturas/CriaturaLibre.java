package es.uam.padsof.batalla5ejercitos.criaturas;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
public class CriaturaLibre extends Criatura {
	/**
	 * Hemos implementado 2 constructores la variable de prob_curar en vez de la
	 * interfaz
	 */
	public CriaturaLibre(int ataque, int defensa, int vida) {
		super(ataque, defensa, vida);
	}

	public CriaturaLibre(int ataque, int defensa, int vida, double prob_curar) {
		super(ataque, defensa, vida, prob_curar);
	}

}
