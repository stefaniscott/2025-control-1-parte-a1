package es.upm.grise.profundizacion.cruiseControl;

import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		
		this.speedometer = speedometer;
		speedSet = null;
		speedLimit = null; 

	}
	
	/*
	 * Method to code
	 */
	public void setSpeedSet(int speedSet) throws IncorrectSpeedLimitException, SpeedSetAboveSpeedLimitException {
		//velocidad a mantener proporcionada por user
		
		if (speedSet > 0 ){
			if (speedLimit != null && speedSet < speedLimit){
				this.speedSet = speedSet;
			}else {
				throw new SpeedSetAboveSpeedLimitException("La velocidad no debe sobrepasar el límite de velocidad establecido.");
			}	
		}else{
			throw new IncorrectSpeedLimitException("La velocidad tiene que ser mayor que cero." );
		}
		
	}

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

}
