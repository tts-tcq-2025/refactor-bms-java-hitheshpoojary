package vitals;
import vitals.Compute;

public abstract class VitalsChecker {
  private enum Vital { TEMPERATURE, PULSE, SPO2 }    

  private static final Map<Vital, Map<Compute.Status, String>> MESSAGES;
      static {
          EnumMap<Vital, Map<Compute.Status, String>> m = new EnumMap<>(Vital.class);
  
          EnumMap<Compute.Status, String> temp = new EnumMap<>(Compute.Status.class);
          temp.put(Compute.Status.BELOW_MIN, "Temperature is critical (hypothermia)!");
          temp.put(Compute.Status.NEAR_MIN,  "Warning: Approaching hypothermia");
          temp.put(Compute.Status.NEAR_MAX,  "Warning: Approaching hyperthermia");
          temp.put(Compute.Status.ABOVE_MAX, "Temperature is critical (hyperthermia)!");
          m.put(Vital.TEMPERATURE, Collections.unmodifiableMap(temp));
  
          EnumMap<Compute.Status, String> pulse = new EnumMap<>(Compute.Status.class);
          pulse.put(Compute.Status.BELOW_MIN, "Pulse rate is critical (bradycardia)!");
          pulse.put(Compute.Status.NEAR_MIN,  "Warning: Approaching bradycardia");
          pulse.put(Compute.Status.NEAR_MAX,  "Warning: Approaching tachycardia");
          pulse.put(Compute.Status.ABOVE_MAX, "Pulse rate is critical (tachycardia)!");
          m.put(Vital.PULSE, Collections.unmodifiableMap(pulse));
  
          EnumMap<Compute.Status, String> spo2 = new EnumMap<>(Compute.Status.class);
          spo2.put(Compute.Status.BELOW_MIN, "Oxygen saturation is critical (hypoxia)!");
          spo2.put(Compute.Status.NEAR_MIN,  "Warning: Approaching low oxygen saturation");
          spo2.put(Compute.Status.NEAR_MAX,  "Warning: Approaching high oxygen saturation");
          spo2.put(Compute.Status.ABOVE_MAX, "Oxygen saturation reading is out of valid range!");
          m.put(Vital.SPO2, Collections.unmodifiableMap(spo2));
  
          MESSAGES = Collections.unmodifiableMap(m);
    }
  
    static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
        boolean ok = true;

        ok &= handle(Vital.TEMPERATURE, Compute.tempStatus(temperature));
        ok &= handle(Vital.PULSE,       Compute.pulseStatus(pulseRate));
        ok &= handle(Vital.SPO2,        Compute.spo2Status(spo2));

        return ok;
    }

    private static boolean handle(Vital vital, Compute.Status status) throws InterruptedException {
        String msg = messageFor(vital, status);
        if (msg != null) {
            alert(msg);
        }
        // Only critical (below/above) fails overall check
        return !(status == Compute.Status.BELOW_MIN || status == Compute.Status.ABOVE_MAX);
    }

    private static String messageFor(Vital vital, Compute.Status status) {
        Map<Compute.Status, String> table = MESSAGES.get(vital);
        return (table != null) ? table.get(status) : null;
    }

    // Provided in your original code; kept as-is
    static void alert(String message) throws InterruptedException {
        System.out.println(message);
    }
}
