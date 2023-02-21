package pl.edu.wat.gamingshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.gamingshop.dto.EmployeeRequest;
import pl.edu.wat.gamingshop.dto.EmployeeResponse;
import pl.edu.wat.gamingshop.entity.Employee;
import pl.edu.wat.gamingshop.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> showAll(){
        return employeeRepository.findAll();
    }

    public EmployeeResponse save(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurname(employeeRequest.getSurname());
        employee = employeeRepository.save(employee);

        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getSurname());
    }

}
