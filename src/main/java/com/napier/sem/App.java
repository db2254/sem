package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args)
    {
        // Create a new instance of the application
        App a = new App();

        // Connect to the database
        a.connect();

        // Get Employee
        System.out.println("---- View Record ----");
        Employee emp = a.getEmployee(255530);

        // Display employee details
        a.displayEmployee(emp);
        System.out.println("---- Salary by role ----");

        // Get all salaries by role (e.g., "Engineer")
        ArrayList<Employee> employeesByRole = a.getAllSalariesByRole();

        // Print salaries of employees by role
        a.printSalaries(employeesByRole);

        // Disconnect from the database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     * This method loads the database driver and attempts to establish a connection.
     */
    public void connect() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for the database to start
                Thread.sleep(30000);
                // Connect to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database on attempt " + (i + 1));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     * This method closes the database connection if it is open.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close the connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Retrieve an Employee object based on the provided ID.
     * @param ID The employee ID to search for.
     * @return An Employee object if found; otherwise, null.
     */
    public Employee getEmployee(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Construct the SQL query
            String strSelect = "SELECT emp_no, first_name, last_name FROM employees WHERE emp_no = " + ID;
            // Execute the SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check if an employee is returned
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    /**
     * Display the details of the specified employee.
     * @param emp The Employee object to display.
     */
    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " "
                            + emp.first_name + " "
                            + emp.last_name + "\n"
                            + emp.title + "\n"
                            + "Salary: " + emp.salary + "\n"
                            + "Department: " + emp.dept_name + "\n"
                            + "Manager: " + emp.manager + "\n");
        }
    }

    /**
     * Retrieve salaries for employees in a specific role (e.g., "Engineer").
     * @return A list of Employee objects containing their salaries.
     */
    public ArrayList<Employee> getAllSalariesByRole()
    {
        ArrayList<Employee> employees = new ArrayList<Employee>(); // Initialize the list
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Construct the SQL query
            String strSelect =
                    "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                            + "FROM employees, salaries, titles "
                            + "WHERE employees.emp_no = salaries.emp_no "
                            + "AND employees.emp_no = titles.emp_no "
                            + "AND salaries.to_date = '9999-01-01' "
                            + "AND titles.to_date = '9999-01-01' "
                            + "AND titles.title = 'Engineer' "
                            + "ORDER BY employees.emp_no ASC";
            // Execute the SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract employee information directly
            while (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("employees.first_name");
                emp.last_name = rset.getString("employees.last_name");
                emp.salary = rset.getInt("salaries.salary");
                employees.add(emp); // Add employee to the list
            }

            return employees;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Print a list of employee salaries.
     * @param employees The list of Employee objects to print.
     */
    public void printSalaries(ArrayList<Employee> employees)
    {
        // Check if employees list is not null
        if (employees == null || employees.isEmpty())
        {
            System.out.println("No employees");
            return;
        }
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (Employee emp : employees)
        {
            if (emp == null)
                continue;
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            emp.emp_no, emp.first_name, emp.last_name, emp.salary);
            System.out.println(emp_string);
        }
    }
}
