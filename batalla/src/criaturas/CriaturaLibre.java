package criaturas;

public class CriaturaLibre extends Criatura {

	public CriaturaLibre(int ataque, int defensa, int vida) {
		super(ataque, defensa, vida);
	}
	public CriaturaLibre(int ataque, int defensa, int vida,double prob_curar) {
		super(ataque, defensa, vida,prob_curar);
	}

}
