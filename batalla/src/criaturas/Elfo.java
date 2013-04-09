package criaturas;


public class Elfo extends CriaturaLibre {
	final double prob_curar;
	
	public Elfo(int ataque, int defensa, int vida, int heridas){
		super(ataque,defensa,vida,heridas);
		this.prob_curar = 0.3;
	}


}
