package bai6_inheritance.bai_tap;

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1=1.0;
        this.side2=1.0;
        this.side3=1.0;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        double perimeter=this.side1+this.side2+this.side3;
        double area=Math.sqrt(perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
        return area;
    }
    public double getPerimeter(){
        return this.side1+this.side2+this.side3;
    }

    @Override
    public String toString() {
        return "Triangle " +
                "side1=" + getSide1() +
                ", side2=" + getSide2() +
                ", side3=" + getSide3() +
                " Có diện tích là: "+getArea()+" và chu vi là: "+getPerimeter()+
                " which is a subclass of "
                + super.toString();

    }
}
