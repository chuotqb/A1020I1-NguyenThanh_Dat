package services;

import models.Product;

import java.util.List;

public interface ProductService {
    List<Product> display();
    void add(Product product);
    void update(int id, Product product);
    void remove(int id);
    Product findById(int id);
    Product findByName(String name);
}
