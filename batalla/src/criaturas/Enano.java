package criaturas;

public class Enano extends Criatura {

	public Enano(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas, 0);
		this.tipo = TipoEjercito.Libres;
	}

}
