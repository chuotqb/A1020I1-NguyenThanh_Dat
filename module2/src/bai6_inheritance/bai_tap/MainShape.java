package bai6_inheritance.bai_tap;

public class MainShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("white", false);
        System.out.println(shape);
    }
}
