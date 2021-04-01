package product.service.impl;

import org.springframework.stereotype.Service;
import product.model.Product;
import product.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productList;

    static {
        productList = new  HashMap<>();
        productList.put(1,new Product(1,"Table",4000,"House"));
        productList.put(2,new Product(2,"Sofa",5000,"House"));
        productList.put(3,new Product(3,"Headphone",3000,"Office"));
        productList.put(4,new Product(4,"Mouse",4000,"Office"));
        productList.put(5,new Product(5,"Desktop",4000,"Office"));
    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(Integer id) {
        return productList.get(id);
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void delete(Integer id) {
        productList.remove(id);
    }
}
