/**
 * Employee Data
 * 
 * @author Elli
 * @version 1.0.0
 */

// Import Java utilities

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeData {

    // Fields

    private final File filePath = new File("EmployeeData.csv");
    private ArrayList<ArrayList<String>> employees = null;

    // Methods

    /**
     * Returns all employees from the specified csv file.
     *
     * @return  An ArrayList of an ArrayList of Strings from the provided file
     */
    public ArrayList<ArrayList<String>> getEmployeeData() throws IOException
    {
        // Verify that the file exists and is readable
        if (filePath.exists() && filePath.canRead())
        {
            employees = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String row;

            while ((row = br.readLine()) != null)
            {
                String[] currentRow = row.split(",");
                ArrayList<String> newEmployee = new ArrayList<>();

                for (String col : currentRow)
                {
                    newEmployee.add(col);
                }

                employees.add(newEmployee);
            }

            br.close();
        }

        return employees;
    }
}
