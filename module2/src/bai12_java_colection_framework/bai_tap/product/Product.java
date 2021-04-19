package bai12_java_colection_framework.bai_tap.product;


public class Product implements Comparable<Product>{
    private String name;
    private int id;
    private float cost;

    public Product() {
    }

    public Product(String name, int id, float cost) {
        this.name = name;
        this.id = id;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    void displayProduct(){
        System.out.println("Tên sản phẩm: "+name+", id sản phẩm: "+id+", giá sản phẩm: "+cost+"\n");


    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost == o.cost) {
            return 0;
        } else {
            return -1;
        }
    }

}
