package es.uam.padsof.batalla5ejercitos.criaturas;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
public class CriaturaOscura extends Criatura {

	public CriaturaOscura(int ataque, int defensa, int vida) {
		super(ataque, defensa, vida);
	}

	public CriaturaOscura(int ataque, int defensa, int vida, double prob_curar) {
		super(ataque, defensa, vida, prob_curar);
	}

}
