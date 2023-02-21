package pl.edu.wat.gamingshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.gamingshop.dto.ProductsRequest;
import pl.edu.wat.gamingshop.dto.ProductsResponse;
import pl.edu.wat.gamingshop.entity.Products;
import pl.edu.wat.gamingshop.exception.EntityNotFound;
import pl.edu.wat.gamingshop.service.ProductsService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/show")
    public List<Products> callAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> productById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(productsService.getProductById(id), HttpStatus.OK);
        } catch (EntityNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ProductsRequest> createProducts(@RequestBody ProductsRequest productsRequest){
        try {
            productsService.save(productsRequest).getId();
            return new ResponseEntity<>(productsRequest, HttpStatus.CREATED);
        }catch (EntityNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsResponse>updateProducts(@PathVariable String id, @RequestBody ProductsRequest productsRequest){
        try {
            return new ResponseEntity<>(productsService.update(id, productsRequest.getProductName(), productsRequest.getPrice()), HttpStatus.OK);
        }catch (EntityNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public @ResponseBody ResponseEntity deleteProducts(@PathVariable String id){
        productsService.deleteProductsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
