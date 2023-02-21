package pl.edu.wat.gamingshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.wat.gamingshop.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
