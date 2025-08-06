package vitals;

public final class Compute {

    private Compute() {}

    static final float MAX_PULSE_RATE = 100;
    static final float MIN_PULSE_RATE = 60;
    static final float MIN_SPO2 = 90;
    static final float MAX_TEMP = 102;
    static final float MIN_TEMP = 95;

    private static boolean isOutOfRange(float value, float min, float max) {
        return value < min || value > max;
    }
    
   public static boolean checkTemperature(float temperature) {
        return isOutOfRange(temperature,MIN_TEMP,MAX_TEMP) ;
    }

    public static boolean checkPulseRate(float pulseRate) {
        return isOutOfRange(pulseRate,MIN_PULSE_RATE,MIN_PULSE_RATE) ;
    }

    public static boolean checkSpo2(float spo2) {
        return  spo2<MIN_SPO2;
    }
}
