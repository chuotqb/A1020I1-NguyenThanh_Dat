package vn.product.service;


import vn.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update (int id,Product product);
    void delete(int id);
}
