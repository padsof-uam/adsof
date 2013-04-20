package es.uam.padsof.batalla5ejercitos.ejercitos;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import java.util.List;
import java.util.Map;

import es.uam.padsof.batalla5ejercitos.criaturas.CriaturaOscura;
import es.uam.padsof.batalla5ejercitos.factorias.CriaturaFactoria;

public class EjercitoOscuro extends Ejercito<CriaturaOscura> {

	public EjercitoOscuro(
			Map<Class<? extends CriaturaFactoria<? extends CriaturaOscura>>, List<Integer>> tropasMap)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		super(tropasMap);
	}

}
