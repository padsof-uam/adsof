package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Orco;

public class OrcoFactoria implements CriaturaFactoria<Orco> {

	@Override
	public Orco crearCriatura() {
		return new Orco(RandomUtils.randBetween(2, 4), RandomUtils.randBetween(
				1, 2), 2);
	}

}
