package bai6_inheritance.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        System.out.println("Mảng trả về: "+ Arrays.toString(point.getXY()));
        point = new Point(10, 20);
        System.out.println(point);
        System.out.println("Mảng trả về: "+ Arrays.toString(point.getXY()));
    }
}
