package vitals;

public final class Compute {

    private Compute() {}

    // Thresholds
    public static final float MAX_PULSE_RATE = 100f;
    public static final float MIN_PULSE_RATE = 60f;

    public static final float MAX_TEMP = 102f;
    public static final float MIN_TEMP = 95f;

    public static final float MAX_SPO2 = 100f; // enables symmetric warning band
    public static final float MIN_SPO2 = 90f;

    private static final float TOLERANCE_PCT = 0.015f; // 1.5% of upper limit

    // Nested enum representing vital status
    public enum Status { BELOW_MIN, NEAR_MIN, NORMAL, NEAR_MAX, ABOVE_MAX }

    // Generic range evaluator for any vital
    private static Status evaluateRange(float value, float min, float max) {
        final float tol = max * TOLERANCE_PCT; // tolerance per README: 1.5% of max
        if (value < min) return Status.BELOW_MIN;
        if (value <= min + tol) return Status.NEAR_MIN;
        if (value > max) return Status.ABOVE_MAX;
        if (value >= max - tol) return Status.NEAR_MAX;
        return Status.NORMAL;
    }


    public static Status tempStatus(float temperature) {
        return evaluateRange(temperature, MIN_TEMP, MAX_TEMP);
    }

    public static Status pulseStatus(float pulseRate) {
        return evaluateRange(pulseRate, MIN_PULSE_RATE, MAX_PULSE_RATE);
    }

    public static Status spo2Status(float spo2) {
        return evaluateRange(spo2, MIN_SPO2, MAX_SPO2);
    }
}
