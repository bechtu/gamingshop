package pl.edu.wat.gamingshop.dto;

import lombok.Data;

@Data
public class ProductsRequest {
    private String productName;
    private Double price;
    private String employee;
}
