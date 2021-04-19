package bai4_class_object_java.bai_tap;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1=new Fan();
        fan1.setOn(true);
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        Fan fan2=new Fan();
        fan2.setOn(false);
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println("Information Fan 1: ");
        System.out.println(fan1);
        System.out.println("Information Fan 2: ");
        System.out.println(fan2);

    }
}
