package menuConsola;

/**
 * Execution exception.
 * @author Guillermo Julián Moreno
 * @author Víctor de Juan Sanz
 *
 */
public class ExecutionException extends Exception {
	private static final long serialVersionUID = -2278935428734317884L;
	private String method;
	
	/**
	 * 
	 * @return the method causing the exception.
	 */
	public String getMethod() {
		return method;
	}


	public ExecutionException(String message, String method)
	{
		super(message);
		this.method = method;
	}
}
