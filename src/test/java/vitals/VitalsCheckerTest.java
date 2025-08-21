package vitals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VitalsCheckerTest {

@Test
    void temperature_belowMin_is_critical() throws Exception {
        assertFalse(VitalsChecker.vitalsOk(94.9f, 80f, 95f));
        assertEquals(Compute.Status.BELOW_MIN, Compute.tempStatus(94.9f));
    }

    @Test
    void temperature_nearHypo_warns_but_ok() throws Exception {
        assertTrue(VitalsChecker.vitalsOk(95.5f, 80f, 95f));
        assertEquals(Compute.Status.NEAR_MIN, Compute.tempStatus(95.5f));
    }

    @Test
    void temperature_normal_ok() throws Exception {
        assertTrue(VitalsChecker.vitalsOk(98.0f, 80f, 95f));
        assertEquals(Compute.Status.NORMAL, Compute.tempStatus(98.0f));
    }

    @Test
    void temperature_nearHyper_warns_but_ok() throws Exception {
        assertTrue(VitalsChecker.vitalsOk(101.0f, 80f, 95f));
        assertEquals(Compute.Status.NEAR_MAX, Compute.tempStatus(101.0f));
    }

    @Test
    void temperature_aboveMax_is_critical() throws Exception {
        assertFalse(VitalsChecker.vitalsOk(102.1f, 80f, 95f));
        assertEquals(Compute.Status.ABOVE_MAX, Compute.tempStatus(102.1f));
    }
 @Test
    void pulse_warning_and_critical() throws Exception {
        assertTrue(VitalsChecker.vitalsOk(98f, 61.0f, 95f));   // NEAR_MIN
        assertEquals(Compute.Status.NEAR_MIN, Compute.pulseStatus(61.0f));

        assertFalse(VitalsChecker.vitalsOk(98f, 101f, 95f));   // ABOVE_MAX
        assertEquals(Compute.Status.ABOVE_MAX, Compute.pulseStatus(101f));
    }

    @Test
    void spo2_warning_and_critical() throws Exception {
        assertTrue(VitalsChecker.vitalsOk(98f, 80f, 91.0f));   // NEAR_MIN
        assertEquals(Compute.Status.NEAR_MIN, Compute.spo2Status(91.0f));

        assertFalse(VitalsChecker.vitalsOk(98f, 80f, 89.0f));   // BELOW_MIN
        assertEquals(Compute.Status.BELOW_MIN, Compute.spo2Status(89.0f));
    }
   

}


