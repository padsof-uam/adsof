package menuPert.proyector;

/**
 * Subclase de Tarea que representa la tarea final de un proyecto.
 * 
 * @author V??ctor de Juan Sanz
 * @author Guillermo Juli??n Moreno
 * 
 */
public class TareaFinal extends Tarea
{
	/**
	 * Constructor
	 */
	public TareaFinal()
	{
		super(0, 0, 0, "Fin", 0, 0, 0);
	}

	/*
	 * Obtiene la duraci??n estimada de la tarea. Al ser tarea final es siempre
	 * 0.
	 * 
	 * @see proyector.Tarea#getDuracionEstimada()
	 */
	@Override
	public int getDuracionEstimada()
	{
		return 0;
	}

	/*
	 * Obtiene el comienzo pesimista de la tarea.
	 * 
	 * @see proyector.Tarea#getComienzoPesimista()
	 */
	@Override
	public int getComienzoPesimista()
	{
		return this.getComienzoOptimista();
	}

	/*
	 * Obtiene el fin pesimista de la tarea.
	 * 
	 * @see proyector.Tarea#getFinPesimista()
	 */
	@Override
	public int getFinPesimista()
	{
		return this.getComienzoOptimista();
	}
}
