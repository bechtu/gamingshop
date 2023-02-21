package pl.edu.wat.gamingshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponse {
    private String id;
    private String name;
    private String surname;
}
