package factories;

import java.util.Calendar;
import java.util.Random;

import criaturas.Enano;

public class EnanoFactoria implements CriaturaFactoria {

	@Override
	public Enano crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Enano(r.nextInt(4)+1,r.nextInt(2)+1,1,0);
	}

}
