package bai3_method_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfColumn {
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
        System.out.println("Nhập vào cột muốn tính tổng: ");
        int b = scanner.nextInt();
        int total = 0;
            for (row = 0; row < a.length; row++) {
                total += a[row][b];
            }

        System.out.println("Tổng của cột " + b + " là " + total);
    }
}
