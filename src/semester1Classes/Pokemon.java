package semester1Classes;

public class Pokemon {
    private static int numPoke = 0;
    private int HP;
    private int level;
    private String name;

    private String moveName;
    private int movePower;
    private int id;

    private static String[][] pokeDex = { { "Pikachu", "Electric" }, { "Charizard", "Fire " }, { "Evee", "Normal" },
            { "Bulbarsaur", "Nature" }, { "Vapreon", "Water" }, { "test", "Steel" }

    };

    // private static String[][] typeAdv = {}
    public Pokemon(String n, int lvl, int h, String mN, int p) {

        boolean isReal = false;
        for (int i = 0; i < pokeDex.length; i++) {
            if (n.equals(pokeDex[i][0])) {
                isReal = true;
                id = i;
            }
        }
        if (isReal) {
            name = n;
            level = lvl;
            HP = h;
            moveName = mN;
            movePower = p;
            numPoke++;
        } else {
            throw new IllegalArgumentException("Doesnt Exist in pokedex");
        }
    }

    public Pokemon() {
        name = "unknown";
        level = 1;
        HP = 10;
        moveName = "Hidden Power";
        movePower = 2;
        numPoke++;
    }

    public static int getNumPokemon() {
        return numPoke;
    }

    public int getHP() {
        return HP;
    }

    public String toString() {
        return name + " -- lvl " + level + " -- HP " + HP + " -- " + moveName;
    }

    public String attack(Pokemon enemy) {
        boolean isHit = ((int) (Math.random() * 9) + 1 > 3);
        String a = "";
        if (isHit) {
            a += name + "attacks with " + moveName + "!";
            enemy.HP -= movePower;
            a += "\n" + enemy.name + "'s HP is now at" + HP;
            if (enemy.HP <= 0) {
                a += " " + enemy.name + "has fainted... ";
            }
        } else {
            a += name + moveName + " missed";
        }
        a += toString() + "\n" + enemy.toString();

        return a;
    }

    public static String pokemonAdv(Pokemon myPoke) {
        String a = "";
        String type = Pokemon.pokeDex[myPoke.id][1];
        if (type.equals("Steel")) {
            a += "Strong Against: Rock, Ice, Fairy. \n Weak Against: Steel, Fire, Water, Electric ";
        }
        return a;
    }
}
