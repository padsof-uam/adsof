package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.criaturas.Criatura;

public abstract interface CriaturaFactoria<C extends Criatura> {
	public abstract C crearCriatura();

}
