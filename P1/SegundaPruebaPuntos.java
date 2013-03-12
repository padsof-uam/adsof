/** 
 * Esta aplicación muestra por pantalla la distancia entre dos puntos  
 * 
 * @author Nombre Apellido <nombre.apellido@noexiste.org>  
 */ 
public class SegundaPruebaPuntos { 
  /** 
  * Método de arranque de la aplicación. 
  * <p> 
  * Este método imprime la distancia entre los dos puntos dados en la línea de comandos 
  * 
  * @param args Los argumentos de la línea de comando son las coordenadas de los dos puntos 
  */ 
  public static void main(String[] args) { 
    if (args.length != 4) {  // verifica el número correcto de argumentos
      System.out.println("Se esperan al menos 4 argumentos."); 
      return; 
    } 

    // parseInt falla si el argumento no es un número.    
    Punto a = new Punto(Integer.parseInt(args[0]), Integer.parseInt(args[1])); // crear punto a
    Punto b = new Punto(Integer.parseInt(args[2]), Integer.parseInt(args[3])); // crear punto b
    
    System.out.println("Distancia a-b es: " + a.distancia(b)); // imprimir distancia a_b 
  }
}

