package pro.sky.java.course2.h_m_2_11_mockito.service;

import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.h_m_2_11_mockito.constant.EmployeeConstants;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.h_m_2_11_mockito.constant.EmployeeConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeRepository repositoryMock;
    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnCorrectResultFromMethodSumSalaries() {
        when(repositoryMock.findAll())
                .thenReturn(FIND_ALL_COLLECTION);

        double expectedMethodSum = FIND_ALL_COLLECTION.stream()
                .filter(e -> e.getDepartment() == 2)
                .mapToDouble(Employee::getSalary)
                .sum();

        assertEquals(expectedMethodSum, out.sumSalariesByDepartment(2));

        verify(repositoryMock, times(1)).findAll();



    }
    @Test
    public void shouldReturnCorrectResultFromMethodsMaxMinSalaries() {
        when(repositoryMock.findAll())
                .thenReturn(FIND_ALL_COLLECTION);

        assertEquals(EMPLOYEE_WHIT_MAX_SALARY_IN_DEPARTMENT_2, out.maxSalaryForDepartment(2));
        assertEquals(EMPLOYEE_WHIT_MIN_SALARY_IN_DEPARTMENT_2, out.minSalaryForDepartment(2));

        verify(repositoryMock, times(2)).findAll();
    }

    @Test
    public void shouldReturnCorrectResultFromMethodGetAllEmployeesDepartment() {
        when(repositoryMock.findAll())
                .thenReturn(FIND_ALL_COLLECTION);

        assertEquals(EMPLOYEES_OF_DEPARTMENT_2, out.getAllEmployeesDepartment(2));

        verify(repositoryMock, times(1)).findAll();
    }

    @Test
    public void shouldReturnCorrectResultFromMethodGetAllEmployees() {
        when(repositoryMock.findAll())
                .thenReturn(FIND_ALL_COLLECTION);
        assertEquals(MAP_FROM_METHOD_GET_ALL_EMPLOYEES, out.getAllEmployees());
    }

}
