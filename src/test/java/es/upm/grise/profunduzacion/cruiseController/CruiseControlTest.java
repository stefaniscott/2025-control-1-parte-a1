package es.upm.grise.profunduzacion.cruiseController;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;

public class CruiseControlTest {

    private Speedometer speedometer;
    private CruiseControl control;
	
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
   
    @Before
    public void inicializar(){
        speedometer = mock(Speedometer.class);
        control = new CruiseControl(speedometer);
    }

    @Test
    public void testsetSpeedSetCorrect () throws Exception{
        control.setSpeedSet(15);
        assertEquals(Integer.valueOf(15),control.getSpeedSet(),0.001);
    }

    @Test
    public void testSpeedSetAboveSpeedLimitException() throws Exception{
        control.setSpeedLimit(20);

        exceptionRule.expect(SpeedSetAboveSpeedLimitException.class);
        exceptionRule.expectMessage("La velocidad no debe sobrepasar el límite de velocidad establecido.");

        control.setSpeedSet(25);
    }


    @Test
    public void testIncorrectSpeedSetException() throws Exception{
        exceptionRule.expect(IncorrectSpeedSetException.class);
        exceptionRule.expectMessage("La velocidad tiene que ser mayor que cero.");

        control.setSpeedSet(0);
    }

   

  
}

