/**
 * Salaried Employee
 *
 * @author Elli
 * @version 1.0.0
 */

public class SalariedEmployee extends Employee
{

  // Constructor

  /**
   * @param employeeID  A six-character ID unique to each employee. Sets the employee ID to 0 if the provided value
   *                    is not expected
   */
  public SalariedEmployee(int employeeID)
  {
    super(employeeID);
  }

  // Methods

  /**
   * @return  The employee's salary converted to hourly rate as a floating-point number
   */
  public double getSalary()
  {
    double baseSalary = super.getSalary();

    // Employee qualifies for the bonus, add $1,000 to salary
    if (super.bonus)
    {
      super.setSalary(baseSalary + 1000.00);

      return baseSalary + 1000.00;
    }

    return baseSalary;
  }

}
