package com.sparta.siq.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public final class Employee {

    private final String EmployeeID;
    private final String namePrefix;
    private final String firstName;
    private final String middleInitial;
    private final String lastName;
    private final String Gender;
    private final String email;
    private final LocalDate DateOfBirth;
    private final LocalDate DateOfJoining;
    private int Salary;


    public Employee(String[] EmployeeFields) {

        EmployeeID = EmployeeFields[0];
        namePrefix = EmployeeFields[1];
        firstName = EmployeeFields[2];
        middleInitial = EmployeeFields[3];
        lastName = EmployeeFields[4];
        Gender = EmployeeFields[5];
        email = EmployeeFields[6];
        DateOfBirth = convertDate(EmployeeFields[7]);
        DateOfJoining = convertDate(EmployeeFields[8]);
        Salary = Integer.parseInt(EmployeeFields[9]);
    }

    private LocalDate convertDate(String EmployeeFields)
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("[M/dd/yyyy][M/d/yyyy]");
        LocalDate date = LocalDate.parse(EmployeeFields,dateTimeFormatter);
        return date;
    }
    public String getEmployeeID() {
        return EmployeeID;
    }
    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return DateOfJoining;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
