package factories;

import criaturas.Criatura;

public abstract interface CriaturaFactoria<C extends Criatura> {
	public abstract C crearCriatura();
	
	
}
