package vn.product.repository;


import org.springframework.stereotype.Repository;
import vn.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Samsung Galaxy",100, "Samsung"));
        products.put(2,new Product(2,"Iphone 12",50, "Apple"));
        products.put(3,new Product(3,"Xiaomi pro",200, "Xiaomi"));
        products.put(4,new Product(4,"Iphone XS Max",500, "Apple"));
        products.put(5,new Product(5,"Samsung M5",200, "Samsung"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
