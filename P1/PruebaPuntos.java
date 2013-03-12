public class PruebaPuntos
{
	public static void main(String[] args)
	{
		Punto a = new Punto(3, -2);
		Punto b = new Punto(3, 0);

		System.out.println("Distancia a-b es: " + a.distancia(b));
	}
}
