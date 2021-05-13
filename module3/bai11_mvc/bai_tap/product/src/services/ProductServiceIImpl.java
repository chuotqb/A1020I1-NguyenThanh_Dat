package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductServiceIImpl implements ProductService {

    private static Map<Integer,Product> productMap= new TreeMap<>();

    static {
        productMap.put(1,new Product(1,"Samsung galaxy",12000,"S10","samsung"));
        productMap.put(2,new Product(2,"apple watch",15000,"series j1","apple"));
        productMap.put(3,new Product(3,"Iphone 12",17000,"pro max","apple"));
        productMap.put(4,new Product(4,"nokia",10000,"1020","nokia"));
        productMap.put(5,new Product(5,"xiaomi poco",20000,"m3","xiaomi"));
    }



    @Override
    public List<Product> display() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product findByName(String name) {
        int tempID = 0;
        List<Product> productList = new ArrayList<>(productMap.values());
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getName().equals(name)){
                tempID = productList.get(i).getId();
            }
        }
        return productMap.get(tempID);
    }
}
