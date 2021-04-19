package bai3_method_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int []a=new int[3];
        int []b=new int[4];
        int []c=new int[7];
        for (int i=0;i<a.length;i++){
            System.out.println("Nhập vào phần tử thứ "+(i+1)+" của mảng a");
            a[i]=scanner.nextInt();
        }
        for (int j=0;j<b.length;j++){
            System.out.println("Nhập vào phần tử thứ "+(j+1)+" của mảng b");
            b[j]=scanner.nextInt();
        }
        for (int k=0;k<a.length;k++){
            c[k]=a[k];

        }
        for (int l=0;l<b.length;l++){
            c[l+b.length-1]=b[l];
        }

        System.out.println("Các phần tử của mảng a "+ Arrays.toString(a));
        System.out.println("Các phần tử của mảng b "+ Arrays.toString(b));
        System.out.println("Các phần tử của mảng c "+ Arrays.toString(c));
    }
}
