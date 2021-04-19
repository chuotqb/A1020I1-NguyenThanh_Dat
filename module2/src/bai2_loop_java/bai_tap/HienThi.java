package bai2_loop_java.bai_tap;

import java.util.Scanner;

public class HienThi {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        System.out.println("Enter your choice");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 6; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 1; i <= 6; i++) {
                    for (int j = 1; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i = 6; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i=1;i<=6;i++){
                    for (int j=1;j<=6-i;j++){
                        System.out.print(" ");
                    }
                    for (int k=1;k<i;k++){
                        System.out.print("*");
                    }
                    System.out.println();

                }
                for (int i=6;i>=1;i--){
                    for (int j=1;j<=6-i;j++){
                        System.out.print(" ");
                    }
                    for (int k=1;k<i;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                String result="";
                String record="";
                String space="";
                String character="";
                for (int i=1;i<=4;i++){
                    space="";
                    character="";
                    for (int s=1;s<=4-i;s++){
                        space+=" ";
                    }
                    for (int c=1;c<=2*i-1;c++){
                        character+="*";

                    }
                    record=space+character+"\n";
                    result+=record;

                }
                System.out.println(result);
                break;

            case 4:
                System.exit(0);
            default:
                System.out.println("No Choice!");
        }


    }
}
