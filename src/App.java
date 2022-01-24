
import FinalProject.*;

public class App {
    public static void main(String[] args) {
        /// <summary>
        /// SEMESTER 1 FINAL TEST CODE!
        /// </summary>
        /// COMMENTS
        Players a1 = new Players("urMom");
        Players a2 = new Players("urDad");
        Players a3 = new Players("urBro");
        Players a4 = new Players("urBad");
        Players a5 = new Players("urShit");
        Players[] az1 = { a1, a2, a3, a4, a5 };
        int[] z = { 25, 10, 0 };
        int[] j = { 5, 10, 5 };
        int[] ab = { 21, 17, 5 };
        int[] az = { 56, 23, 14 };
        int[] ac = { 16, 19, 7 };
        for (int i = 0; i < 100; i++) {

            a2.addMatch(j);
            a1.addMatch(z);
            a3.addMatch(ab);
            a4.addMatch(az);
            a5.addMatch(ac);
        }
        System.out.println(a2.cs()); /// EXPECTED 280
        System.out.println(a1.cs()); /// EXPECTED 91
        Leaderboard a123 = new Leaderboard("Players");
        a123.addPlayers(az1);
        a123.arrL();
        System.out.println(Leaderboard.acceptTypes());
        System.out.println(a123.printLeaderBoard());
        // for (int i = 0; i < 8; i++) {

        // }
        /// teams a = new teams("a", az1);
        Teams b = new Teams("b", az1);
        Teams c = new Teams("c", az1);
        Teams d = new Teams("deez Nuts", az1);
        String[] asd = { "Joe", "Mama", "DADA", "BAD", "urMOM" };
        Teams e = new Teams("urBads", asd);
        Teams[] a23 = { e, b, c, d };
        Tournament plsHelp = new Tournament(4, a23);
        e.setWin(2);
        b.setWin(1);
        c.setWin(3);
        d.setWin(4);
        plsHelp.bracket();
        System.out.println(plsHelp.rBracket());
        plsHelp.bracket();
        System.out.println(plsHelp.rBracket());

        /// Should give illegalArgumentException()

        /// Customer FRQ Test:
        // Customer.getNextAccNum();
        // Customer c1 = new Customer("Zuko");
        // Customer.getNextAccNum();
        // String s = c1.generateBill(20.00);
        // System.out.print(s);
        //
        // DiceRoller FRQ Quiz:
        // DiceRoller rolls = new DiceRoller(20);
        // for (int i = 0; i < 100; i++) {
        // if ((int) (Math.random() * 2) > 0) {
        // rolls.roll();
        // } else {
        // rolls.disadvantage();
        // }
        // System.out.println(rolls.sum());
        // }
        //
        // smth Class run thru
        // for (int i = 0; i < 100; i++) {
        // System.out.println(smth.randU());
        // }
        //
        // City Class FRQ
        // City city1 = new City();
        // City city2 = new City("Bob", "Bob", 10);
        // System.out.println("Hello, World!");
    }
}
