package es.uam.padsof.batalla5ejercitos.factorias;

import es.uam.padsof.batalla5ejercitos.criaturas.Criatura;

public abstract interface CriaturaFactoria<C extends Criatura> {
	public abstract C crearCriatura();
	
	
}
