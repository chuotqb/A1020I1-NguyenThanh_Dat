package bai6_inheritance.bai_tap;

import java.util.Scanner;

public class MainTriangle {
    public static void main(String[] args) {
        double side1;
        double side2;
        double side3;
        String colorTriangle;
        Boolean fill;
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập vào cạnh thứ 1 của tam giác: ");
        side1 = input.nextDouble();
        System.out.println("Nhập vào cạnh thứ 2 của tam giác: ");
        side2 = input.nextDouble();
        System.out.println("Nhập vào cạnh thứ 3 của tam giác: ");
        side3 = input.nextDouble();
        System.out.println("Nhập vào màu sắc của tam giác ");
        colorTriangle=input.next();
        System.out.println("Tam giác tạo có có viền hay không?"+
                "\n"+"Nhập true nếu muốn tạo viền"+" / Nhập false nếu không muốn tạo viền"+"\n");
        fill=input.nextBoolean();
        Triangle triangle=new Triangle(colorTriangle,fill,side1,side2,side3);
        System.out.println(triangle);

    }
}
