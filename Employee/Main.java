/**
 * Main
 * 
 * @author Elli
 * @version 1.0.0
 */

// Import Java utilities
import java.io.IOException;
import java.lang.StringBuilder;

public class Main
{

    /**
     * The main method contains variable declarations and console output.
     * 
     * @param args  The command line arguments.
     */
    public static void main(String[] args) throws IOException
    {

        // Just manually set the number of employees for an iterator
        int numEmployees = 16;

        // Table header
        System.out.println(repeatChars(174, '-'));
        System.out.printf("%-2S  %-12S  %-12S  %-4S  %-32S%13S  %-10S" +
                "  %-24S  %-12S  %-10S  %-10S  %-13S%n", "ID", "First Name",
                "Last Name", "Age", "Title", "Salary", "Status", "Supervisor",
                "Department", "Insurance", "Hire Date", "Phone");
        System.out.println(repeatChars(174, '-'));

        // Print table rows
        for (int i = 1; i <= numEmployees; i++)
        {
            Employee newEmployee = new Employee(i);
            newEmployee.getEmployee();
            newEmployee.printEmployee();
        }

    }

    /**
     * Returns a specified number of characters as a StringBuilder.
     *
     * @param num  The total number of characters to generate
     * @param sym  The symbol to be repeated
     * @return     A StringBuilder object with the specified number of repeated characters
     */
    public static StringBuilder repeatChars(int num, char sym)
    {
        StringBuilder symbols = new StringBuilder();
        return symbols.append(String.valueOf(sym).repeat(Math.max(0, num)));
    }

}
