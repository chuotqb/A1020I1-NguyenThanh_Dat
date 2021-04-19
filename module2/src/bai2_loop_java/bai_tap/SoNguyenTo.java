package bai2_loop_java.bai_tap;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        int numbers;
        String ketQua="";
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố cần in ra: ");
        numbers=input.nextInt();
        int count=0;
        int n=2;
        while (count<numbers){
            boolean check=true;
            for (int i=2;i<n;i++){
                if(n%i==0){
                    check=false;
                    break;
                }
            }
            if (check){
                ketQua+=n+",";
                count++;
            }
            n++;
                   }
        System.out.println(ketQua);
    }
}
