package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.h_m_2_11_mockito.exceptoins.IncorrectDepartmentException;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public double sumSalariesByDepartment(int department) {
        List<Employee> employees = new ArrayList<>(employeeRepository.findAll());

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {


                return employeeRepository.findAll()
                        .stream()
                        .filter(e -> e.getDepartment() == department)
                        .mapToDouble(Employee::getSalary).sum();
            }
        }
        throw new IncorrectDepartmentException();


    }

    @Override
    public Optional<Employee> maxSalaryForDepartment(int department) {

        List<Employee> employees = new ArrayList<>(employeeRepository.findAll());

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {

                return employeeRepository.findAll()
                        .stream()
                        .filter(e -> e.getDepartment() == department)
                        .max(Comparator.comparingDouble(Employee::getSalary));
            }
        }
        throw new IncorrectDepartmentException();

    }

    @Override
    public Optional<Employee> minSalaryForDepartment(int department) {

        List<Employee> employees = new ArrayList<>(employeeRepository.findAll());

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {

                return employeeRepository.findAll()
                        .stream()
                        .filter(e -> e.getDepartment() == department)
                        .min(Comparator.comparingDouble(Employee::getSalary));
            }
        }
        throw new IncorrectDepartmentException();

    }

    @Override
    public List<Employee> getAllEmployeesDepartment(int department) {

        List<Employee> employees = new ArrayList<>(employeeRepository.findAll());

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {

                return employeeRepository.findAll().stream().filter(e -> e.getDepartment() == department)
                        .collect(Collectors.toList());
            }
        }
        throw new IncorrectDepartmentException();

    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
