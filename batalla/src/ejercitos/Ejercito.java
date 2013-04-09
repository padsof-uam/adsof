package ejercitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.Dependency;

import criaturas.Criatura;
import factories.CriaturaFactoria;


public abstract class Ejercito<C extends Criatura> {
	protected ArrayList<Tropa<C>> tropas;
	
	public Ejercito(Map<Class<? extends C>, List<Integer>> tropasMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		for(Class<? extends C> c : tropasMap.keySet())
		{
			CriaturaFactoria<? extends C> factoria = Dependency.Resolve(c);
			List<Integer> numTropas = tropasMap.get(c);
			
			for(Integer i : numTropas)
			{
				Tropa<C> tropa = new Tropa<C>(factoria, i);
				tropas.add(tropa);
			}
		}
	}
}

