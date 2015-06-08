/**
 * 
 */
package imprisionmentAndCrime;

import repast.simphony.context.Context;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;


/**
 * I = (P(I)*S)*(N*\lambda) - Size of incarcerated population
 * I - Incarcerated population
 * 
 * S - Average time served in prison
 * P(I) - probability of imprisonment for committing a crime 
 * 
 * N - Number of offenders 
 * λ - average rate of offending. 
 * 
 * N - Number of offenders by the second time
 * λ2 - average rate of offending by the second time.
 * 
 * (P(I)*S) - Expected prison price per crime committed
 * (N*λ) - Total number of crimes committed
 * 
 * @author andreloc@gmail.com
 */
public class SimulationBuilder implements ContextBuilder<Object>{

	private static final String AVG_AGE = "average_age";
	private static final String STD_DEVIATION_AGE = "age_standard_deviation";
	
	private static final String AVG_TIME_IN_PRISON = "average_time_in_prison";
	private static final String STD_DEVIATION_FOR_TIME_IN_PRISON = "standard_deviation_for_time_in_prison";
	
	
	
	@Override
	public Context<Object> build(Context<Object> context) {
		context.setId("Prison Simulation");
		Parameters parameters = RunEnvironment.getInstance().getParameters();
		
		Offender.setAvgAge(parameters.getInteger(AVG_AGE));
		Offender.setStandardDeviationOfPopulationAge(parameters.getInteger(STD_DEVIATION_AGE));
		Encarcerated.setAvgTimeInPrison(parameters.getInteger(AVG_TIME_IN_PRISON));
		Encarcerated.setStdDeviationForTimeInPrison(parameters.getInteger(STD_DEVIATION_FOR_TIME_IN_PRISON));
		
		return context;
	}
}
