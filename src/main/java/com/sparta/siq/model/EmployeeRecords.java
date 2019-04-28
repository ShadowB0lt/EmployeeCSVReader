package com.sparta.siq.model;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRecords {

    private Map<String, Employee> employeeHashMap;
    private Map<String, Employee> duplicateEmployees;

    public EmployeeRecords(Map<String, Employee> employeeHashMap) {
        this.employeeHashMap = employeeHashMap;
    }

    public Map<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public void setEmployeeHashMap(HashMap<String, Employee> employeeHashMap) {
        this.employeeHashMap = employeeHashMap;
    }

    public Map<String, Employee> getDuplicateEmployees() {
        return duplicateEmployees;
    }

    public void setDuplicateEmployees(HashMap<String, Employee> duplicateEmployees) {
        this.duplicateEmployees = duplicateEmployees;
    }


}
