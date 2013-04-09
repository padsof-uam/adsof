package es.uam.padsof.batalla5ejercitos.factorias;

import java.util.Calendar;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Orco;

public class OrcoFactoria implements CriaturaFactoria<Orco>{

	@Override
	public Orco crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Orco(r.nextInt(3)+2,r.nextInt(2)+1,2);
	}

}
