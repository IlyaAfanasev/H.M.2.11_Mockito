package pro.sky.java.course2.h_m_2_11_mockito.service;

import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> maxSalaryDepartment(int department);

    Optional<Employee> minSalaryDepartment(int department);

    List<Employee> getDepartmentEmployees(int department);

    Map<Integer, List<Employee>> getEmployeesByDepartments();

}