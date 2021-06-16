package vn.product.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.product.model.Product;
import vn.product.repository.ProductRepository;
import vn.product.repository.ProductRepositoryImpl;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
