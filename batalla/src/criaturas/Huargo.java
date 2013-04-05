package criaturas;

public class Huargo extends Criatura {

	public Huargo(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas, 0);
		this.tipo = TipoEjercito.Oscuras;
	}

}
