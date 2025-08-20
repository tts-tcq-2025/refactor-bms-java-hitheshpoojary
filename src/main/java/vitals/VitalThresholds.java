package vitals;

final class VitalThresholds {
    final float min;
    final float max;
    final float tolerance; // absolute margin = 1.5% of max

    private VitalThresholds(float min, float max, float tolerance) {
        this.min = min;
        this.max = max;
        this.tolerance = tolerance;
    }

    static VitalThresholds of(float min, float max) {
        return new VitalThresholds(min, max, 0.015f * max);
    }
}
