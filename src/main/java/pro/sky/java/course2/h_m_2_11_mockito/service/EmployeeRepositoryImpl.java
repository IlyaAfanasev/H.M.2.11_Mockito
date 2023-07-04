package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Repository;

import pro.sky.java.course2.h_m_2_11_mockito.exceptoins.EmployeeAlreadyAdded;
import pro.sky.java.course2.h_m_2_11_mockito.exceptoins.EmployeeNotFound;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeesList;
    public EmployeeRepositoryImpl() {
    this.employeesList=new ArrayList<>();
    }
    @Override
    public Employee add(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        if (employeesList.contains(employee.getFullName())) {
            throw new EmployeeAlreadyAdded("Сотрудник " + lastName + " " + firstName + " уже внесен в реестр");
        }
        employeesList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesList.contains(employee.getFullName())) {
            employeesList.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employeesList.contains(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeesList);
    }
}
