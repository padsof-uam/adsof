package es.uam.padsof.batalla5ejercitos.factorias;

import java.util.Calendar;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Humano;

public class HumanoFactoria implements CriaturaFactoria<Humano> {

	@Override
	public Humano crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Humano(r.nextInt(3)+2,r.nextInt(3)+1,1);
	}

}
