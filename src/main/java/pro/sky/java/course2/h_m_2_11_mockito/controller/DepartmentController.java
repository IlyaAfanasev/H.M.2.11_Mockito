package pro.sky.java.course2.h_m_2_11_mockito.controller;



import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.h_m_2_11_mockito.model.Employee;
import pro.sky.java.course2.h_m_2_11_mockito.service.DepartmentService;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/employees")
    public List<Employee> getAllEmployeesDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getAllEmployeesDepartment(departmentId);

    }

    @GetMapping("{id}/salary/sum")
    public double sumSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.sumSalariesByDepartment(departmentId);
    }

    @GetMapping("{id}/salary/max")
    public Optional<Employee> maxSalaryDepartment(@PathVariable("id") int departmentId) {
        return departmentService.maxSalaryForDepartment(departmentId);
    }

    @GetMapping("{id}/salary/min")
    public Optional<Employee> minSalaryDepartment(@PathVariable("id") int departmentId) {
        return departmentService.minSalaryForDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return departmentService.getAllEmployees();
    }


}

