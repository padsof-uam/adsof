package ejercitos;

import java.util.List;
import java.util.Map;

import criaturas.*;


public class EjercitoLibre extends Ejercito<CriaturaLibre> {

	public EjercitoLibre(Map<Class<? extends CriaturaLibre>, List<Integer>> tropasMap)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		super(tropasMap);
	}

}
