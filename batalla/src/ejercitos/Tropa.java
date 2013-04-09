package ejercitos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import criaturas.Criatura;
import criaturas.TipoEjercito;
import factories.CriaturaFactoria;
import factories.ElfoFactoria;
import factories.EnanoFactoria;
import factories.HumanoFactoria;

public class Tropa {

	int numGuerreros;
	ArrayList<Criatura> guerreros;

	public Tropa(CriaturaFactoria factoria, int numeroGuerreros) {
		numGuerreros = numeroGuerreros;
		guerreros = new ArrayList<Criatura>();
		int i = 0;
		for (i = 0; i < numeroGuerreros; ++i) {
			// TODO: donde se guardan...? ALguna cosa mejor que arrayList
			guerreros.add(factoria.crearCriatura());
		}
	}

	public boolean estaAniquilada() {
		return (numGuerreros == 0);
	}

	public void atacar(Tropa oponente) {
		// TODO: de momento atacamos a un aleatorio
		for (Criatura aux : guerreros)
			aux.atacar(oponente.getCriatura());
	}

	public Criatura getCriatura() {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return this.guerreros.get(r.nextInt(guerreros.size()));

	}

	public void aplicarHeridas() {
		for (Criatura aux : this.guerreros)
			aux.aplicarHeridas();
	}
}
