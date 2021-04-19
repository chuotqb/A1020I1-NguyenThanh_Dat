package bai1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double vnd;
        double usd;
        System.out.println("Enter Do La My (USD): ");
        usd=scanner.nextDouble();
        vnd=usd*23000;
        System.out.println("Change Viet Nam Dong = "+vnd+"VNĐ");

    }
}
