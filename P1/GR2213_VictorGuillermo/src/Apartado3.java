public class Apartado3 
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
		for (Punto p : puntos) 
			System.out.println("Distancia de " + p + " al primer punto: " + p.distancia(puntos[0]) ); 
	} 
}
