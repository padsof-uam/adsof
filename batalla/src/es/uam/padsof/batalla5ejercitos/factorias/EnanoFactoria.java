package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Enano;

public class EnanoFactoria implements CriaturaFactoria<Enano> {

	@Override
	public Enano crearCriatura() {
		return new Enano(RandomUtils.randBetween(1, 4),
				RandomUtils.randBetween(1, 2), 1);
	}

}
