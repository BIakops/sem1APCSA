package FinalProject;

import java.util.ArrayList;

public class Tournament {
    ///
    protected Leaderboard MVP = new Leaderboard("Players");
    private static int numTourn = 0;
    private int teamsPlaying = 0;
    private Teams[] teams;
    protected ArrayList<Teams[]> bracket = new ArrayList<>();
    //// private String[] aRO = { "Used Exploit", "Cheating", "Match-Fixing",
    //// "Against TOS", "Ruling over cases" };

    public Tournament(int numberOfTeams, Teams[] t) {
        teamsPlaying = numberOfTeams;
        teams = t;
        if (teamsPlaying == t.length) {
            for (int i = 0; i < teams.length; i += 2) {
                Teams[] a = { teams[i], teams[i + 1] };
                bracket.add(a);
            }
            for (int i = 0; i < t.length; i++) {
                MVP.addPlayers(t[i].reP());
            }
        } else {
            throw new IllegalArgumentException("num of teams != to teams provided!");
        }
        //// System.out.println("bracket is set " + teamInPlay);
    }

    public ArrayList<Integer> convertIntTArr(int[] i) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for (int j = 0; j < i.length; j++) {
            newArr.add(i[j]);
        }
        return newArr;
    }

    public void addMatch(int[][] pscorew, int[][] pscorel, int[] mscore, int bracketID) {
        if (mscore[0] > mscore[1]) {
            bracket.get(bracketID)[0].matchWin(bracket.get(bracketID)[1], pscorew, pscorel);
        } else {
            bracket.get(bracketID)[1].matchWin(bracket.get(bracketID)[0], pscorew, pscorel);
        }

    }

    public String lB() {
        return MVP.printLeaderBoard();
    }

    public static int TourneyInPLay() {
        return numTourn;
    }

    public String rBracket() {
        String s = "";
        for (int i = 0; i < bracket.size(); i++) {
            s += bracket.get(i)[0].toString() + "\n";
        }
        return s;
    }

    public void bracket() {
        ArrayList<Teams> tempArr = new ArrayList<>();

        for (int i = 0; i < bracket.size(); i++) {
            /// System.out.println(temp.size());
            if (bracket.get(i)[0].wins < bracket.get(i)[1].wins) {
                tempArr.add(bracket.get(i)[1]);
                /// System.out.println("Condtion a");
                /// System.out.println(tempArr.get(0).name());
            } else {
                tempArr.add(bracket.get(i)[0]);
                /// System.out.println("Condition b");
            }
        }
        bracket.clear();
        for (int i = 0; i < tempArr.size(); i += 2) {
            if (tempArr.size() <= 1) {
                bracket.add(new Teams[] { tempArr.get(0) });
                winner();
                return;
            }
            bracket.add(new Teams[] { tempArr.get(i), tempArr.get(i + 1) });
            System.out.println(bracket.get(bracket.size() - 1));

        }

    }

    public String troubleShoot() {
        String a = "";

        return a;
    }

    public void simulateMatch() {

        for (int i = 0; i < bracket.size(); i++) {
            int a = (int) (Math.random() * 2);
            int[] ids = bracket.get(i)[0].tPId();
            int[] idp = bracket.get(i)[1].tPId();
            int[][] pscorea = new int[5][4];
            int[][] pscoreb = new int[5][4];
            for (int j = 0; j < pscoreb.length; j++) {
                for (int k = 0; k < pscorea[i].length; k++) {
                    pscorea[i][0] = ids[j];
                    for (int k2 = 1; k2 < pscorea[i].length; k2++) {
                        pscorea[i][k2] = (int) (Math.random() * (Math.random() * 30));
                    }
                }
            }
            for (int j = 0; j < pscoreb.length; j++) {
                for (int k = 0; k < pscorea[i].length; k++) {
                    pscoreb[i][0] = idp[j];
                    for (int k2 = 1; k2 < pscorea[i].length; k2++) {
                        pscoreb[i][k2] = (int) (Math.random() * (Math.random() * 30));
                    }
                }
            }
            int[] z = { 1, 0 };
            if (a == 1)
                addMatch(pscorea, pscoreb, z, 1);
            else
                addMatch(pscorea, pscoreb, z, 0);

        }
        bracket();
        MVP.arrL();
    }

    public void winner() {
        MVP.arrL();
        MVP.printLeaderBoard();
    }

    public String MVP() {
        return MVP.printLeaderBoard();
    }
}
