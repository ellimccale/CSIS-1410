/**
 * Main
 *
 * @author Elli
 * @version 1.1.0
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

    // Table header
      System.out.println(repeatChars(176, '-'));
      System.out.printf("%-2S  %-12S  %-12S  %-4S  %-32S%13S  %-12S  %-24S  %-12S  %-10S  %-10S  %-13S%n", "ID",
              "First Name", "Last Name", "Age", "Title", "Rate", "Status", "Supervisor", "Department", "Insurance",
              "Hire Date", "Phone");
      System.out.println(repeatChars(176, '-'));

    // Salaried Employee
    SalariedEmployee newEmployee1 = new SalariedEmployee(1);
    newEmployee1.getEmployee();
    newEmployee1.printEmployee();

    // Hourly Employee
    HourlyEmployee newEmployee2 = new HourlyEmployee(2);
    newEmployee2.getEmployee();
    newEmployee2.printEmployee();

    // Commission Employee
    CommissionEmployee newEmployee3 = new CommissionEmployee(4);
    newEmployee3.getEmployee();
    newEmployee3.printEmployee();

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
