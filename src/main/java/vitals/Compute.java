package vitals;

/**
 * Utility class for computing and validating vital signs.
 */
public final class Compute {

    // Prevent instantiation
    private Compute() {}

    public static final float MAX_PULSE_RATE = 100;
    public static final float MIN_PULSE_RATE = 60;
    public static final float MIN_SPO2 = 90;
    public static final float MAX_TEMP = 102;
    public static final float MIN_TEMP = 95;

    private static boolean isOutOfRange(float value, float min, float max) {
        return value < min || value > max;
    }

    /**
     * Validates if temperature is out of safe range.
     * @param temperature in Fahrenheit
     * @return true if out of range
     */
    public static boolean checkTemperature(float temperature) {
        return isOutOfRange(temperature, MIN_TEMP, MAX_TEMP);
    }

    /**
     * Validates if pulse rate is out of safe range.
     * @param pulseRate in BPM
     * @return true if out of range
     */
    public static boolean checkPulseRate(float pulseRate) {
        return isOutOfRange(pulseRate, MIN_PULSE_RATE, MAX_PULSE_RATE);
    }

    /**
     * Validates if SpO2 is below minimum threshold.
     * @param spo2 oxygen saturation in percentage
     * @return true if below safe level
     */
    public static boolean checkSpo2(float spo2) {
        return spo2 < MIN_SPO2;
    }
}
