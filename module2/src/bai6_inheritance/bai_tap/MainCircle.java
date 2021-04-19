package bai6_inheritance.bai_tap;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle);

        circle=new Circle(2.0,"blue");
        System.out.println(circle);
    }
}
