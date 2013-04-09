package factories;

import java.util.Calendar;
import java.util.Random;

import criaturas.Elfo;

public class ElfoFactoria implements CriaturaFactoria<Elfo>{

	@Override
	public Elfo crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Elfo(r.nextInt(3)+1,r.nextInt(3)+1,2);
	}

}
