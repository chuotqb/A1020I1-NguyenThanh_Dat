package bai6_inheritance.bai_tap;

import java.util.Arrays;

public class MainPoint2D {
    public static void main(String[] args) {
        Point2D point2D=new Point2D();
        System.out.println(point2D);
        System.out.println("Mảng trả về: "+Arrays.toString(point2D.getXY()));
        point2D=new Point2D( 1,2);
        point2D.setXY(1,2);
        System.out.println(point2D);
        System.out.println("Mảng trả về: "+Arrays.toString(point2D.getXY()));
    }
}
