package pro.sky.java.course2.h_m_2_11_mockito.constant;

import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeConstants {
    public static final Employee EMPLOYEE_AFANASIEV =
            new Employee("Афанасьев", "Илья", 1, 35000);

    public static final Employee EMPLOYEE_ROCHEV =
            new Employee("Рочев", "Александр", 2, 38000);

    public static final Employee EMPLOYEE_SUVOROV =
            new Employee("Суворов", "Игорь", 2, 33000);

    public static final Employee EMPLOYEE_IVANOV =
            new Employee("Иванов", "Евгений", 3, 34000);
    private static final Map<String, Employee> employeesMap = new HashMap<>(Map.of(
            EMPLOYEE_AFANASIEV.getFullName(), EMPLOYEE_AFANASIEV,
            EMPLOYEE_ROCHEV.getFullName(), EMPLOYEE_ROCHEV,
            EMPLOYEE_SUVOROV.getFullName(), EMPLOYEE_SUVOROV,
            EMPLOYEE_IVANOV.getFullName(), EMPLOYEE_IVANOV
    ));
    public static final Collection<Employee> FIND_ALL_COLLECTION =
            Collections.unmodifiableCollection(employeesMap.values());
    public static final Optional<Employee> EMPLOYEE_WHIT_MAX_SALARY_IN_DEPARTMENT_2
            = Optional.of(EMPLOYEE_ROCHEV);
    public static final Optional<Employee> EMPLOYEE_WHIT_MIN_SALARY_IN_DEPARTMENT_2
            = Optional.of(EMPLOYEE_SUVOROV);
    public static final List<Employee> EMPLOYEES_OF_DEPARTMENT_2 = employeesMap.values().stream().filter(e -> e.getDepartment() == 2)
            .collect(Collectors.toList());

    public static final Map<Integer, List<Employee>> MAP_FROM_METHOD_GET_ALL_EMPLOYEES =
            employeesMap.values()
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));


}
