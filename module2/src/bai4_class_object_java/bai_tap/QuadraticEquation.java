package bai4_class_object_java.bai_tap;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    double delta;
    double r1;
    double r2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        delta=Math.pow(this.b,2) - 4 * this.a * this.c;
        return delta;
    }

    public double getRoot1() {
        return r1 = (-this.b + Math.pow(delta, 0.5)) / 2 * this.a;
    }

    public double getRoot2() {
        return r2 = (-this.b - Math.pow(delta, 0.5)) / 2 * this.a;
    }
}
