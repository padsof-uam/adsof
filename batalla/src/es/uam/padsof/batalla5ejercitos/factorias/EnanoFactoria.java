package es.uam.padsof.batalla5ejercitos.factorias;

import java.util.Calendar;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Enano;

public class EnanoFactoria implements CriaturaFactoria<Enano> {

	@Override
	public Enano crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Enano(r.nextInt(4)+1,r.nextInt(2)+1,1);
	}

}
