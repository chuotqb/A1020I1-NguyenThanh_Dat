package bai4_class_object_java.bai_tap;

import java.util.Scanner;
public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào giá trị a: ");
        double a=input.nextDouble();
        System.out.println("Nhập vào giá trị b: ");
        double b=input.nextDouble();
        System.out.println("Nhập vào giá trị c: ");
        double c=input.nextDouble();
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        if (quadraticEquation.getDiscriminant()>0){
            System.out.println("Phương trình có 2 nghiệm: ");
            System.out.println("Nghiệm 1= "+quadraticEquation.getRoot1());
            System.out.println("Nghiệm 2= "+quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant()==0){
            System.out.println("Phương trình có 1 nghiệm = "+quadraticEquation.getRoot1());
        }else {
            System.out.println("The equation has no roots");
        }
    }

}
