package bai3_method_java.bai_tap;

import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của ma trận: ");
        int row = scanner.nextInt();
        System.out.println("Nhập vào số cột của ma trận: ");
        int column = scanner.nextInt();

        int a[][] = new int[row][column];
        System.out.println("Nhập vào các phần tử cho ma trân: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("a[" + i + "][" + j + "]=");
                a[i][j] = scanner.nextInt();
            }
        }
        int sum=0;
        for (int k=0;k<row;k++){
            for (int m=0;m<column;m++){
                if (k==m){
                    sum+=a[k][m];
                }
            }
        }
        System.out.println("Tổng của các hàng chéo trong ma trận vuông là :"+sum);
    }
}
