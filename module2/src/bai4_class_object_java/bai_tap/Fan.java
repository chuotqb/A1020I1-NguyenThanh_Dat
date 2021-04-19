package bai4_class_object_java.bai_tap;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM=2;
    public static final int FAST=3;
    private int speed;
    private boolean on;
    private double radius=5;
    private String color="blue";
    String tempOn="";

    public Fan() {
        this.speed = SLOW;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        if (on){
            tempOn="fan is on";
        }else {
            tempOn="fan is off";
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "speed=" + speed +
                ", status=" + tempOn +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
