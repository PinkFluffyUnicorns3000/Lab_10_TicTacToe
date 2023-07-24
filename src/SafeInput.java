import java.util.Scanner;

public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
            if(retString.length() == 0){
                System.out.println("You must enter a character!");
            }
        }while(retString.length() == 0);

        return retString;

    }

    /**
     * Get an integer value from the user
     *
     * @param pipe Scanner used for input
     * @param prompt User prompt
     * @return an int provided by the user
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine(); // clear key buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    /**
     * Get a double from the user
     *
     * @param pipe scanner collects user input
     * @param prompt prompts the user to what to enter
     * @return retDouble returns the double that the user enters
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0.0;
        String trash = "";
        boolean done = false;

        do{
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // clear key buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid input!");
            }
        }while(!done);

        return retDouble;
    }

    /**
     * Get an integer value from the user within a specified inclusive low - high range
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @param low    low value for the range
     * @param high   high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash = "";
        boolean done = false;

        do{
            System.out.print("\n" + prompt + "[" + low + ", " + high + "]" + ": ");
            if(pipe.hasNextInt()){
                retInt = pipe.nextInt();
                pipe.nextLine();
                if(retInt >= low && retInt <= high){
                    done = true;
                } else {
                    System.out.println(retInt + " is not a valid input!");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid input!");
            }
        }while(!done);

        return retInt;
    }

    /**
     *
     * @param pipe Scanner for input from user
     * @param prompt for user
     * @param low the lowest value that the user can input
     * @param high the highest value that the user can input
     * @return retDouble returns the double that the user entered
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0.0;
        String trash = "";
        boolean done = false;

        do{
            System.out.print("\n" + prompt +"[" + low +", "+ high + "]" + ": ");
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if(retDouble >= low && retDouble <= high){
                    done = true;
                }else {
                    System.out.println(retDouble + " is not within range!");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid input!");
            }
        } while(!done);

        return retDouble;
    }

    /**
     *
     * @param pipe scanner to read user input
     * @param prompt for the user
     * @return true or false depending on user input
     */

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String continueYN = "";
        boolean done = false;
        boolean retBool = true;

        do{
            System.out.print("\n" + prompt + "[y/n]: ");
            continueYN = pipe.nextLine();
            if(continueYN.equalsIgnoreCase("y")){
                // retBool already = true
                done = true;
            } else if (continueYN.equalsIgnoreCase("n")){
                retBool = false;
                done = true;
            } else {
                System.out.println("Enter a valid input not: " + continueYN);
            }
        }while(!done);

        return retBool;
    }

    /**
     *
     * @param pipe Scanner for user input
     * @param prompt for user
     * @param RegEx regular expression checked against user input
     * @return input that the user entered when it matches RegEx
     */
    public static String getRegExString(Scanner pipe, String prompt, String RegEx)
    {
        boolean done = false;
        String input = "";


        do{
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            if(input.matches(RegEx)){
                done = true;
                System.out.println("It is a match");
            } else {
                System.out.println("It does not match the RegEx value which is " + RegEx);
            }
        }while(!done);

        return input;
    }

    public static void prettyHeader(String msg) {
        int whiteSpace = (53 - msg.length()) /2;

        for (int x = 1; x <= 60; x++) {
            System.out.print("*");
        }
        System.out.print("\n***");

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.print("***");
        System.out.println(" ");

        for (int x = 1; x <= 60; x++) {
            System.out.print("*");
        }
    }
}
