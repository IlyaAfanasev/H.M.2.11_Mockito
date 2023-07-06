package pro.sky.java.course2.h_m_2_11_mockito.service;

import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    double sumSalariesByDepartment(int department);

    Optional<Employee> maxSalaryForDepartment(int department);

    Optional<Employee> minSalaryForDepartment(int department);

    List<Employee> getAllEmployeesDepartment(int department);

    Map<Integer, List<Employee>> getAllEmployees();

}