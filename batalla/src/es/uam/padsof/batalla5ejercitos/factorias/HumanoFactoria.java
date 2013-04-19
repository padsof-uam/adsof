package es.uam.padsof.batalla5ejercitos.factorias;

import es.uam.padsof.batalla5ejercitos.RandomUtils;
import es.uam.padsof.batalla5ejercitos.criaturas.Humano;

public class HumanoFactoria implements CriaturaFactoria<Humano> {

	@Override
	public Humano crearCriatura() {
		return new Humano(RandomUtils.randBetween(2, 4), RandomUtils.randBetween(1, 3) ,1);
	}

}
