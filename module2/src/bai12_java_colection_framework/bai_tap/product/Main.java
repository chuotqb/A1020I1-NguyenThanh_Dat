package bai12_java_colection_framework.bai_tap.product;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void Menu(){
        System.out.println("Hệ thống quản lý sản phẩm");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa thông tin sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị danh sách sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm ");
        System.out.println("6. Sắp xếp sản phẩm ");
        System.out.println("7. Exit ");
    }
    public static void main(String[] args) {
        int choose;
        ProductManager product=new ProductManager();
        Scanner scanner=new Scanner(System.in);

        while (true){
            Menu();
            System.out.println("Mời bạn chọn 1 mục: ");
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    product.add(new Product());
                    break;
                case 2:
                    product.edit();
                    break;
                case 3:
                    product.delete();
                    break;
                case 4:
                    product.display();
                    break;
                case 5:
                    product.find();
                    break;
                case 6:
                    product.arrange();
                    break;
                case 7:
                    return;
            }
        }
    }
}
