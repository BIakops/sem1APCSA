
public class smth {
    static int problemsDone = 10;
    static float probDiff = 2.0f;
    static float dumb = 23.123912089129301824610239f;
    static float cool = 1.2975012760259895720482942492f;
    private int problemsId = 0;

    public smth(float diff, int Id) {
        // probDiff[] = diff;
        problemsId = Id;
        problemsDone++;

    }

    public int call() {
        return problemsId;
    }

    public static float urMom() {
        double a = Math.pow((double) probDiff + Math.random() * 20f, (problemsDone));
        return (float) ((a - problemsDone) / a);
    }

    public static float randU() {
        float i = urMom();
        float b = (float) (dumb * ((Math.random() * cool)));
        return i / b;
    }
}
