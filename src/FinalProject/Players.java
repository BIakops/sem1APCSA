package FinalProject;

import java.util.ArrayList;
import java.math.*;

///99% DONE
public class Players {
    private String name = "";
    private double KDA = 0;
    private int CombatScore = 0;
    private int Id = 0;
    private ArrayList<ArrayList<Integer>> matchScore = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> publicIDs = new ArrayList<Integer>();
    private double KD = 0;

    public Players(String n) {
        name = n;
        KDA = 0;
        CombatScore = 0;
        do {
            Id = 0;
            for (int i = 0; i < 5; i++) {
                Id += ((int) (Math.random() * 10)) * Math.pow(10, i);
            }
        } while (publicIDs.contains(Id));
        publicIDs.add(Id);
    }

    public static String printIds() {
        String a = "";
        for (int i = 0; i < publicIDs.size(); i++) {
            a += publicIDs.get(i) + "\n";
        }
        return a;
    }

    public void addMatch(int[] s) {
        if (s.length == 3) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < s.length; i++) {
                tempList.add(s[i]);
            }
            matchScore.add(tempList);

        }
        calcCombatScore();
    }

    public void calcCombatScore() {
        double k = 0;
        double d = 0;
        double a = 0;
        for (int i = 0; i < matchScore.size(); i++) {
            k += matchScore.get(i).get(0);
            d += matchScore.get(i).get(1);
            a += matchScore.get(i).get(2);
        }
        BigDecimal s3 = new BigDecimal((k + 0.60 * (a)) / (d)).setScale(2, RoundingMode.HALF_UP);
        KDA = s3.doubleValue();
        BigDecimal s2 = new BigDecimal(k / d).setScale(2, RoundingMode.HALF_UP);
        KD = s2.doubleValue();
        int az = 0;
        if (KDA > 1.5)
            az = 10;
        else {
            az = 5;
        }
        CombatScore = (int) Math.round((Math.abs(Math.pow((KDA - 0.1 * KD), 1.124))) * 100 + 2 * az);

    }

    public int cs() {
        return CombatScore;
    }

    public double kda() {
        return KDA;
    }

    public String name() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String toString() {
        if (KD > 0.5)
            return name + " has KD of " + KD + " and rating score of " + CombatScore;
        else
            return name + " is a noob,  here's their rating," + CombatScore;

    }
}
