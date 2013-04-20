package es.uam.padsof.batalla5ejercitos.ejercitos;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import es.uam.padsof.batalla5ejercitos.criaturas.Criatura;
import es.uam.padsof.batalla5ejercitos.factorias.*;

public class Tropa<C extends Criatura> {

	private int numGuerreros;
	private ArrayList<C> guerreros;
	private String nombreCriatura;
	private Random rnd;

	public Tropa(CriaturaFactoria<? extends C> factoria, int numeroGuerreros) {
		numGuerreros = numeroGuerreros;
		guerreros = new ArrayList<C>();
		rnd = new Random(Calendar.getInstance().getTimeInMillis()
				+ numeroGuerreros);

		C dummy = factoria.crearCriatura();
		nombreCriatura = dummy.getClass().getSimpleName();

		for (int i = 0; i < numeroGuerreros; ++i)
			guerreros.add(factoria.crearCriatura());
	}

	public boolean estaAniquilada() {
		return (numGuerreros == 0);
	}

	public void atacar(Tropa<?> oponente) {
		if (oponente.estaAniquilada())
			return;

		for (Criatura aux : guerreros)
			aux.atacar(oponente.getCriatura());
	}

	public Criatura getCriatura() {
		return this.guerreros.get(rnd.nextInt(guerreros.size()));

	}

	public void aplicarHeridas() {
		for (Criatura aux : this.guerreros) {
			aux.aplicarHeridas();
			if (aux.estaMuerto())
				numGuerreros--;
		}
	}

	public void actualizarEstado() {
		ArrayList<C> muertos = new ArrayList<C>();
		for (C aux : this.guerreros) {
			if (aux.estaMuerto())
				muertos.add(aux);
		}
		this.guerreros.removeAll(muertos);
	}

	@Override
	public String toString() {
		return "Tropa de " + nombreCriatura + "\n\tNumero de guerreros: "
				+ this.numGuerreros;
	}
}
