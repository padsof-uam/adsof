package menuPert.proyector;

import java.util.ArrayList;

/**
 * Clase que contiene todos los datos de una tarea.
 * 
 * @author Guillermo Juli??n Moreno
 * @author V??ctor de Juan Sanz
 * 
 */
public class Tarea
{
	private double				peso_optimista, peso_pesimista, peso_probable;
	private int					t_optimista, t_pesimista, t_probable;
	private String				nombre			= new String();
	private ArrayList<Tarea>	consecuentes	= new ArrayList<Tarea>();
	private ArrayList<Tarea>	antecedentes	= new ArrayList<Tarea>();

	/**
	 * Constructor.
	 * 
	 * @param t_op
	 *            Tiempo optimista.
	 * @param t_pes
	 *            Tiempo pesimista.
	 * @param t_prob
	 *            Tiempo m??s probable.
	 * @param nombre
	 *            Nombre de la tarea.
	 * @param peso_op
	 *            Peso optimista.
	 * @param peso_pes
	 *            Peso pesimista.
	 * @param peso_prob
	 *            Peso m??s probable.
	 */
	public Tarea(int t_op, int t_pes, int t_prob, String nombre,
			double peso_op, double peso_pes, double peso_prob)
	{
		peso_optimista = peso_op;
		peso_pesimista = peso_pes;
		peso_probable = peso_prob;
		t_optimista = t_op;
		t_pesimista = t_pes;
		t_probable = t_prob;
		this.nombre = nombre;
	}

	private int	duracionEstimada	= -1;
	private int	comienzoOptimista	= -1;
	private int	finOptimista		= -1;
	private int	comienzoPesimista	= -1;
	private int	finPesimista		= -1;

	/**
	 * Duraci??n estimada de la tarea. El c??lculo se hace la primera vez y se
	 * guarda para llamadas siguientes.
	 * 
	 * @return Duraci??n estimada.
	 */
	public int getDuracionEstimada()
	{
		if (duracionEstimada == -1)
			calculaDuracionEstimada();

		return duracionEstimada;
	}

	/**
	 * Calcula la duraci??n estimada de una tarea y la guarda.
	 */
	private void calculaDuracionEstimada()
	{
		duracionEstimada = (int) Math.round((peso_optimista * t_optimista
				+ peso_probable * t_probable + peso_pesimista * t_pesimista)
				/ (peso_pesimista + peso_optimista + peso_probable));
	}

	/**
	 * Comienzo optimista de la tarea. El c??lculo se hace la primera vez y se
	 * guarda para llamadas siguientes.
	 * 
	 * @return Comienzo optimista.
	 */
	public int getComienzoOptimista()
	{
		if (comienzoOptimista == -1)
			calculaComienzoOptimista();

		return comienzoOptimista;
	}

	/**
	 * Calcula el comienzo optimista de la tarea y lo guarda.
	 */
	private void calculaComienzoOptimista()
	{
		int max = 0;
		for (Tarea t : antecedentes)
			if (t.getFinOptimista() > max)
				max = t.getFinOptimista();

		comienzoOptimista = max;
	}

	/**
	 * Fin optimista de la tarea. El c??lculo se hace la primera vez y se guarda
	 * para llamadas siguientes.
	 * 
	 * @return Comienzo optimista.
	 */
	public int getFinOptimista()
	{
		if (finOptimista == -1)
			calculaFinOptimista();
		return finOptimista;
	}

	/**
	 * Calcula el fin optimista de la tarea.
	 */
	private void calculaFinOptimista()
	{
		finOptimista = getComienzoOptimista() + getDuracionEstimada();
	}

	/**
	 * Obtiene el comienzo pesimista de la tarea. El c??lculo se hace la primera
	 * vez y se guarda para llamadas siguientes.
	 * 
	 * @return Comienzo pesimista.
	 */
	public int getComienzoPesimista()
	{
		if (comienzoPesimista == -1)
			calculaComienzoPesimista();

		return comienzoPesimista;
	}

	/**
	 * Calcula el comienzo pesimista de la tarea y lo guarda.
	 */
	public void calculaComienzoPesimista()
	{
		comienzoPesimista = getFinPesimista() - getDuracionEstimada();
	}

	/**
	 * Fin pesimista de la tarea. El c??lculo se hace la primera vez y se guarda
	 * para llamadas siguientes.
	 * 
	 * @return Fin pesimista
	 */
	public int getFinPesimista()
	{
		if (finPesimista == -1)
			calculaFinPesimista();

		return finPesimista;
	}

	/**
	 * Calcula el fin pesimista de la tarea.
	 */
	public void calculaFinPesimista()
	{
		int min = Integer.MAX_VALUE;
		for (Tarea aux : consecuentes)
			if (min > aux.getComienzoPesimista())
				min = aux.getComienzoPesimista();

		finPesimista = min;

	}

	/**
	 * Peso optimista de la tarea.
	 */
	public double getPeso_optimista()
	{
		return peso_optimista;
	}

	/**
	 * Peso pesimista de la tarea.
	 */
	public double getPeso_pesimista()
	{
		return peso_pesimista;
	}

	/**
	 * Peso m??s probable de la tarea.
	 */
	public double getPeso_probable()
	{
		return peso_probable;
	}

	/**
	 * A??ade una tarea a la lista de consecuentes.
	 * 
	 * @param consecuente
	 *            Tarea.
	 */
	public void anadirTareaConsecuente(Tarea consecuente)
	{
		consecuentes.add(consecuente);
	}

	/**
	 * A??ade una tarea a la lista de antecedentes.
	 * 
	 * @param antecedente
	 *            Tarea.
	 */
	public void anadirTareaAntecedente(Tarea antecedente)
	{
		antecedentes.add(antecedente);
	}

	/**
	 * Obtiene las tareas antecendes
	 */
	public ArrayList<Tarea> getAntecedentes()
	{
		return antecedentes;
	}

	/**
	 * Obtiene las tareas consecuentes.
	 */
	public ArrayList<Tarea> getConsecuentes()
	{
		return consecuentes;
	}

	/**
	 * Tiempo optimista de la tarea.
	 */
	public int getT_optimista()
	{
		return t_optimista;
	}

	/**
	 * Tiempo pesimista de la tarea.
	 */
	public int getT_pesimista()
	{
		return t_pesimista;
	}

	/**
	 * Tiempo probable de la tarea.
	 */
	public int getT_probable()
	{
		return t_probable;
	}

	/**
	 * Nombre de la tarea.
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Devuelve el valor de holgura de la tarea.
	 * 
	 * @return Holgura de la tarea.
	 */
	public int getHolgura()
	{
		return getComienzoPesimista() - getComienzoOptimista();
	}

	public void eliminarConsecuente(Tarea task) {
		consecuentes.remove(task);
		
	}

	public void eliminarPrecedente(Tarea task) {
		// TODO Auto-generated method stub
		
	}
}
