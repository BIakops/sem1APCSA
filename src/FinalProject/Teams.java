package FinalProject;

public class Teams {
    private String teamName;
    private Players[] playerZ;
    // private String coach;
    public int wins = 0;
    private int loss = 0;
    private static int teamsInPlay = 0;
    private double avgCombatScore = 0;
    private double avgKD = 0;

    public Teams(String n, Players[] p) {
        teamName = n;
        playerZ = p;
        // coach = c;
        teamsInPlay++;
    }

    public Teams(String n, String[] pN) {
        teamName = n;
        teamsInPlay++;
        Players p1 = new Players(pN[0]);
        Players p2 = new Players(pN[1]);
        Players p3 = new Players(pN[2]);
        Players p4 = new Players(pN[3]);
        Players p5 = new Players(pN[4]);
        Players[] arr = { p1, p2, p3, p4, p5 };
        playerZ = arr;
    }

    public void matchWin(Teams b, int[][] scores, int[][] scorel) {
        wins++;
        b.loss++;
        iPlayer(scores);
        b.iPlayer(scorel);

    }

    public void iPlayer(int[][] scores) {
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < playerZ.length; j++)
                if (scores[i][0] == playerZ[i].getId()) {
                    int[] as = { scores[i][1], scores[i][2], scores[i][3] };
                    playerZ[i].addMatch(as);
                    break;
                }
        }
    }

    public static int teamsInPlay() {
        return teamsInPlay;
    }

    public String playerS() {
        String a = "";
        for (int i = 0; i < playerZ.length; i++) {
            a += playerZ[i] + "\n";
        }
        return a;
    }

    public double winLoss() {
        return (double) wins / (double) loss;
    }

    public String name() {
        return teamName;
    }

    public double avgCS() {
        for (int j = 0; j < playerZ.length; j++) {
            avgCombatScore += playerZ[j].cs();
        }
        avgCombatScore /= playerZ.length;
        return avgCombatScore;
    }

    public double avgKD() {
        for (int j = 0; j < playerZ.length; j++) {
            avgKD += playerZ[j].kda();
        }
        avgKD /= playerZ.length;
        return avgKD;
    }

    public void setWin(int i) {
        wins += i;
    }

    public String toString() {

        return name();
    }

    public Players[] reP() {
        return playerZ;
    }

    public int[] tPId() {

        int[] a = { playerZ[0].getId(), playerZ[1].getId(), playerZ[2].getId(), playerZ[3].getId(),
                playerZ[4].getId() };
        return a;
    }

}
