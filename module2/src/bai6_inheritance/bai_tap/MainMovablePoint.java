package bai6_inheritance.bai_tap;

import java.util.Arrays;

public class MainMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint=new MovablePoint(100,200);
        System.out.println(movablePoint);
        System.out.println("Mảng trả về: "+Arrays.toString(movablePoint.getSpeed()));
        movablePoint=new MovablePoint(1,2, 3,4);
        System.out.println(movablePoint);
        System.out.println("Mảng trả về: "+ Arrays.toString(movablePoint.getSpeed()));
        System.out.println("Giá trị của x khi gọi hàm move lần 1: "+movablePoint.move().getX());
        System.out.println("Giá trị của y khi gọi hàm move lần 2: "+movablePoint.move().getY());
    }
}
