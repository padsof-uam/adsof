package batalla;

import java.util.*;

import criaturas.*;
import ejercitos.*;

public class Batalla {
	EjercitoLibre ejLibre;
	EjercitoOscuro ejOscuro;
	Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
	
	public Batalla() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Map<Class<? extends CriaturaOscura>, List<Integer>> coMap = new HashMap<Class<? extends CriaturaOscura>, List<Integer>>();

		coMap.put(Orco.class, Arrays.asList(100, 200));
		coMap.put(Huargo.class, Arrays.asList(100));
		
		Map<Class<? extends CriaturaLibre>, List<Integer>> clMap = new HashMap<Class<? extends CriaturaLibre>, List<Integer>>();
		
		clMap.put(Humano.class, Arrays.asList(50,50,50,50));
		clMap.put(Elfo.class, Arrays.asList(150));
		clMap.put(Enano.class, Arrays.asList(25, 75));
		
		ejLibre = new EjercitoLibre(clMap);
		ejOscuro = new EjercitoOscuro(coMap);
	}
	
	public void update()
	{
		Ejercito<?> first;
		Ejercito<?> second;
		
		if(rnd.nextInt(2) == 0)
		{
			first = ejLibre;
			second = ejOscuro;
		}
		else
		{
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
	
	public void simular()
	{
		while(!ejLibre.estaMuerto() && !ejOscuro.estaMuerto())
		{
			update();
			mostrarEstado();
		}
	}

	private void mostrarEstado(Ejercito<?> ej, String nombre)
	{
		System.out.print("Estado del ejército " + nombre + ": ");
		
		if(ej.estaMuerto())
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
