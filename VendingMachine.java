package assignmentTwo_000879513;

/**
 * The implementation of a Vending Machine that will let the user purchase a product by entering coins into the Machine.
 * The Vending Machine will take coins, but no pennies. The machine will also not accept any type of bills.
 * The machine will use a method to verify the coins entered before accepting anything. The machine is able to accept
 * nickels, dimes, quarters, loonies, and toonies. The user will be able to enter their coins, but the Vending Machine
 * will only accept one coin at a time. The user will also be able to vend the product, and get their change back when
 * requested. The Vending Machine also has an option to summarize how much of the product is left, how much credit
 * remains, and how much money the Vending Machine has taken in overall.
 *
 * @author Brendan Dileo
 */

public class VendingMachine {

    /** Instance variables have been declared with default values.
     * This is with the assumption they will be changed in the future when used
     */

    /**
     * This is the name of the product
     **/
    private String productName = "Product";

    /**
     * This is the price of the product
     **/
    private double productPrice = 1.00;

    /**
     * This is the number of product which is available
     **/
    private int productAvailable = 1;

    /**
     * This is the amount of unused credit
     **/
    private double unusedCredit = 1.00;

    /**
     * This is the amount of money taken in total
     **/
    private double totalMoneyTaken = 1.00;

    /**
     * This method gets the name of the product.
     *
     * @return productName which is the name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method sets the name of the product.
     *
     * @param productName which is the name of the product.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method gets the price of the product.
     *
     * @return productPrice which is the price of the product.
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * This method sets the price of the product.
     *
     * @param productPrice which is the price of the product.
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method gets the number of available products.
     *
     * @return productAvailable which is the number of available products.
     */
    public int getProductAvailable() {
        return productAvailable;
    }

    /**
     * This method sets the number of available products.
     *
     * @param productAvailable which is the number of available products.
     */
    public void setProductAvailable(int productAvailable) {
        this.productAvailable = productAvailable;
    }

    /**
     * This method gets the amount of unused credit.
     *
     * @return unusedCredit which is the amount of unused credit.
     */
    public double getUnusedCredit() {
        return unusedCredit;
    }

    /**
     * This method sets the amount of unused credit.
     *
     * @param unusedCredit which is the amount of unused credit.
     */
    public void setUnusedCredit(double unusedCredit) {
        this.unusedCredit = unusedCredit;
    }

    /**
     * This method gets the amount of money the vending machine has taken in total.
     *
     * @return totalMoneyTaken which is the total amount of money the vending machine has taken.
     */
    public double getTotalMoneyTaken() {
        return totalMoneyTaken;
    }

    /**
     * This method sets the amount of money the vending machine has taken in total.
     *
     * @param totalMoneyTaken which is the total amount of money the vending machine has taken.
     */
    public void setTotalMoneyTaken(double totalMoneyTaken) {
        this.totalMoneyTaken = totalMoneyTaken;
    }

    /**
     * This method is used to check whether the user has entered a valid money type. It will check if the money that has
     * been entered is a type in which the Vending Machine will take as it will only take coins, but no pennies. Given
     * the fact the only accepted coin types are '0.5, 0.10, 0.25, 1.00, or 2.00', this forces the user to only enter
     * one coin at a time.
     *
     * @param coin which is a type double and is the money given by the user.
     * @return will be true or false. True if the money entered is valid, and false if it is not valid.
     */
    private boolean coinCheck(double coin) {
        if (coin == 0.05 || coin == 0.10 || coin == 0.25 || coin == 1.00 || coin == 2.00) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is the method for taking money from the user. It uses an 'if else' statement and calls upon the 'coinCheck'
     * method to determine whether the coins entered are valid. If 'coinCheck' validates to true, this means the coins
     * entered are valid, and the amount entered is added to the 'unusedCredit' variable as user credit and this
     * validates to true. If 'coinCheck' validates to false, the 'takeCoin' method will validate to false as the machine
     * has not taken the money.
     *
     * @param coin which is money entered by the user
     * @return true or false which is determined by if the Vending Machine accepted the money.
     */
    public boolean takeCoin(double coin) {
        if (coinCheck(coin)) {
            unusedCredit = unusedCredit + coin;
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used for vending the item. It uses a 'else if' statement to check if the user has enough credit,
     * and if there is enough product for the user to buy. The vending machine will vend the item if both statements are
     * false, the program will return a 'boolean' value showing that.
     * If the vending machine does vend the item, the users credit will be deducted by the price of the product, the
     * total money the vending machine has taken will be increased by the price of the product, and the number of
     * the product available will be decreased by 1.
     *
     * @return true, or false. This will depend on if the item was successfully vended, or not.
     */
    public boolean vendProduct() {
        if (unusedCredit < productPrice) {
            return false;
        } else if (productAvailable == 0) {
            return false;
        } else {
            unusedCredit = unusedCredit - productPrice;
            totalMoneyTaken = totalMoneyTaken + productPrice;
            productAvailable = productAvailable - 1;
            return true;
        }
    }

    /**
     * This method is used for returning change to the user. The user's current change amount as 'unusedCredit' is
     * saved into a new 'double' variable called 'userChange' so if the change resets to 0, the user can see how much
     * change they are given back. The program uses a 'if' statement to determine if the user has any credit in the
     * Machine, if they do, the credit inside the machine as 'userCredit' is set back to 0, and returns the value saved
     * into 'userChange' as the user has received their change. If the user has no change in the machine, 0.00 is
     * returned as no change.
     *
     * @return 'userChange' as the user's change amount, or 0.00 for no change.
     */
    public double returnChange() {
        double userChange = unusedCredit;
        if (unusedCredit > 0.00) {
            unusedCredit = 0.00;
            return userChange;
        }
        return 0.00;
    }

    /**
     * This method is used to show a report of an object. It uses a return statement to describe the objects current
     * and remaining attributes.
     *
     * @return This will return a concatenated String for the object.
     */
    public String toString() {
        return "*** VendingMachine: " + productAvailable + " " + productName + " left, $" + productPrice + " " +
                "each, $" + unusedCredit + " credit, " + "and a balance of $" + totalMoneyTaken + " ***";
    }
}
