package vitals;

public final class Compute {
    
    public enum Status { BELOW_MIN, NEAR_MIN, NORMAL, NEAR_MAX, ABOVE_MAX }

    private Compute() {}

    public static final float MAX_PULSE_RATE = 100;
    public static final float MIN_PULSE_RATE = 60;
    public static final float MIN_SPO2 = 90;
    private static final float MAX_SPO2 = 100f;
    public static final float MAX_TEMP = 102;
    public static final float MIN_TEMP = 95;

    private static boolean isOutOfRange(float value, float min, float max) {
        return value < min || value > max;
    }

    public static boolean checkTemperature(float temperature) {
        return isOutOfRange(temperature, MIN_TEMP, MAX_TEMP);
    }

    public static boolean checkPulseRate(float pulseRate) {
        return isOutOfRange(pulseRate, MIN_PULSE_RATE, MAX_PULSE_RATE);
    }

    public static boolean checkSpo2(float spo2) {
        return spo2 < MIN_SPO2;
    }
}
