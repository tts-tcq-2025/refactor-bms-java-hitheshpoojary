package vitals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VitalsCheckerTest {

   @Test
    void temperature_nearHypo_warns_but_ok() throws Exception {
        // Temp upper = 102 → tol = 1.53 → near-min = [95, 96.53]
        boolean ok = VitalsChecker.vitalsOk(95.50f, 80f, 95f);
        assertTrue(ok);
        // classification check
        assertEquals(Compute.Status.NEAR_MIN, Compute.tempStatus(95.50f));
    }

    @Test
    void temperature_belowMin_is_critical() throws Exception {
        assertFalse(VitalsChecker.vitalsOk(94.9f, 80f, 95f));
        assertEquals(Compute.Status.BELOW_MIN, Compute.tempStatus(94.9f));
    }

    @Test
    void temperature_nearHyper_warns_but_ok() throws Exception {
        // near-max = [100.47, 102]
        assertTrue(VitalsChecker.vitalsOk(101.0f, 80f, 95f));
        assertEquals(Compute.Status.NEAR_MAX, Compute.tempStatus(101.0f));
    }

}

