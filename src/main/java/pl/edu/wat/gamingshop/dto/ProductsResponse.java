package pl.edu.wat.gamingshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductsResponse {
    private String id;
    private String productName;
    private Double price;
    private EmployeeResponse employee;
}
