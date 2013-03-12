package proyector;

/**
 * Tarea inicial. Sobreescribimos sólo el método de duración estimada, no hace
 * falta sobreescribir el resto: ya devuelven el valor especificado para una
 * tarea final al pasar todos los parámetros de tiempo como 0.
 * 
 * @author Víctor de Juan Sanz
 * @author Guillermo Julián Moreno
 */
public class TareaInicio extends Tarea
{
	/**
	 * Constructor.
	 */
	public TareaInicio()
	{
		super(0, 0, 0, "Inicio", 0, 0, 0);
	}

	/*
	 * Duración estimada de la tarea. Al ser tarea inicial es siempre 0.
	 * 
	 * @see proyector.Tarea#getDuracionEstimada()
	 */
	@Override
	public int getDuracionEstimada()
	{
		return 0;
	}
}
