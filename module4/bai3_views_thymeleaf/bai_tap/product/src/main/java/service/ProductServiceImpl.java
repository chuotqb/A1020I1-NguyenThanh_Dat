package service;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

//@Service
public class ProductServiceImpl implements ProductService {
//    @Autowired
    private ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
