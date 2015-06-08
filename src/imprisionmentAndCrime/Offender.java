/**
 * 
 */
package imprisionmentAndCrime;

import java.util.Random;

import repast.simphony.context.Context;
import repast.simphony.util.ContextUtils;

/**
 * @author andrecampos
 */
public abstract class Offender {

	private static final Random r = new Random();
	private static int initialCriminalAge;
	private static int averagePopulationAge;
	private static int standardDeviationOfPopulationAge;
	private int age;
	private int death;
	
	protected Offender() { 
		age = initialCriminalAge;
		death = calculateDeath();
	}
	
	protected Offender(Offender offender) { 
		age   = offender.age;
		death = offender.death; 
	}

	protected void aniversary() { 
		age++;
		if(age > death) {
			die();
		}
	}
	
	private void die() {
		Context<?> context = ContextUtils.getContext(this);
		context.remove(this);
	}

	/**
	 * Basically generates a death time for the agent based on its 
	 * @return
	 */
	private int calculateDeath() {
		return (int) (r.nextGaussian() *           // uniform distribution 
				standardDeviationOfPopulationAge + // standard deviation value in ages 
				averagePopulationAge);             // average population age
	}
	
	public final int getAge() { 
		return age;
	}
	
	public final int getDeathAge() { 
		return death;
	}
	
	public static void setAvgAge(int avgAge) { 
		averagePopulationAge = avgAge;
	}
	
	public static void setStandardDeviationOfPopulationAge(int stdDeviationOfPopulationAge) { 
		standardDeviationOfPopulationAge = stdDeviationOfPopulationAge;
	}
}
