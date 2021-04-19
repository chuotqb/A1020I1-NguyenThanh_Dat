package bai3_method_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Xoa {
    public static void main(String[] args) {
        int size;
        boolean check = false;
        int index = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào kích thước của mảng: ");
        size = scanner.nextInt();
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + " của mảng");
            a[i] = scanner.nextInt();
        }
        System.out.println("Nhập số x cần xóa: ");
        int x = scanner.nextInt();
        for (int j = 0; j < a.length; j++) {
            if (a[j] == x) {
                check = true;
                index = j;

                for (int k = j; k < a.length - 1; k++) {
                    a[k] = a[k + 1];
                }
            }
        }
        a[a.length-1]=0;
        if (check) {
            System.out.println("X xuất hiện trong mảng vừa nhập");
            System.out.println("X xuất hiện ở vị trí " + index + " trong mảng vừa nhập");
        } else {
            System.out.println("X không xuất hiện trong mảng vừa nhập");
        }

        System.out.println("Mảng sau khi xóa phần tử la: " + Arrays.toString(a));

    }
}