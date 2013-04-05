package criaturas;

public class Orco extends Criatura {

	public Orco(int ataque, int defensa, int vida, int heridas) {
		super(ataque, defensa, vida, heridas, 0.2);
		this.tipo = TipoEjercito.Oscuras;
	}

}
