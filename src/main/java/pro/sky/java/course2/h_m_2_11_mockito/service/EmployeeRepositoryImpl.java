package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Repository;

import pro.sky.java.course2.h_m_2_11_mockito.exceptoins.EmployeeAlreadyAdded;
import pro.sky.java.course2.h_m_2_11_mockito.exceptoins.EmployeeNotFound;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<String, Employee> employeesMap;

    public EmployeeRepositoryImpl() {
        this.employeesMap = new HashMap<>();
    }

    @Override
    public Employee add(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employeesMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAdded("Сотрудник " + lastName + " " + firstName + " уже внесен в реестр");
        }
        employeesMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsKey(employee.getFullName())) {
            employeesMap.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesMap.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeesMap.values());
    }
}
