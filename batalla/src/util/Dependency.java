package util;

import java.util.HashMap;
import java.util.Map;

import criaturas.Criatura;

import factories.CriaturaFactoria;

public final class Dependency {
	public static Map<Class<? extends Criatura>, Class<? extends CriaturaFactoria<?>>> classMap = new HashMap<Class<? extends Criatura>, Class<? extends CriaturaFactoria<?>>>(); 

	public static <C extends Criatura> void Register(Class<C> generic, Class<CriaturaFactoria<? extends C>> impl)
	{
		classMap.put(generic, impl);
	}
	
	public static <C extends Criatura> CriaturaFactoria<C> Resolve(Class<C> generic) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		if(!classMap.containsKey(generic))
			throw new ClassNotFoundException("Clase " + generic.getName() + " no encontrada.");
		
		@SuppressWarnings("unchecked")
		Class<CriaturaFactoria<C>> cls = (Class<CriaturaFactoria<C>>) classMap.get(generic);
		
		return cls.newInstance();
	}
}
