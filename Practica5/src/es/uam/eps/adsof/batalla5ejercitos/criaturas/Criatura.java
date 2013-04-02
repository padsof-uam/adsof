/**
 * 
 */
package es.uam.eps.adsof.batalla5ejercitos.criaturas;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 *
 */
public abstract class Criatura {
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int heridas;
	protected TipoEjercito tipo;
	
	/**
	 * @return el tipo
	 */
	public TipoEjercito getTipo() {
		return tipo;
	}
	/**
	 * @return la vida
	 */
	public int getVida() {
		return vida;
	}
	/**
	 * @return el ataque
	 */
	public int getAtaque() {
		return ataque;
	}
	/**
	 * @return la defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * @return las heridas
	 */
	public int getHeridas() {
		return heridas;
	}
	
	/**
	 * Indica si la criatura está muerta o no.
	 * @return
	 */
	public abstract boolean estaMuerto();
	
	/**
	 * Ataca a un oponente.
	 * @param oponente
	 */
	public abstract void atacar(Criatura oponente);
	
	/**
	 * Añade heridas a la criatura.
	 * @param numeroHeridas
	 */
	public abstract void addHeridas(int numeroHeridas);
	
	/**
	 * Aplica las heridas.
	 */
	public abstract void aplicarHeridas();
}
