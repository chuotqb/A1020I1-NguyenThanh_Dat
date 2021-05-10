package models;

public class Product {
    int id;
    String name;
    double cost;
    String description;
    String sponsor;

    public Product() {
    }

    public Product(int id, String name, double cost, String description, String sponsor) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.sponsor = sponsor;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
