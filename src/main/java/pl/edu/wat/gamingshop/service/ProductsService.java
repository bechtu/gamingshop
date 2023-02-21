package pl.edu.wat.gamingshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.edu.wat.gamingshop.dto.EmployeeResponse;
import pl.edu.wat.gamingshop.dto.ProductsRequest;
import pl.edu.wat.gamingshop.dto.ProductsResponse;
import pl.edu.wat.gamingshop.entity.Employee;
import pl.edu.wat.gamingshop.entity.Products;
import pl.edu.wat.gamingshop.exception.EntityNotFound;
import pl.edu.wat.gamingshop.repository.EmployeeRepository;
import pl.edu.wat.gamingshop.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository, EmployeeRepository employeeRepository) {
        this.productsRepository = productsRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    public String deleteProductsById(String id){
        productsRepository.deleteById(id);
        return "Delete";
    }

    public Products getProductById(String id) throws EntityNotFound {
        return productsRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public ProductsResponse save(ProductsRequest productsRequest) throws EntityNotFound {
        Products products = new Products();
        products.setProductName(productsRequest.getProductName());
        products.setPrice(productsRequest.getPrice());
        Employee employee = employeeRepository.findById(productsRequest.getEmployee()).orElseThrow(EntityNotFound::new);
        products.setEmployee(employee.getId());
        products = productsRepository.save(products);


        return new ProductsResponse(products.getId(), products.getProductName(), products.getPrice(),new EmployeeResponse(employee.getId(), employee.getName(), employee.getSurname()));
    }

    public ProductsResponse update(String id, String productName, Double price) throws EntityNotFound{
        Products products= productsRepository.findById(id).orElseThrow(EntityNotFound:: new);

        if (StringUtils.hasText(productName)){
            products.setProductName(productName);
        }

        if (StringUtils.hasText(String.valueOf(price))){
            products.setPrice(price);
        }

        products = productsRepository.save(products);
        return new ProductsResponse(products.getId(), products.getProductName(), products.getPrice(),null);
    }

}
