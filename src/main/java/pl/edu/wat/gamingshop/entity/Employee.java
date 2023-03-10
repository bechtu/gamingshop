package pl.edu.wat.gamingshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;

    public Employee(){

    }
}
