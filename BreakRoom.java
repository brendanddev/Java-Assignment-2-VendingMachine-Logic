package assignmentTwo_000879513;

/** This class acts as the Break Room where the Vending Machines will be used. The user is welcomed to the break room as
 * if they are actually entering a break room. Inside the break room is where the user will be able to interact with a
 * Vending Machine and then buy a product. The user is told that there are two Vending Machines, each one containing
 * different products at different price points. Once they have chosen a Vending machine they want to buy from, they can
 * then choose what they want to do with the Vending Machine. They can enter money into the Vending Machine, they can
 * vend an item from the Vending Machine, and they can get there money back as change, or just return their money if
 * they decide they do not want anything anymore.
 *
 * @author Brendan Dileo 000879513
 */

import java.util.Scanner;

public class BreakRoom {

    /**
     * Main method to run the program.
     *
     * @param args
     */
    public static void main(String[] args) {

        /** Creates a new instance of the Scanner Object **/
        Scanner sc = new Scanner(System.in);

        /** Creates a new instance of the 'VendingMachine' Object and initializes its attributes **/
        VendingMachine VendingMachine1 = new VendingMachine();
        VendingMachine1.setProductName("Skittles");
        VendingMachine1.setProductPrice(2.00);
        VendingMachine1.setProductAvailable(10);
        VendingMachine1.setUnusedCredit(1.25);
        VendingMachine1.setTotalMoneyTaken(0.00);

        /** Creates a new instance of the 'VendingMachine' Object and initializes its attributes **/
        VendingMachine VendingMachine2 = new VendingMachine();
        VendingMachine2.setProductName("Rolex");
        VendingMachine2.setProductPrice(6.00);
        VendingMachine2.setProductAvailable(5);
        VendingMachine2.setUnusedCredit(0.00);
        VendingMachine2.setTotalMoneyTaken(10.50);

        /** Initializes the user's choice as 'userChoice' to 0 as default prior to the user making a choice which
         * acts as the control variable to ensure the loop will end when the user enters a certain number
         */
        int userChoice = 0;

        /** This 'Do-While' loop is the main loop for the program, it acts as the user entering the Break Room. The
         * code inside the 'do' block is executed regardless, and the loop then checks if the 'while' statement at the
         * end is true or false. The loop will continue while the 'userChoice' is not equal to 4, and when it is equal
         * to 4, the loop exits acting as the user exiting the break room.
         */
        do {
            System.out.println("Welcome to the break room! You've worked hard. Enjoy something!");
            System.out.println(); // Line for clarity
            System.out.println("There are two Vending Machines here: ");

            /** Displays the attributes of the first Vending Machine using getter methods **/
            System.out.println("1. Vending Machine: " + VendingMachine1.getProductAvailable() + " " +
                    VendingMachine1.getProductName() + ", $" + VendingMachine1.getProductPrice() + ", $" +
                    VendingMachine1.getUnusedCredit() + ", $" + VendingMachine1.getTotalMoneyTaken());

            /** Displays the attributes of the second Vending Machine using getter methods **/
            System.out.println("2. Vending Machine: " + VendingMachine2.getProductAvailable() + " " +
                    VendingMachine2.getProductName() + ", $" + VendingMachine2.getProductPrice() + ", $" +
                    VendingMachine2.getUnusedCredit() + ", $" + VendingMachine2.getTotalMoneyTaken());

            System.out.println(); // Line for clarity

            /** Input

            /** Asks the user which Vending Machine they would like to pick, and saves their choice in 'vendingChoice'
             * as type 'int'
             **/
            System.out.println("Which Vending Machine do you want to choose from?");
            int vendingChoice = sc.nextInt();

            /** Uses a 'while' loop to ensure the user has chosen a valid Vending Machine.
             * The 'while' loop will continue to iterate through until the user has chosen a valid Vending Machine,
             * either 1 or 2.
             */
            while (vendingChoice != 1 && vendingChoice != 2) {
                System.out.println("There are only two Vending Machines. Choose one of them!");
                System.out.println("Which Vending Machine do you want to choose from?");
                vendingChoice = sc.nextInt();
            }

            /** Once the user has chosen a valid machine, they will be prompted with what they want to do. Their next
             * choice is saved in 'userChoice' as type 'int'
             */
            System.out.println("What would you like to do?");
            System.out.println("1. Enter money");
            System.out.println("2. Get change back");
            System.out.println("3. Vend an item");
            System.out.println("4. Leave the break room");
            System.out.println("Press any other number for a report of the Vending Machine!");
            System.out.println("Your Choice?");
            userChoice = sc.nextInt();

            /** Input / Processing / Output

            /** Depending on which option the user selects, the program will enter a 'switch case' where each choice
             * will call upon the correct method to perform what they want to do. They can either enter money into the
             * Vending Machine, vend a product, request their change, or exit the program (Break Room) altogether.
             */
            switch (userChoice) {

                /** User wants to enter money into the Vending Machine. The money entered is stored in 'coin' as
                 * type 'double'. The program uses an  outer 'if else' statement which determines if the user chose
                 * 'VendingMachine1' or 'VendingMachine2'. The inner 'if else' statements check if the user has entered
                 * a valid type of coin by calling upon the 'takeCoin' method. If the method validates to true, the
                 * user will be shown how much they have entered. If the method validates to false, the user will be
                 * shown a message that they have entered an invalid type of money, or that they have put more than one
                 * coin in at a time.
                 */
                case 1:
                    System.out.println("*** ENTER MONEY ***");
                    System.out.println("How much $ would you like to enter?");
                    double coin = sc.nextDouble();
                    if (vendingChoice == 1) {
                        if (VendingMachine1.takeCoin(coin)) {
                            System.out.println("You have entered: $" + coin);
                        } else {
                            System.out.println("The vending machine only takes nickels, dimes, quarters, loonies, or "
                                    + "toonies! No bills or pennies! Make sure your only entering one coin at a time!");
                        }
                    } else {
                        if (VendingMachine2.takeCoin(coin)) {
                            System.out.println("You have entered: $" + coin);
                        } else {
                            System.out.println("The vending machine only takes nickels, dimes, quarters, loonies, or "
                                    + "toonies! No bills or pennies! Make sure your only entering one coin at a time!");
                        }
                    }
                    break;

                /** User wants to get their change back from the Vending Machine. The program uses an outer 'if else'
                 * statement to check if the user has chosen 'VendingMachine1' or 'VendingMachine2'. The 'returnChange'
                 * method is called upon and the change returned is saved into the 'userChange' variable type 'double'.
                 * The program then enters an inner 'if else' statement to determine if the user gets change returned,
                 * if they do they are shown a message and how much change they have gotten back. If not, they are
                 * shown a message saying that they do not get any change back.
                 */
                case 2:
                    System.out.println("*** GET CHANGE ***");
                    System.out.println("Returning your change!");
                    if (vendingChoice == 1) {
                        double userChange = VendingMachine1.returnChange();
                        if (userChange > 0) {
                            System.out.println("Change returned! You have been given: $" + userChange);
                        } else {
                            System.out.println("You have not entered any money. There is no change to return.");
                        }
                    } else {
                        double userChange = VendingMachine2.returnChange();
                        if (userChange > 0) {
                            System.out.println("Change returned! You have been given: $" + userChange);
                        } else {
                            System.out.println("You have not entered any money. There is no change to return.");
                        }
                    }
                    break;

                /** User wants to vend an item from the Vending Machine. By default, the variable 'vendStatus' which
                 * is type 'boolean' is set to true. The program uses an outer 'if else' statement to check whether the
                 * user has chosen 'VendingMachine1' or 'VendingMachine2', and then uses an inner 'if else' statement
                 * and '! NOT' operator when calling upon the 'vendProduct' method to determine if the item was not vended.
                 * If the item was not vended, 'vendStatus' will be set to false, and the inner 'if else' statement will
                 * determine why the item was not vended, and show the user why this was the case. The 'if' statements
                 * within the inner statements are able to tell the user if their item was not vended because of lack
                 * of credits, or if it was because the item is out of stock. Using the 'vendStatus' variable, we
                 * can then show a message if the item was vended successfully.
                 */
                case 3:
                    System.out.println("*** VEND ITEM ***");
                    boolean vendStatus = true;
                    if (vendingChoice == 1) {
                        if (!VendingMachine1.vendProduct()) {
                            vendStatus = false;
                            if (VendingMachine1.getProductAvailable() == 0) {
                                System.out.println("Were all out of stock for this!");
                            } else {
                                System.out.println("Insufficient Credits!");
                            }
                        }
                    } else {
                        if (!VendingMachine2.vendProduct()) {
                            vendStatus = false;
                            if (VendingMachine2.getProductAvailable() == 0) {
                                System.out.println("Were all out of stock for this!");
                            } else {
                                System.out.println("Insufficient Credits!");
                            }
                        }
                    }
                    if (vendStatus) {
                        System.out.println("Product Vended! Enjoy!");
                    }
                    break;

                /** User wants to exit the Break Room / Vending Machine. If they choose to do so, they are shown an
                 * exit message.
                 */
                case 4:
                    System.out.println("*** EXITING ***");
                    System.out.println("Goodbye! Enjoy the rest of your shift!");
                    break;

                /** User wants a report of the Vending Machine. If they choose any other digit besides 1, 2, 3, or, 4
                 * the program will resort to the default case. The default case will show the user a report of the
                 * chosen Vending Machine calling upon the 'toString' method.
                 */
                default:
                    if (vendingChoice == 1) {
                        System.out.println("Here is a report of Vending Machine 1: " + VendingMachine1.toString());
                    } else {
                        System.out.println("Here is a report of Vending Machine 2: " + VendingMachine2.toString());
                    }
            }
        } while (userChoice != 4);
    }
}
