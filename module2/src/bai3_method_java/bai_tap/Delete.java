package bai3_method_java.bai_tap;


import java.util.Arrays;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        int n;
        int i;
        int c;
        boolean check=false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int a[] = new int[n];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            a[i] = scanner.nextInt();
        }

        System.out.println("Nhập số nguyên k: ");
        int k = scanner.nextInt();
        for (i = 0; i < a.length; i++) {
            if (a[i] == k) {
                check=true;
                for (c = i = 0; i < n; i++) {
                    if (a[i] != k) {
                        a[c] = a[i];
                        c++;
                    }
                }
                n = c;
                if (check){
                    System.out.println("\n"+"Số nguyên k xuất hiện trong mảng vừa nhập");
                    System.out.println("Số nguyện k xuất hiện ở vị trí thứ "+i);
                }else {
                    System.out.println("Số nguyên k không xuất hiện trong mảng vừa nhập");
                }
                System.out.println("Mảng còn lại sau khi xóa phần tử " + k + " là: ");
                for (i = 0; i < n; i++) {
                    System.out.print(a[i] + "\t");
                }
            }

        }


    }
}
