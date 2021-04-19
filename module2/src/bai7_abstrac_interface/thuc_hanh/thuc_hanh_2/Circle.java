package bai7_abstrac_interface.thuc_hanh.thuc_hanh_2;

public class Circle {
    private double radius = 1.0;
    private String color = "black";
    private boolean fill;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, Boolean fill) {
        this.radius = radius;
        this.color = color;
        this.fill=fill;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return  "A Circle with "+
                "radius=" + getRadius() +
                ", color='" + getColor() + '\''
                + " and "
                + (isFill() ? "filled" : "not filled");
    }
}
