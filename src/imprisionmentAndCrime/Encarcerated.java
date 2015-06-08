/**
 * 
 */
package imprisionmentAndCrime;

import java.util.Random;

/**
 * @author andrecampos
 *
 */
public class Encarcerated extends Offender {

	/**
	 * Random variable used to generate the normal distribution responsible to calculate the 
	 * time in prison
	 */
	private static final Random r = new Random();
	private static double averageTimeInPrison; 			// years
	private static double standardTimeDeviationTimeInPrison;
	private double timeInPrison;
	
	public Encarcerated(Offender fromOffender) { 
		super(fromOffender);
		timeInPrison = nextTimeInPrison();
	}
	
	private double nextTimeInPrison() {
		return r.nextGaussian() * 
				standardTimeDeviationTimeInPrison + 
				averageTimeInPrison;
	}
	
	public static void setAvgTimeInPrison(double value) {
		averageTimeInPrison = value;
	}

	public static void setStdDeviationForTimeInPrison(double value) {
		standardTimeDeviationTimeInPrison = value;
	}
}
