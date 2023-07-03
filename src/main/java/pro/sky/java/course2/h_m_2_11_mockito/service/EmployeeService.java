package pro.sky.java.course2.h_m_2_11_mockito.service;


import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String lastName, String firstName, int department, double salary);


    Employee remove(String lastName, String firstName);

    Employee find(String lastName, String firstName);

    Collection<Employee> print();
}

