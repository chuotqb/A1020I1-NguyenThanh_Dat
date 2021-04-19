package bai3_method_java.bai_tap;

import java.util.Scanner;

public class KiTuChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Str;
        char kiTu;
        int count=0;
        System.out.println("Nhập vào một chuỗi: ");
        Str = scanner.next();
        System.out.print("Ky tu can dem so lan xuat hien: ");
         kiTu=scanner.next().charAt(0);
        for (int i=0;i<Str.length();i++){
            if(Str.charAt(i)==kiTu){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự " +kiTu +
                " trong chuỗi " + Str + " = " + count);
    }
}
