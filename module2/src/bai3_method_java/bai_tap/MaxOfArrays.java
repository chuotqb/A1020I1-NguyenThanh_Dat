package bai3_method_java.bai_tap;

import java.util.Scanner;

public class MaxOfArrays {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập vào số dòng của ma trận: ");
        int m=scanner.nextInt();
        System.out.println("Nhập vào số cột của ma trận: ");
        int n=scanner.nextInt();

        int a[][]=new int[m][n];
        System.out.println("Nhập vào các phần tử cho ma trân: ");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.println("a["+i+"]["+j+"]=");
                a[i][j]=scanner.nextInt();
            }
        }
        int max=a[0][0];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (a[i][j]>max){
                    max=a[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong ma trận là : "+max);
    }
}
