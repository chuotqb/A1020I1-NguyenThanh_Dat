package bai6_inheritance.bai_tap;

import java.util.Arrays;

public class MainPoint3D {
    public static void main(String[] args) {
    Point3D point3D=new Point3D();
        System.out.println(point3D);
        System.out.println("Mảng trả về: "+Arrays.toString(point3D.getXYZ()));
        point3D=new Point3D(1,2,3);
        System.out.println(point3D);
        System.out.println("Mảng trả về: "+Arrays.toString(point3D.getXYZ()));
    }
}
