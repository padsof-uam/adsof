package es.uam.padsof.batalla5ejercitos.factorias;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Huargo;

public class HuargoFactoria implements CriaturaFactoria<Huargo> {

	@Override
	public Huargo crearCriatura() {
		return new Huargo(RandomUtils.randBetween(1, 3),
				RandomUtils.randBetween(2, 4), 1);
	}

}
