package es.uam.padsof.batalla5ejercitos.ejercitos;

import java.util.List;
import java.util.Map;

import es.uam.padsof.batalla5ejercitos.criaturas.*;
import es.uam.padsof.batalla5ejercitos.factorias.CriaturaFactoria;


public class EjercitoLibre extends Ejercito<CriaturaLibre> {

	public EjercitoLibre(Map<Class<? extends CriaturaFactoria<? extends CriaturaLibre>>, List<Integer>> tropasMap)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		super(tropasMap);
	}

}
