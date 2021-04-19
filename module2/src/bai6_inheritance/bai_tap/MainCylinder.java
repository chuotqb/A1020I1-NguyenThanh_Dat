package bai6_inheritance.bai_tap;

public class MainCylinder {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(10);
        System.out.println(cylinder);

        cylinder =new Cylinder(3.0,"yellow",20);
        System.out.println(cylinder);

    }
}
