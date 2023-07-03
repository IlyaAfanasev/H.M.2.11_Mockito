package pro.sky.java.course2.h_m_2_11_mockito.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;
import pro.sky.java.course2.h_m_2_11_mockito.service.DepartmentService;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.maxSalaryDepartment(department);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.minSalaryDepartment(department);
    }

    @GetMapping(value = "/all", params = {"department"})
    public List<Employee> getDepartmentEmployees(@RequestParam("department") int department) {
        return departmentService.getDepartmentEmployees(department);

    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return departmentService.getEmployeesByDepartments();
    }


}

