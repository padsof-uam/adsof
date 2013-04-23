package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Elfo;

public class ElfoFactoria implements CriaturaFactoria<Elfo> {

	@Override
	public Elfo crearCriatura() {
		return new Elfo(RandomUtils.randBetween(2, 3), RandomUtils.randBetween(
				2, 3), 2);
	}

}
