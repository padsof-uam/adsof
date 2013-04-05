package criaturas;

public class Elfo extends Criatura {
	
	public Elfo(int ataque, int defensa, int vida, int heridas){
		super(ataque,defensa,vida,heridas,0.3);
		this.tipo = TipoEjercito.Libres;
	}

}
