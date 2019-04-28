package com.sparta.siq.control;

import com.sparta.siq.model.CSVReader;
import com.sparta.siq.model.Employee;
import com.sparta.siq.model.EmployeeDAO;
import com.sparta.siq.model.EmployeeRecords;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Properties;

public class EmployeeController {

    private EmployeeRecords employeeRecords ;
    private Thread t1;

    private Logger log = Logger.getLogger(EmployeeController.class.getName());
    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public void CreateEmployees()
    {
        try {
            t1 = new Thread();
            Properties properties = new Properties();
            properties.load(new FileReader("Resources/EmployeeCSVFactory.properties"));
            String CSVData = properties.getProperty("EmployeeData");
            long startTime = System.nanoTime();
            CSVReader csvReader = new CSVReader();
            employeeRecords = csvReader.readFile();
            EmployeeDAO dao = new EmployeeDAO();
            dao.addEmployeeDetails(employeeRecords.getEmployeeHashMap());
            long EndTime = System.nanoTime();
            DecimalFormat df = new DecimalFormat("###,###,###");
            log.trace(" Total Time Taken = " +df.format(EndTime-startTime));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void CreateEmployeewithThreads()
    {

    }



}
