package es.uam.padsof.batalla5ejercitos;

import java.util.*;

public class RandomUtils {
	private static Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
	
	/**
	 * Generate a random number between lower and upper, inclusive both.
	 * @param lower Lower limit.
	 * @param upper Upper limit.
	 * @return Random number.
	 */
	public static int randBetween(int lower, int upper)
	{
		return rnd.nextInt(upper - lower + 1) + lower;
	}
}
