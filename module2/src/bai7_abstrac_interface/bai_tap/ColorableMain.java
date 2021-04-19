package bai7_abstrac_interface.bai_tap;

public class ColorableMain {
    public static void main(String[] args) {

        Shape shapes[] = new Shape[4];
        shapes[0] = new Circle(1, "indigo", false);
        shapes[1] = new Rectangle(2, 3, "orange", true);
        shapes[2] = new Square(4, "yellow", true);
        shapes[3] = new Circle(5, "indigo", false);


        for (int i=0;i<shapes.length;i++) {
            if (shapes[i] instanceof Circle) {
                System.out.println("Diện tích của hình tròn " + "ở vị trí thứ " + i +" trong mảng là "+
                        ((Circle) shapes[i]).getArea());
                ((Circle) shapes[i]).howToColor();
            } else if (shapes[i] instanceof Square) {
                System.out.println("Diện tích của hình chữ vuông " + "ở vị trí thứ " + i +" trong mảng là "+
                        ((Square) shapes[i]).getArea());
            } else if (shapes[i] instanceof Rectangle) {
                System.out.println("Diện tích của hình chữ nhật " + "ở vị trí thứ " + i +" trong mảng là "+
                        ((Rectangle) shapes[i]).getArea());
            }

        }
    }
}
