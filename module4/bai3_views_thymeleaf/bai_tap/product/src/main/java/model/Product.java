package model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private int cost;
    private List<String> typeProduct;

    public Product(int id, String samsung_galaxy, int cost, String[] strings) {
    }

    public Product(int id, String name, int cost, List<String> typeProduct) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.typeProduct = typeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<String> getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(List<String> typeProduct) {
        this.typeProduct = typeProduct;
    }
}

