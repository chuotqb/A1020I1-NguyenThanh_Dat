package bai15_exception_debug.thuc_hanh.debug;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("First Degree Equation Computer");
        System.out.println("Given a equation as 'a*x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\ta: ");
        double a = scanner.nextDouble();

        System.out.print("\tb: ");
        double b = scanner.nextDouble();

        System.out.print("\tc: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        }
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else if (b == c) {
            System.out.print("Equation pass with any 'x'!");
        } else {
            System.out.print("Equation has no root!");
        }

    }
}
