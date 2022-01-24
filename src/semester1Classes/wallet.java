package semester1Classes;

public class wallet {
    private int tMade = 0;
    private double tAmt = 0;
    private int maxAmt = 0;

    public wallet(int m) {
        if (m > 20) {
            System.out.println("Thats above your Budget!");
        } else {
            maxAmt = m;
        }
    }

    public double getTotalSpent() {
        return tAmt;
    }

    public void spent(double k) {
        if (k > maxAmt) {
            System.out.println("Total spending exceeded budget! Please talk to your parents.");
        } else {
            tAmt += k;
            tMade++;
        }
    }

    public double averageSpent() {
        if (tMade == 0 || tAmt == 0)
            // Original (if(tMade = 0 || tAmt = 0))
            return 0;
        else
            return tAmt / tMade;
    }

    public void anotherWallet(wallet k) {
        tAmt += k.tAmt;
        tMade += k.tMade;
        maxAmt += k.maxAmt;

    }
}
