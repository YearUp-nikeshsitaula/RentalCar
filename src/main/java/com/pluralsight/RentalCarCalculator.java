package com.pluralsight;
import java.util.*;

public class RentalCarCalculator {

    // Static Scanner have a fixed scanner. No need to add scanner in every Method
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        // Establish KNOWN Values, from user.

        // Using methods to not use Scanner repeatedly on same type of variables
        String pickupDate = promptForString("When is the pickup date? ");
        short numberOfDays = promptForShort("Number of days renting= ");
        boolean needsTollTag = promptForBoolean("Do you want an Electronic toll tag at $3.95/day? ");
        boolean needGPS = promptForBoolean("Do you want a GPS at $2.95/day? ");
        boolean needsRoadsideAssistance = promptForBoolean("Do you want a Roadside Assistance at $3.95/day? ");
        short age = promptForShort("How old are you? ");
        double basicCarRentalPerDay = 29.99f;
        short underageRate = 25;
        double surchargeRate = 0.30f;


        // Calculate Unknown Values

        // Variables to make the if statements easier, for optionsTotalFee
        double valueToll = 0;
        double valueGPS = 0;
        double valueAssistance = 0;

        // If Boolean = true, the values will be assigned, for optionsTotalFee
        if (needsTollTag){
            valueToll = 3.95f;
        }
        if (needGPS){
            valueGPS = 2.95f;
        }
        if (needsRoadsideAssistance){
            valueAssistance = 3.95f;
        }

        // Calculating the main values

        double basicCarRentalFee = (basicCarRentalPerDay * numberOfDays);
        double optionsTotalFee = ((numberOfDays * valueToll) + (numberOfDays * valueGPS) + (numberOfDays * valueAssistance));
        double underageSurcharge = 0;
        if (age < underageRate){
            underageSurcharge = (surchargeRate * basicCarRentalFee);
        }
        double totalCost = basicCarRentalFee + optionsTotalFee + underageSurcharge;


        // Display the results

        System.out.printf("Basic Car Rental fee:      $%.2f\n", basicCarRentalFee);
        System.out.printf("Option fee:                $%.2f\n", optionsTotalFee);
        System.out.printf("Underage Surcharge fee:    $%.2f\n", underageSurcharge);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("TOTAL:                     $%.2f\n", totalCost);

    }

    // All Methods

    // (String prompt) makes it so you MUST input string on your prompt at the top
    // Method for Strings.
    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Method for Boolean
    public static boolean promptForBoolean(String prompt) {
        System.out.print(prompt + "Y for Yes, N for No: ");
        String userInput = scanner.nextLine();
        return (userInput.equalsIgnoreCase (("Y")) || userInput.equalsIgnoreCase(("yes")));
    }

    // Method for Short
    public static short promptForShort(String prompt) {
        System.out.print(prompt);
        short value = scanner.nextShort();
        scanner.nextLine();
        return value;
    }
}






