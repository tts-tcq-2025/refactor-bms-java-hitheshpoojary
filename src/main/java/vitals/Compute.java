package vitals;

public class Compute{
    static final float MAX_PULSE_RATE = 100;
    static final float MIN_PULSE_RATE = 60;
    static final float MIN_SPO2 = 90;
    static final float MAX_TEMP = 102;
    static final float MIN_TEMP = 95;

   public static boolean checkTemperature(float temperature) {
        return temperature > MAX_TEMP || temperature < MIN_TEMP;
    }

    public static boolean checkPulseRate(float pulseRate) {
        return pulseRate < MIN_PULSE_RATE || pulseRate > MAX_PULSE_RATE;
    }

    public static boolean checkSpo2(float spo2) {
        return spo2 < MIN_SPO2;
    }
}
