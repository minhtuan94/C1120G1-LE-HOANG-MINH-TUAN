package product.service;

import product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    Product findById(Integer id);

    void save(Product product);

    void delete(Integer id);
}
