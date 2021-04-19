package bai7_abstrac_interface.bai_tap;

public class ResizeableMain {
    public static void main(String[] args) {
        Shape shapes[]= new Shape[3];
        shapes[0]= new Circle(1, "indigo", false);
        shapes[1]= new Rectangle(2, 3, "orange", true);
        shapes[2]= new Square(4, "yellow", true);
        double percent=(int)(Math.random()*100);

        System.out.println("Trước khi thay đổi kích thước: ");
        for (Shape shape:shapes){
            if (shape instanceof Circle){
                System.out.println("Diện tích của hình tròn:  "+
                        ((Circle) shape).getArea());
            } else if (shape instanceof Square){
                System.out.println("Diện tích của hình chữ vuông:  "+
                        ((Square) shape).getArea());
            } else if (shape instanceof Rectangle){
                System.out.println("Diện tích của hình chữ nhật:  "+
                        ((Rectangle) shape).getArea());
            }

        }
        System.out.println("Sau khi thay đổi kích thước: ");
        System.out.println("Phần trăm tăng kích thước của hình: "+percent+"%");
        for (Shape shape:shapes){
            if (shape instanceof Circle){
                ((Circle) shape).resize(percent);
            } else if(shape instanceof Square){
                ((Square) shape).resize(percent);

            } else if (shape instanceof Rectangle){
                ((Rectangle) shape).resize(percent);
            }

        }
    }
}
