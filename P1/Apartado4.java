/** 
 * Esta aplicación recibe puntos como argumentos de la línea de 
 * comandos, imprimiendo la distancia entre cada punto y el siguiente.
 * Después imprime la distancia total acumulada. y la distancia parcial 
 * máxima.   
 * 
 * @author Guillermo Julián Moreno <guillermo.julian@estudiante.uam.es>
 * @author Víctor de Juan Sanz <vic.dejuan@estudiante.uam.es>  
 */ 
public class Apartado4
{ 
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
		
		// Imprimir la distancia desde cada punto al primero
		boolean consecutive = false;
		double max = 0;
		double sum = 0;
		for (int i = 0; i < nmrPuntos - 1; i++)
		{
			Punto a = puntos[i];
			Punto b = puntos[i + 1];

			double dist = a.distancia(b);
			sum += dist;

			System.out.println("Distancia desde " + a + " a " + b + ": " + dist);
			max = Math.max(dist, max);

			if(a.iguales(b))
				consecutive = true;
		}

		System.out.println("Distancia total: " + sum);
		System.out.println("Distancia parcial máxima: " + max);
		
		if(consecutive)
			System.out.println("Se encontraron puntos contiguos duplicados");
	}
}
