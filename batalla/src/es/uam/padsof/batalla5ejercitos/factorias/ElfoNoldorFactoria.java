package es.uam.padsof.batalla5ejercitos.factorias;

import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Elfo;

public class ElfoNoldorFactoria implements CriaturaFactoria<Elfo>{

	@Override
	public Elfo crearCriatura() {
		return new Elfo(RandomUtils.randBetween(3, 4), RandomUtils.randBetween(3, 4), 2);
	}

}
