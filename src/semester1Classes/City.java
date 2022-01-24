package semester1Classes;

public class City {
    private String myName;
    private String mySportsTeam;
    private int myPopulation;

    public City() {
        myName = null;
        myPopulation = 0;
        mySportsTeam = null;
    }

    public City(String n, String s, int p) {
        myName = n;
        myPopulation = p;
        mySportsTeam = s;
    }

    public void updateName(String n) {
        myName = n;
    }

    public void updateSport(String s) {
        mySportsTeam = s;
    }

    public void updateP(int p) {
        myPopulation = p;
    }

    public int urMom() {
        if (myName.equals(mySportsTeam))
            return myPopulation;
        else
            return 0;
    }

}
