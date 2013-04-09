package criaturas;

public class CriaturaLibre extends Criatura {

	public CriaturaLibre(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas);
	}
	public CriaturaLibre(int ataque, int defensa, int vida, int heridas,double prob_curar) {
		super(ataque, defensa, vida, heridas,prob_curar);
	}

}
