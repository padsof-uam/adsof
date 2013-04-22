package es.uam.padsof.batalla5ejercitos;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 * 
 */
import java.util.*;

import es.uam.padsof.batalla5ejercitos.criaturas.*;
import es.uam.padsof.batalla5ejercitos.ejercitos.*;
import es.uam.padsof.batalla5ejercitos.factorias.*;

public class Batalla {
	private EjercitoLibre ejLibre;
	private EjercitoOscuro ejOscuro;
	private Random rnd = new Random(Calendar.getInstance().getTimeInMillis());

	public Batalla() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Map<Class<? extends CriaturaFactoria<? extends CriaturaOscura>>, List<Integer>> coMap = new HashMap<Class<? extends CriaturaFactoria<? extends CriaturaOscura>>, List<Integer>>();

		coMap.put(OrcoFactoria.class, Arrays.asList(25, 75));
		coMap.put(HuargoFactoria.class, Arrays.asList(100));
		coMap.put(OrcoUrukHaiFactoria.class, Arrays.asList(30));
		
		Map<Class<? extends CriaturaFactoria<? extends CriaturaLibre>>, List<Integer>> clMap = 
				new HashMap<Class<? extends CriaturaFactoria<? extends CriaturaLibre>>, List<Integer>>();
		
		clMap.put(HumanoFactoria.class, Arrays.asList(50,50,50,50));
		clMap.put(ElfoFactoria.class, Arrays.asList(150));
		clMap.put(EnanoFactoria.class, Arrays.asList(25));
		clMap.put(ElfoNoldorFactoria.class, Arrays.asList(40));
		
		ejLibre = new EjercitoLibre(clMap);
		ejOscuro = new EjercitoOscuro(coMap);
	}

	/**
	 * Turno de los ejércitos. Empieza a atacar uno aleatoriamente, después de
	 * los ataques se aplican las heridas y se actualiza el estado (se eliminan
	 * los guerreros que estén muertos)
	 */
	public void update() {
		Ejercito<?> first;
		Ejercito<?> second;

		if (rnd.nextInt(2) == 0) {
			first = ejLibre;
			second = ejOscuro;
		} else {
			first = ejOscuro;
			second = ejLibre;
		}

		first.atacar(second);
		second.atacar(first);

		first.aplicarHeridas();
		second.aplicarHeridas();

		first.actualizarEstado();
		second.actualizarEstado();
	}

	public void simular(int msWait) throws InterruptedException {
		while (!ejLibre.estaMuerto() && !ejOscuro.estaMuerto()) {
			update();
			mostrarEstado();
			Thread.sleep(msWait);
		}
		if (!ejLibre.estaMuerto())
			System.out.println("Ejército vencedor : Ejército Libre");
		else
			System.out.println("Ejército vencedor : Ejército Oscuro");

	}

	private void mostrarEstado(Ejercito<?> ej, String nombre) {
		System.out.print("Estado del ej??rcito " + nombre + ": ");

		if (ej.estaMuerto())
			System.out.println("Aniquilado");
		else
			System.out.println("En combate");

		ej.mostrarEstadoTropas();
	}

	public void mostrarEstado() {
		mostrarEstado(ejLibre, "libre");
		mostrarEstado(ejOscuro, "oscuro");
	}

}
