package vn.product.model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private int cost;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, int cost, String producer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.producer = producer;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

