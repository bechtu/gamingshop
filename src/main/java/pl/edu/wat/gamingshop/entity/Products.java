package pl.edu.wat.gamingshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Products {

    @Id
    private String id;
    private String productName;
    private Double price;
    private String employee;

    public Products() {

    }
}
