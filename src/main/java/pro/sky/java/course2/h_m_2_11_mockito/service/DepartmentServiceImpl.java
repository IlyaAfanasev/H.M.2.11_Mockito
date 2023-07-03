package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Optional<Employee> maxSalaryDepartment(int department) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> minSalaryDepartment(int department) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getDepartmentEmployees(int department) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return null;
    }
}
