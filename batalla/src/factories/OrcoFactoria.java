package factories;

import java.util.Calendar;
import java.util.Random;

import criaturas.Orco;

public class OrcoFactoria implements CriaturaFactoria{

	@Override
	public Orco crearCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Orco(r.nextInt(3)+2,r.nextInt(2)+1,2,0);
	}

}
