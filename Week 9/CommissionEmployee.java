/**
 * Commission Employee
 *
 * @author Elli
 * @version 1.0.0
 */

public class CommissionEmployee extends Employee
{

  // Constructor

  /**
   * @param employeeID  A six-character ID unique to each employee. Sets the employee ID to 0 if the provided value
   *                    is not expected
   */
  public CommissionEmployee(int employeeID)
  {
    super(employeeID);
  }

  // Methods

  /**
   * @return  The employee's salary converted to commission rate as a floating-point number
   */
  public double getSalary()
  {
    double yearlySalary = super.getSalary();
    return yearlySalary / (40 * 52); // Yearly salary divided by weekly hours * weeks in a year
  }

}
