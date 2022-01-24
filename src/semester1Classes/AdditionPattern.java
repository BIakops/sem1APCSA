package semester1Classes;

public class AdditionPattern {
    private static int start = 0;
    private int interval;
    private int cur;

    public AdditionPattern(int s, int i) {
        start = s;
        interval = i;
        cur = start;
    }

    public void prev() {
        if (!(cur - interval <= start)) { // almost missed = sign in thing.
            cur -= interval;
        }
    }

    public void next() {
        cur += interval;

    }

    public int currentNumber() {
        return cur;
    }

    public static void changeStart(int s) {
        start = s;
    }
    // Score if Summative 9/9 [A+]
}
