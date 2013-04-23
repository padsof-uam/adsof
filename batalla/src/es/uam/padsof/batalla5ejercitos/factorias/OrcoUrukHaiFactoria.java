package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Orco;

public class OrcoUrukHaiFactoria implements CriaturaFactoria<Orco> {

	@Override
	public Orco crearCriatura() {
		return new Orco(RandomUtils.randBetween(3, 5), RandomUtils.randBetween(
				2, 3), 2);
	}

}
