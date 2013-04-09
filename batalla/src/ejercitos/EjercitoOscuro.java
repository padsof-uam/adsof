package ejercitos;

import java.util.List;
import java.util.Map;

import criaturas.CriaturaOscura;

public class EjercitoOscuro extends Ejercito<CriaturaOscura> {

	public EjercitoOscuro(
			Map<Class<? extends CriaturaOscura>, List<Integer>> tropasMap)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		super(tropasMap);
	}

}
