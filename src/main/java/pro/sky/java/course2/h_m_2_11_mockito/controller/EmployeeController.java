package pro.sky.java.course2.h_m_2_11_mockito.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;
import pro.sky.java.course2.h_m_2_11_mockito.service.EmployeeService;


import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName,
                        @RequestParam("department") int department, @RequestParam("salary") double salary) {

        return employeeService.add(lastName, firstName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName) {
        return employeeService.remove(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name1") String lastName, @RequestParam("name2") String firstName) {
        return employeeService.find(lastName, firstName);
    }

    @GetMapping
    public Collection<Employee> print() {
        return employeeService.print();
    }
}
