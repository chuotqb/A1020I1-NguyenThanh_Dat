package vn.product.repository;

import vn.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
