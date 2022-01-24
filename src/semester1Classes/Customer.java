package semester1Classes;
public class Customer {
    private String name;
    private static int numC = 0;
    private int customerId;

    public Customer(String n) {
        name = n;
        customerId = numC;
        /// <Error> numC++;
    }

    public static int getNextAccNum() {
        numC++; /// <Error> Delete Line
        return numC;
        /*
         * Note numC should be in constuctor think Logically .... => just want to know
         * what number to give to next customer, not assign a new one, could skip
         * number!
         */
    }

    public void/* <Error> need to include void, original lacked */ updateName(String n) {
        name = n;
    }

    public String /* <Error> need to include String, original lacked */ generateBill(double d) {
        /* <Error> should be return, original had System.out.println(); */ return name + ", account number "
                + customerId + ", please pay $" + d;
    }
    // Score if Summative 5/9 [C+]
}
