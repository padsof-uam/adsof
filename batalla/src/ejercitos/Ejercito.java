package ejercitos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import util.Dependency;

import criaturas.Criatura;
import factories.CriaturaFactoria;


public abstract class Ejercito<C extends Criatura> {
	protected ArrayList<Tropa<C>> tropas;
	Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
	
	public Ejercito(Map<Class<? extends C>, List<Integer>> tropasMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		tropas = new ArrayList<Tropa<C>>();
		
		for(Class<? extends C> c : tropasMap.keySet())
		{
			CriaturaFactoria<? extends C> factoria = Dependency.Resolve(c);
			List<Integer> tropasList = tropasMap.get(c);
			
			for(Integer numTropas : tropasList)
			{
				Tropa<C> tropa = new Tropa<C>(factoria, numTropas);
				tropas.add(tropa);
			}
		}
	}
	
	public void atacar(Ejercito<?> ejercito)
	{
		for(Tropa<C> tropa : tropas)
			tropa.atacar(ejercito.getTropaAleatoria());
	}
	
	public boolean estaMuerto()
	{
		for(Tropa<C> tropa: tropas)
			if(!tropa.estaAniquilada())
				return false;
		
		return true;
	}
	
	public void mostrarEstadoTropas()
	{
		for(Tropa<C> tropa: tropas)
			System.out.println("- " + tropa.toString());
	}
	
	public Tropa<C> getTropaAleatoria()
	{
		return tropas.get(rnd.nextInt(tropas.size()));
	}

	public void aplicarHeridas() {
		for(Tropa<C> tropa: tropas)
			tropa.aplicarHeridas();		
	}

	public void actualizarEstado() {
		for(Tropa<C> tropa: tropas)
			tropa.actualizarEstado();		
	}
}

