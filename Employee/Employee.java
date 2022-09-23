/**
 * Employee
 * 
 * The Employee class containing fields for the employee's unique ID, first and last name, age, title within the
 * company, salary, status within the company, supervisor, department within the company, insurance option, hire
 * date, and internal phone number.
 * 
 * @author Elli
 * @version 1.0.0
 */

//Import Java utilities

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee
{

    // Fields

    public int employeeID;
    public String firstName;
    public String lastName;
    public int age;
    public String title;
    private double salary;
    public String status;
    public int supervisorID;
    public boolean bonus;
    public String department;
    public int insurance;
    public String hireDate;
    public String phone;

    // Constructor

    /**
     * @param employeeID  A six-character ID unique to each employee. Sets the employee ID to 0 if the provided value
     *                    is not expected
     */
    public Employee(int employeeID)
    {
        if (employeeID >= 1 && employeeID <= 16)
        {
            this.employeeID = employeeID;
        }
        else
        {
            this.employeeID = 0;
            System.err.println("Employee ID must be an integer value between 1 and 16 (inclusive).");
        }
    }

    // Methods

    /**
     * @param firstName  A String as the employee's first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return  The employee's first name as a String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * @param lastName  A String as the employee's last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return  The employee's last name as a String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * @param age  An integer as the employee's age between 18 and 65, inclusive. Sets the age to 0 if the provided
     *             value is not expected.
     */
    public void setAge(int age)
    {
        if (age >= 18 && age <= 65)
        {
            this.age = age;
        }
        else
        {
            this.age = 0;
            System.err.println("Age must be an integer value between 18 and 65 (inclusive).");
        }
    }

    /**
     * @return  The employee's age as an integer
     */
    public int getAge()
    {
        return this.age;
    }

    /**
     * @param title  A String as the employee's title within the company
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return  The employee's title within the company as a String
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * @param salary  A floating-point number as the employee's salary
     */
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    /**
     * @param status  A single-letter code representing the employee's status at the company. Sets the status to
     *                "Unknown" if the provided value is not expected.
     */
    public void setStatus(char status)
    {
        status = Character.toUpperCase(status);

        switch(status)
        {
            case 'F':
                this.status = "Full-time";
                break;
            case 'P':
                this.status = "Part-time";
                break;
            case 'V':
                this.status = "Vendor";
                break;
            case 'C':
                this.status = "Contractor";
                break;
            default:
                this.status = "Unknown";
        }
    }

    /**
     * @return  A String representing the employee's status
     */
    public String getStatus()
    {
        return this.status;
    }

    /**
     * @param supervisorID  An integer as the employee's supervisor's employeeID
     */
    public void setSupervisor(int supervisorID)
    {
        this.supervisorID = supervisorID;
    }

    /**
     * @return  The employee's supervisor's first and last name as a String. Returns "None" if the employee does not
     *          have a supervisor.
     */
    public String getSupervisor() throws IOException
    {
        // Pulling data from the csv
        EmployeeData data = new EmployeeData();
        ArrayList<ArrayList<String>> employees = data.getEmployeeData();
        String supervisor = "";

        // Iterating over the indices of rows in the csv
        for (ArrayList<String> thisEmployee : employees) {
            // Assigning the value of the first column (the employee ID) to check against the ID passed to this method
            int thisID = Integer.parseInt(thisEmployee.get(0).trim());

            // If the IDs match, assign each field accordingly
            if (thisID == this.supervisorID) {
                supervisor = thisEmployee.get(1).trim() + " " +
                        thisEmployee.get(2).trim();
            } // If the employee does not have a supervisor
            else if (this.supervisorID < 0) {
                supervisor = "None";
            }
        }

        return supervisor;
    }

    /**
     * @param bonus  An integer value that represents a boolean, indicating whether or not the employee qualifies to
     *               receive a bonus. Adds $1,000 to the employee's salary if the integer value is 1 (boolean true).
     */
    public void setBonus(int bonus)
    {
        // Employee qualifies for the bonus, add $1,000 to salary
        if (bonus == 1)
        {
            this.bonus = true;
            this.salary += 1000.00;
        }
        else
        {
            this.bonus = false;
        }
    }

    /**
     * @param department  A String as the employee's department within the company
     */
    public void setDepartment(String department)
    {
        this.department = department;
    }

    /**
     * @return  The employee's department within the company as a String
     */
    public String getDepartment()
    {
        return this.department;
    }

    /**
     * @param insurance  An integer value representing the option code for insurance status. Sets the insurance
     *                   option to 0 if the provided value is not expected.
     */
    public void setInsurance(int insurance)
    {
        this.insurance = insurance;

        switch(insurance)
        {
            case 1:
                this.salary -= 2000.00;
                break;
            case 2:
                this.salary -= 1500.00;
                break;
            case 3:
                this.salary -= 1000.00;
                break;
            case 4:
                this.salary -= 500.00;
                break;
            default:
                this.insurance = 0;
        }
    }

    /**
     * @return  A String as the employee's insurance option. Returns "None" if the employee does not have an option
     *          selected (0).
     */
    public String getInsurance()
    {
        if (this.insurance != 0)
        {
            return "Option #" + this.insurance;
        }

        return "None";
    }

    /**
     * @param hireDate  A String representing the date the employee was hired. Sets the date to "Unknown" if the
     *                  provided value is not the expected length.
     */
    public void setHireDate(String hireDate)
    {
        if (hireDate.length() == 10)
        {
            LocalDate date = LocalDate.parse(hireDate);
            DateTimeFormatter pattern =
                    DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
            this.hireDate = pattern.format(date);
        }
        else
        {
            this.hireDate = "Unknown";
            System.err.println("Hire date must be exactly 10 characters long.");
        }
    }

    /**
     * @return  The date the employee was hired as a formatted String
     */
    public String getHireDate()
    {
        return this.hireDate;
    }

    /**
     * @param phone  A String as the employee's office phone number. Sets the number to "Unknown" if the provided
     *               value is not the expected length.
     */
    public void setPhone(String phone)
    {
        if (phone.length() == 10)
        {
            this.phone = String.format("(%s)%s-%s", phone.substring(0, 3),
                    phone.substring(3, 6), phone.substring(6, 10));
        }
        else
        {
            this.phone = "Unknown";
            System.err.println("Phone number must be exactly 10 characters long.");
        }
    }

    /**
     * @return  The employee's office phone number as a formatted String
     */
    public String getPhone()
    {
        return this.phone;
    }

    /**
     * 
     */
    public void getEmployee() throws IOException
    {
        // Pulling data from the csv
        EmployeeData data = new EmployeeData();
        ArrayList<ArrayList<String>> employees = data.getEmployeeData();

        // Iterating over the indices of rows in the csv
        for (ArrayList<String> thisEmployee : employees)
        {
            /*
             * Assigning the value of the first column (the employee ID) to check against the ID passed to the
             * current object
             */
            int thisID = Integer.parseInt(thisEmployee.get(0).trim());

            // If the IDs match, assign each field accordingly
            if (thisID == this.employeeID)
            {
                setFirstName(thisEmployee.get(1).trim());
                setLastName(thisEmployee.get(2).trim());
                setAge(Integer.parseInt(thisEmployee.get(3).trim()));
                setTitle(thisEmployee.get(4).trim());
                setSalary(Double.parseDouble(thisEmployee.get(5).trim()));
                setStatus(thisEmployee.get(6).charAt(0));
                setSupervisor(Integer.parseInt(thisEmployee.get(7).trim()));
                setBonus(Integer.parseInt(thisEmployee.get(8).trim()));
                setDepartment(thisEmployee.get(9).trim());
                setInsurance(Integer.parseInt(thisEmployee.get(10).trim()));
                setHireDate(thisEmployee.get(11).trim());
                setPhone(thisEmployee.get(12).trim());
            }
        }
    }

    /**
     * Prints a neatly formatted row of all fields
     */
    public void printEmployee() throws IOException
    {
        System.out.printf("%-2d  ", this.employeeID);
        System.out.printf("%-12s  ", this.firstName);
        System.out.printf("%-12s  ", this.lastName);
        System.out.printf("%-4d  ", this.age);
        System.out.printf("%-32s  ", this.title);
        System.out.printf("$ %9.2f  ", this.salary);
        System.out.printf("%-10s  ", this.status);
        System.out.printf("%-24s  ", getSupervisor());
        System.out.printf("%-12s  ", this.department);
        System.out.printf("%-10s  ", getInsurance());
        System.out.printf("%-10s  ", this.hireDate);
        System.out.printf("%-13s%n", this.phone);
    }
}
