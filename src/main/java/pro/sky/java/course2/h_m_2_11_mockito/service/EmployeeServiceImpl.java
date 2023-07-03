package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.Collection;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee add(String lastName, String firstName, int department, double salary) {
        return null;
    }

    @Override
    public Employee remove(String lastName, String firstName) {
        return null;
    }

    @Override
    public Employee find(String lastName, String firstName) {
        return null;
    }

    @Override
    public Collection<Employee> print() {
        return null;
    }
}
