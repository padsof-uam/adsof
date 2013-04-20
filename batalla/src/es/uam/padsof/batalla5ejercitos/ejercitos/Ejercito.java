package es.uam.padsof.batalla5ejercitos.ejercitos;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.padsof.batalla5ejercitos.factorias.CriaturaFactoria;

public abstract class Ejercito<C extends Criatura> {
	protected ArrayList<Tropa<C>> tropas;
	Random rnd = new Random(Calendar.getInstance().getTimeInMillis());

	public Ejercito(
			Map<Class<? extends CriaturaFactoria<? extends C>>, List<Integer>> tropasMap)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		tropas = new ArrayList<Tropa<C>>();

		for (Class<? extends CriaturaFactoria<? extends C>> c : tropasMap
				.keySet()) {
			CriaturaFactoria<? extends C> factoria = c.newInstance();
			List<Integer> tropasList = tropasMap.get(c);

			for (Integer numTropas : tropasList) {
				Tropa<C> tropa = new Tropa<C>(factoria, numTropas);
				tropas.add(tropa);
			}
		}
	}

	/**
	 * Ataca aleatoriamente al ejercito pasado como argumento.
	 * 
	 * @param ejercito
	 */
	public void atacar(Ejercito<?> ejercito) {
		for (Tropa<C> tropa : tropas)
			tropa.atacar(ejercito.getTropaAleatoria());
	}

	/**
	 * 
	 * @return true si todas las tropas han sido aniquiladas.
	 */
	public boolean estaMuerto() {
		for (Tropa<C> tropa : tropas)
			if (!tropa.estaAniquilada())
				return false;

		return true;
	}

	public void mostrarEstadoTropas() {
		for (Tropa<C> tropa : tropas)
			System.out.println("- " + tropa.toString());
	}

	/**
	 * 
	 * @return una tropa aleatoria del ejército
	 */
	public Tropa<C> getTropaAleatoria() {
		return tropas.get(rnd.nextInt(tropas.size()));
	}

	public void aplicarHeridas() {
		for (Tropa<C> tropa : tropas)
			tropa.aplicarHeridas();
	}

	public void actualizarEstado() {
		for (Tropa<C> tropa : tropas)
			tropa.actualizarEstado();
	}
}
