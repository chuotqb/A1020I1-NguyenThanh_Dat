package bai12_java_colection_framework.bai_tap.product;

import java.util.*;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    static List <Product> productList=new ArrayList<>();
    public void add(Product product){
        System.out.println("Nhập tên sản phẩm: ");
        String nameProduct= scanner.next();
        System.out.println("Nhập id sản phẩm: ");
        int idProduct= scanner.nextInt();
        System.out.println("Nhập giá sản phẩm: ");
        float costProduct= scanner.nextFloat();
        productList.add(new Product(nameProduct,idProduct,costProduct));

    }
    public void edit(){
        System.out.println("Nhập vào id sản phẩm muốn sửa");
        int idEdit = scanner.nextInt();
        boolean checkEdit=false;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==idEdit){
                checkEdit=true;
                int chooseEdit;
                while (true){
                    System.out.println("Mời bạn chọn sửa mục: ");
                    System.out.println("1. Sửa tên sản phẩm");
                    System.out.println("2. Sửa id sản phẩm");
                    System.out.println("3. Sửa giá sản phẩm");
                    System.out.println("4. Exit"+"\n");
                    chooseEdit=scanner.nextInt();
                    switch (chooseEdit){
                        case 1:
                            scanner.nextLine();
                            System.out.println("Nhập tên mới: ");
                            String newName=scanner.nextLine();
                            productList.get(i).setName(newName);
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("Nhập id mới: ");
                            int newId=scanner.nextInt();
                            productList.get(i).setId(newId);
                            break;
                        case 3:
                            scanner.nextLine();
                            System.out.println("Nhập giá sản phẩm mới: ");
                            float newCost=scanner.nextFloat();
                            productList.get(i).setCost(newCost);
                        case 4:
                            return;
                    }
                }
            }
        }
        if (checkEdit==false){
            System.out.println("Không tìm thấy id của sản phẩm"+"\n");
        }
    }
    public void delete(){
        System.out.println("Nhập vào id sản phẩm muốn xóa");
        int idDelete = scanner.nextInt();
        boolean checkDelete=false;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==idDelete){
                productList.remove(productList.get(i));
                checkDelete=true;
                break;
            }
        }
        if (!checkDelete){
            System.out.println("Không tìm thấy id của sản phẩm");
        }
    }
    public void display(){
        if (productList.size()==0){
            System.out.println(" Chưa có sản phẩm nào");
        }else {
            for (Product sp : productList){
                sp.displayProduct();
            }
        }
    }
    public void find(){
        System.out.println("Nhập vào tên của sản phẩm muốn tìm: ");
        String nameFind = scanner.next();
        boolean checkFind=false;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getName().equals(nameFind)){
                checkFind=true;
                System.out.println("Thông tin sản phẩm cần tìm");
                System.out.println("Tên sản phẩm: "+productList.get(i).getName());
                System.out.println("Id sản phẩm: "+productList.get(i).getId());
                System.out.println("Giá sản phẩm: "+productList.get(i).getCost()+"\n");
                break;
            }
        }
        if (checkFind==false){
            System.out.println("Không có sản phẩm nào có tên"+nameFind+"\n");
        }

    }
    public void arrange(){
//        Collections.sort(productList, (a,b)-> (int) (a.getCost()-b.getCost()));
        Collections.sort(productList);
        System.out.println("Danh sách sản phẩm sau khi được sắp xếp theo giá"+"\n");
        System.out.println();
        display();
    }


}
