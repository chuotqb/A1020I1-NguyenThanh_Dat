package repository;


import model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static Map<Integer, Product> product;
    static {
        product.put(1,new Product(1,"Samsung Galaxy",100, new String[]{"Samsung","Apple","Nokia", "Xiaomi"}));
        product.put(2,new Product(2,"Iphone 12",50, new String[]{"Samsung","Apple","Nokia", "Xiaomi"}));
        product.put(3,new Product(3,"Xiaomi pro",200, new String[]{"Samsung","Apple","Nokia", "Xiaomi"}));
        product.put(4,new Product(4,"Iphone XS Max",500, new String[]{"Samsung","Apple","Nokia", "Xiaomi"}));
        product.put(5,new Product(5,"Samsung M5",200, new String[]{"Samsung","Apple","Nokia", "Xiaomi"}));
    }
    @Override
    public List<Product> findAll() {

        return new ArrayList<Product>(product.values());
    }
}
