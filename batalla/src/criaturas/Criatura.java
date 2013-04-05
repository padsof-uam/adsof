/**
 * 
 */
package criaturas;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Guillermo Julián Moreno - Víctor de Juan Sanz
 *
 */
public abstract class Criatura {
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int heridas;
	protected double prob_curar;
	protected TipoEjercito tipo;
	
	
	public Criatura (int ataque, int defensa, int vida, int heridas, double prob_curar){
		this.ataque = ataque;
		this.defensa = defensa;
		this.heridas = heridas;
		this.vida = vida;
		this.prob_curar = prob_curar;
	}
	
	/**
	 * @return la probabilidad de curar
	 */
	public double getProb_curar(){
		return prob_curar;
	}
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
	public boolean estaMuerto(){
		return (this.vida == 0);
	}
	
	/**
	 * Ataca a un oponente.
	 * @param oponente
	 */
	public void atacar(Criatura oponente){
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		//El valor del rnextInt va entre 0 (incluido) y 6 sin incluir
		int dadoAtaque = 1+r.nextInt(6);
		int dadoDefensa = 1+r.nextInt(6);

		if ((dadoAtaque+this.ataque) > (dadoDefensa+oponente.defensa))
			oponente.addHeridas(1);
	}
	
	/**
	 * Algunas criaturas pueden recuperarse de algunas heridas.
	 */
	public void curarHeridas(){
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		//TODO: r.nextDouble puede dar valores negativos?
		if(r.nextDouble() <= this.prob_curar)
			this.heridas = 0;
	}
	
	/**
	 * Añade heridas a la criatura.
	 * @param numeroHeridas
	 */
	public void addHeridas(int numeroHeridas){
		this.heridas += numeroHeridas;
	}
	
	/**
	 * Aplica las heridas.
	 */
	public void aplicarHeridas(){
		this.vida -= this.heridas;
		this.heridas = 0;
	}
	
	public String toString(){
		//TODO:
		return "ll";
	}
}
