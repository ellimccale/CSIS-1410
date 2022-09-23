/**
 * Itenerary Program
 *
 * Prompt the user for a series of destinations until
 * the user stops the program. Then, output to the console
 * the planned itenerary of destinations.
 *
 * @author Elli
 * @version 1.0.0
 */

// Import Java utilities
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Itenerary
{

    /**
     * The main method contains variable declarations and
     * console output.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
       
        /**
         * Print program instructions to the console.
         */
        System.out.printf("This program will prompt you for a series of destinations.%n");
        System.out.printf("Then it will display your travel route based on your entries.%n%n");
        System.out.printf("Please enter your destinations [Enter done to finish]:%n%n");

        /**
         * Continue requesting destinations until the user enters
         * some variation of the word "done".
         */
        ArrayList<String> entries = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        System.out.printf("    Destination: ");
        String userInput = input.nextLine();

        while (!userInput.toLowerCase().equals("done"))
        {
            entries.add(userInput.toUpperCase());
            System.out.printf("    Destination: ");
            userInput = input.nextLine();
        };

        /**
         * Iterate over the destinations ArrayList and build a
         * final string of all destinations to print.
         */
        StringBuilder itenerary = new StringBuilder();

        for (int i = 0; i < entries.size(); i++)
        {
            itenerary.append(entries.get(i));

            // Don't add "to" on the last item
            if (i != entries.size() - 1)
            {
                itenerary.append(" to ");
            }
        }

        /**
         * Finally, print the complete itenerary of all
         * destinations to the console.
         */
        System.out.printf("%nItenerary: %s", itenerary);

    }

}