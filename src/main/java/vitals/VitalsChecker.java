package vitals;
import vitals.Compute;

public abstract class VitalsChecker {

    static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
        boolean ok = true;

        ok &= handle(VitalsMessages.Vital.TEMPERATURE, Compute.tempStatus(temperature));
        ok &= handle(VitalsMessages.Vital.PULSE,       Compute.pulseStatus(pulseRate));
        ok &= handle(VitalsMessages.Vital.SPO2,        Compute.spo2Status(spo2));

        return ok;
    }

    private static boolean handle(VitalsMessages.Vital vital, Compute.Status status) throws InterruptedException {
        String msg = VitalsMessages.getMessage(vital, status);
        if (msg != null) {
            alert(msg);
        }
        // Only critical (below/above) fails overall check
        return !(status == Compute.Status.BELOW_MIN || status == Compute.Status.ABOVE_MAX);
    }

    static void alert(String message) throws InterruptedException {
        System.out.println(message);
    }
}
