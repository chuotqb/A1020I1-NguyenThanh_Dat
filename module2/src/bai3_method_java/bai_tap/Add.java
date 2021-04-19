package bai3_method_java.bai_tap;
import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index;
        int size;
        int num;
        System.out.println("Nhập vào kích thước của mảng: ");
        size = scanner.nextInt();
        int a[] = new int[size];


        for (int i = 0; i < size; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + " của mảng");
            a[i] = scanner.nextInt();
        }
        int b[] = Arrays.copyOf(a, a.length + 1);
        System.out.println(Arrays.toString(b));
        System.out.println("Nhập vào vị trí cần chèn vào: ");
        index = scanner.nextInt();
        System.out.println("Nhập vào số cần chèn: ");
        num = scanner.nextInt();

        for (int j = b.length-1; j > index; j--) {
            b[j] = b[j - 1];
        }
        b[index] = num;

        System.out.println("Mảng còn lại sau khi thêm số " + num + " vào vị trí " + index + " là:");
        for (int k = 0; k < b.length; k++) {
            System.out.print(b[k] + "\t");
        }
    }

}



