package com.sparta.siq.model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.lang.model.element.Element;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    private final String CSV_FILE = "resources/EmployeeRecords.csv";
    private final String TEST_FILE = "resources/TestData.csv";
    private final String SPEED_TEST_FILE = "resources/SpeedTestData.csv";
    private final String LARGE_TEST_FILE = "resources/EmployeeRecordsLarge.csv";


    private Employee employee;

    Map<String,Employee> records = new HashMap<>();

    private Logger log = Logger.getLogger(CSVReader.class.getName());
    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public CSVReader()
    {

    }
    public CSVReader(Map<String,Employee> records)
    {
        this.records = records;
    }

    public EmployeeRecords readFile() {
        log.trace("Read File Started");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(SPEED_TEST_FILE))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] employeeFields = line.split(",");
                Validator validator = new Validator();
                if (checkNumberOfColumns(employeeFields) & validator.validate(employeeFields)) {
                    addEmployee(employeeFields);
                } else {
                    log.trace("Corrupted Employee Data Found in file." + employeeFields);
                }
            }
            log.trace("File Reader closed");
        } catch (FileNotFoundException f) {
        } catch (IOException e) {
        }
        return new EmployeeRecords(records);
    }

    private void addEmployee(String[] employeeFields)
    {
        employee = new Employee(employeeFields);
        checkDuplicates(employee);
//        log.trace("Employee object created after validation & duplication check : " + employee);
    }

    private void checkDuplicates(Employee employee) {

        if(records.containsKey(employee.getEmployeeID()))
        {
            records.put(employee.getEmployeeID(),employee);
        }
        else {
            records.put(employee.getEmployeeID(),employee);
        }
    }
    private boolean checkNumberOfColumns(String[] employeeFields)
    {
        if(employeeFields.length == 10)
        {
            return true;
        }
        return false;
    }

}
