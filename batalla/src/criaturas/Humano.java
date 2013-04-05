package criaturas;

public class Humano extends Criatura {

	public Humano(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas, 0);
		this.tipo = TipoEjercito.Libres;
	}

}
