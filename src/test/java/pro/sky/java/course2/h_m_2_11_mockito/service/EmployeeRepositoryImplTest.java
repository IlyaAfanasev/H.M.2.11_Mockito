package pro.sky.java.course2.h_m_2_11_mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryImplTest {
    private final EmployeeRepositoryImpl out =new EmployeeRepositoryImpl();
    @Test
    public void shouldReturnCorrectResultFromMethodAdd() {
        Employee expected = new Employee("Афанасьев", "Илья", 1, 35000);
        Employee actual = out.add("Афанасьев", "Илья", 1, 35000);
        assertEquals(expected, actual);

        Employee expected2 = new Employee("Рочев", "Александр", 2, 38000);
        Employee actual2 = out.add("Рочев", "Александр", 2, 38000);
        assertEquals(expected2, actual2);
    }

}
