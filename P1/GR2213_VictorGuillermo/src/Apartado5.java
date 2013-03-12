/** 
 * Esta aplicación recibe puntos como argumentos de la línea de 
 * comandos y les aplica una translación uniforme, de manera que 
 * al punto que antes era el más alejado del origen de coordenadas (0,0)
 * le corresponde el nuevo origen de coordenadas. 
 * Se imprime la distancia total del array de puntos y
 * todos los puntos.   
 * 
 * @author Guillermo Julián Moreno <guillermo.julian@estudiante.uam.es>
 * @author Víctor de Juan Sanz <vic.dejuan@estudiante.uam.es>  
 */ 
public class Apartado5
{ 
	/** 
	  * Este método calcula la distancia acumulada entre cada punto y el siguiente. 
	  * @param points Lista de puntos.
	  */ 
	private static double computeDistance(Punto[] points)
	{
		double sum = 0;
		for (int i = 0; i < points.length - 1; i++)
		{
			Punto a = points[i];
			Punto b = points[i + 1];

			sum += a.distancia(b);
		}

		return sum;
	}

	public static void main(String[] args) 
	{ 
		// Verificar número de argumentos es par, dos coordenadas por punto
		if ((args.length % 2) != 0) 
		{ 
			System.out.println("Se esperan un numero par de parametros."); 
			return; 
		} 

		// Crear y rellenar un array con los puntos procedentes de los argumentos
		int nmrPuntos = args.length / 2; 
		Punto[] puntos = new Punto[nmrPuntos]; // array de puntos dados como argumentos 
		
		for (int i = 0; i < nmrPuntos; i++) 
			puntos[i] = new Punto(Integer.parseInt(args[2 * i]), Integer.parseInt(args[2 * i + 1]));
		
		double maxDist = 0;
		Punto max = new Punto(0,0); // Lo inicializamos a un valor "dummy".
		Punto origen = new Punto(0,0);
		double originalSum = 0;

		for(Punto p : puntos)
		{
			double dist = origen.distancia(p);
			originalSum += dist;

			if(dist > maxDist)
			{
				maxDist = dist;
				max = p;
			}
		}

		System.out.println("Más alejado " + max);
		System.out.println("Distancia total original: " + computeDistance(puntos));

		Punto[] desplazados = new Punto[nmrPuntos];
		for(int i = 0; i < nmrPuntos; i++)
		{
			desplazados[i] = new Punto (puntos[i].getAbscisa(),puntos[i].getOrdenada());
			desplazados[i].desplazar((-1) * max.getAbscisa(), (-1)*max.getOrdenada());
		}

		System.out.println("Distancia total desplazados: " + computeDistance(desplazados));

		System.out.println("Puntos originales:");
		for(Punto p : puntos)
			System.out.println(p);
	
		System.out.println("Puntos desplazados:");
		for(Punto p : desplazados)
			System.out.println(p);
	}
}
