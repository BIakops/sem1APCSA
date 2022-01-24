package semester1Classes;
public class DiceRoller {
    private int rollN = 0;
    private int roll1 = 0;
    private int roll2 = 0;

    public DiceRoller(int n) {
        rollN = n;
    }

    public int sum() {
        return roll1 + roll2;
    }

    public int roll() {
        int r = (int) (Math.random() * rollN) + 1;
        roll2 = roll1;
        roll1 = r;
        return r;
    }

    public int disadvantage() {
        if (roll1 > roll2) {
            int r = roll2;
            roll2 = roll1;
            roll1 = r;
            return r;
        } else {
            roll2 = roll1;
            return roll1;
        }
    }
}
