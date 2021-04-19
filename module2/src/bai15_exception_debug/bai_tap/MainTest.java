package bai15_exception_debug.bai_tap;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        double side1;
        double side2;
        double side3;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter side 1: ");
        side1=scanner.nextDouble();
        System.out.println("Enter side 2: ");
        side2=scanner.nextDouble();
        System.out.println("Enter side 3: ");
        side3=scanner.nextDouble();
        try {
            Trirangle trirangle=new Trirangle(side1,side2,side3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

    }
}
