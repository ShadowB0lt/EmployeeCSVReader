package com.sparta.siq.model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;

public class EmployeeDAO {

    DecimalFormat df = new DecimalFormat("###,###,###");
    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String MY_SQL = "JDBC:mysql://localhost:3306/employees?user=root&password=password&useSSL=false&serverTimezone=GMT";
    //private final String timeZone = DriverManager.getConnection(connection.MY_SQL + TimeZone.getDefault().getID());
    private final String ADD_EMPLOYEE_DETAILS = "insert into employee values (?,?,?,?,?,?,?,?,?,?);";


    private Logger log = Logger.getLogger(EmployeeDAO.class.getName());
    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public EmployeeDAO()
    {

    }
    public void addEmployeeDetails(Map<String,Employee> employeeHashMap)
    {
        Collection<Employee> records = employeeHashMap.values();
        long start = System.nanoTime();
        try {
            connection = DriverManager.getConnection(MY_SQL);
            preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_DETAILS);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Employee employee: records) {

            manageEmployeeDetails(employee);
       }
       try {
           connection.commit();
           connection.close();
       }
       catch (SQLException e)
       {
           e.printStackTrace();
       }
       long end = System.nanoTime();

       log.trace("add Employee details to database time taken " + df.format( end-start));
    }

    public void manageEmployeeDetails(Employee employee)
    {
        long start = System.nanoTime();
        try
        {
            preparedStatement.setString(1,employee.getEmployeeID());
            preparedStatement.setString(2,employee.getNamePrefix());
            preparedStatement.setString(3,employee.getFirstName());
            preparedStatement.setString(4,employee.getMiddleInitial());
            preparedStatement.setString(5,employee.getLastName());
            preparedStatement.setString(6,employee.getGender());
            preparedStatement.setString(7,employee.getEmail());
            preparedStatement.setDate(8,Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
            preparedStatement.setInt(10,employee.getSalary());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        //log.trace("Manage Employee Detail Time taken: " + df.format(end-start));
    }

}
