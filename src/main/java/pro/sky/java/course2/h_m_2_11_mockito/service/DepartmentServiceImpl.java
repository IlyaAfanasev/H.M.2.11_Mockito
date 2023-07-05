package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public int sumSalariesByDepartment(int department) {

        int sum=0;
        for (Employee employee : employeeRepository.findAll()) {
            sum+=employee.getSalary();
        }
        return sum;


    }

    @Override
    public Optional<Employee> maxSalaryForDepartment(int department) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public Optional<Employee> minSalaryForDepartment(int department) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public List<Employee> getAllEmployeesDepartment(int department) {
        return employeeRepository.findAll().stream().filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
