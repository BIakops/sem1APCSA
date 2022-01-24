package semester1Classes;

public class clothes {
    private String[] ty = /* new String */ { "Accessory", "Top", "bottom", "Costume" };
    // TLDR: DO NOT USE ARRAYS YET YOU SMART ASS!
    private static int numSold = 0;
    private double price = 0;
    private String Description = "";
    private String type = "";

    public clothes(String t, String d) {
        boolean isValid = false;
        for (int i = 0; i < ty.length; i++) {
            if (t.equals(ty[i]) && !ty[i].equals("costume")) {
                isValid = true;
            }
        }
        if (isValid) {
            type = t;
            Description = d;
            numSold++;
        }
    }

    public clothes(String t, String a, String b) {
        if (t.equals(ty[2])) {
            Description = a + "-" + b;
            type = t;
            numSold++;
        }
    }

    public static int getNumClothesSold() {
        return numSold;
    }

    public void setPrice(double k) {
        if (!type.equals(ty[2])) {
            price = k;
        }
    }

    public void setPrice(double k, double j) {
        if (type.equals(ty[2])) {
            if (k + j >= 100) {
                price = (k + j) * 0.8;
            } else {
                price = (k + j) * 0.9;
            }

        }
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return Description;
    }
}
