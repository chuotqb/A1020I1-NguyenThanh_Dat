package bai6_inheritance.bai_tap;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return super.getRadius() * super.getRadius() * Math.PI*height;
    }

    @Override
    public String toString() {
        return "A Cylinder with " +
                "height=" + height +
                ", which is a subclass of " + super.toString() ;

    }
}
