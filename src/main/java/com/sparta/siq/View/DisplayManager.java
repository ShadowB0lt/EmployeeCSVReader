package com.sparta.siq.View;

import com.sparta.siq.model.Employee;

import java.util.HashMap;
import java.util.List;
public class DisplayManager {

    public void Print(String string)
    {
        System.out.println(string);
    }

    public void PrintList(List<Employee> EmployeeList)
    {
        for(Employee list: EmployeeList)
        {
            System.out.println(list.getEmployeeID()+ " "+list.getNamePrefix()+" "
                    + list.getFirstName()+" "+list.getMiddleInitial()+ " "+list.getLastName()+" "+list.getGender()+ " " +list.getEmail()+" "+list.getDateOfBirth()+" "+ list.getDateOfJoining()+ " "+list.getSalary());

        }
    }
    public void PrintHashMapObject(HashMap<String,Employee> employeeHashMap)
    {

    }


}
