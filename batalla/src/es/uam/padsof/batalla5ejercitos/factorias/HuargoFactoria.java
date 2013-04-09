package es.uam.padsof.batalla5ejercitos.factorias;

import java.util.Calendar;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Huargo;

public class HuargoFactoria implements CriaturaFactoria<Huargo> {

	@Override
	public Huargo crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Huargo(r.nextInt(4)+1,r.nextInt(3)+2,1);
	}

}
