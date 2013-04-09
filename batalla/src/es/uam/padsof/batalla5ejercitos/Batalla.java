package es.uam.padsof.batalla5ejercitos;

import java.util.*;

import es.uam.padsof.batalla5ejercitos.criaturas.*;
import es.uam.padsof.batalla5ejercitos.ejercitos.*;

public class Batalla {
	private EjercitoLibre ejLibre;
	private EjercitoOscuro ejOscuro;
	private Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
	
	public Batalla() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Map<Class<? extends CriaturaOscura>, List<Integer>> coMap = new HashMap<Class<? extends CriaturaOscura>, List<Integer>>();

		coMap.put(Orco.class, Arrays.asList(25, 75));
		coMap.put(Huargo.class, Arrays.asList(100));
		
		Map<Class<? extends CriaturaLibre>, List<Integer>> clMap = new HashMap<Class<? extends CriaturaLibre>, List<Integer>>();
		
		clMap.put(Humano.class, Arrays.asList(50,50,50,50));
		clMap.put(Elfo.class, Arrays.asList(150));
		clMap.put(Enano.class, Arrays.asList(25));
		
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
	
	public void simular(int msWait) throws InterruptedException
	{
		while(!ejLibre.estaMuerto() && !ejOscuro.estaMuerto())
		{
			update();
			mostrarEstado();
			Thread.sleep(msWait);
		}
	}

	private void mostrarEstado(Ejercito<?> ej, String nombre)
	{
		System.out.print("Estado del ej??rcito " + nombre + ": ");
		
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
