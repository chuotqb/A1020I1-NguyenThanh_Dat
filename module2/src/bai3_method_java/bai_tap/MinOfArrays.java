package bai3_method_java.bai_tap;

import java.util.Scanner;

public class MinOfArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a[]=new int[5];
        for (int i=0;i<a.length;i++){
            System.out.println("Nhập vào phần tử thứ "+(i+1));
            a[i]=scanner.nextInt();
        }
        int min=a[0];
        for (int j=1;j<a.length;j++){
            if (min>a[j]){
                min=a[j];
            }
        }
        System.out.println("phần tử nhỏ nhất của mảng là "+min);
    }
}
