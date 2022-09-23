/**
 * Hourly Employee
 *
 * @author Elli
 * @version 1.0.0
 */

public class HourlyEmployee extends Employee
{

  // Constructor

  /**
   * @param employeeID  A six-character ID unique to each employee. Sets the employee ID to 0 if the provided value
   *                    is not expected
   */
  public HourlyEmployee(int employeeID)
  {
    super(employeeID);
  }

  // Methods

  /**
   * @return  The employee's salary converted to hourly rate as a floating-point number
   */
  public double getSalary()
  {
    double yearlySalary = super.getSalary();
    return yearlySalary / (40 * 52); // Yearly salary divided by weekly hours * weeks in a year
  }

}
