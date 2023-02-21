package pl.edu.wat.gamingshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.gamingshop.dto.EmployeeRequest;
import pl.edu.wat.gamingshop.dto.EmployeeResponse;
import pl.edu.wat.gamingshop.entity.Employee;
import pl.edu.wat.gamingshop.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeRequest> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.save(employeeRequest);
        return new ResponseEntity<>(employeeRequest, HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public List<Employee> showAllProducer(){
        return employeeService.showAll();
    }
}
