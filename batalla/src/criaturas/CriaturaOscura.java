package criaturas;

public class CriaturaOscura extends Criatura {

	public CriaturaOscura(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas);
	}
	
	public CriaturaOscura(int ataque, int defensa, int vida, int heridas,double prob_curar) {
		super(ataque, defensa, vida, heridas,prob_curar);
	}

}
