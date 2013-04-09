package ejercitos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import criaturas.Criatura;
import factories.*;

public class Tropa<C extends Criatura> {

	int numGuerreros;
	ArrayList<C> guerreros;

	public Tropa(CriaturaFactoria<? extends C> factoria, int numeroGuerreros) {
		numGuerreros = numeroGuerreros;
		guerreros = new ArrayList<C>();

		for (int i = 0; i < numeroGuerreros; ++i)
			guerreros.add(factoria.crearCriatura());
	}

	public boolean estaAniquilada() {
		return (numGuerreros == 0);
	}

	public void atacar(Tropa<?> oponente) {
		// TODO: de momento atacamos a un aleatorio
		for (Criatura aux : guerreros)
			aux.atacar(oponente.getCriatura());
	}

	public Criatura getCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return this.guerreros.get(r.nextInt(guerreros.size()));

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
		return "Tropa de " + this.guerreros.get(0).getClass()
				+ "\nNumero de guerreros: " + this.numGuerreros;
	}
}
