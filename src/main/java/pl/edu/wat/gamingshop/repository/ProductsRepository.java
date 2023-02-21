package pl.edu.wat.gamingshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.wat.gamingshop.entity.Products;

public interface ProductsRepository extends MongoRepository<Products, String> {
}
