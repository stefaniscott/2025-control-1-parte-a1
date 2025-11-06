package es.upm.grise.profunduzacion.cruiseController;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;

class CruiseControlTest {
	
    public CruiseControlTest(){
        private Speedometer spedo; 
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
   

    @Test
    public void testsetSpeedSet () throws IncorrectSpeedLimitException, SpeedSetAboveSpeedLimitException{
        Speedometer speedometer = new Speedometer(); 
        CruiseControl control = new CruiseControl (speedometer);
        control.setSpeedSet(15);
        assertEquals(15,control.getSpeedSet(),0.001);
    }

    @Test(expected = SpeedSetAboveSpeedLimitException.class)
    public void testIncorrectSpeed() throws IncorrectSpeedLimitException, SpeedSetAboveSpeedLimitException{
        CruiseControl control = new CruiseControl (speedometer);
        control.setSpeedLimit(20);
        control.setSpeedSet(25);
        exceptionRule.expect(SpeedSetAboveSpeedLimitException.class);
    }


    @Test(expected = Speen.class)
    public void testIncorrectSpeed() throws IncorrectSpeedLimitException, SpeedSetAboveSpeedLimitException{
        CruiseControl control = new CruiseControl (speedometer);
        control.setSpeedSet(0);
        exceptionRule.expect(IncorrectSpeedLimitException.class);
    }

   

  
}

