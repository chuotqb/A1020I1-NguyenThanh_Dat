package bai10_array_list.bai_tap;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> myList1 = new ArrayList<>();
//      add(): thêm phần tử
        myList1.add("a");
        myList1.add("b");
        myList1.add("c");
//      size(): tổng số phần tử của tập hợp
        System.out.println(myList1.size());
//      addAll(): thêm các phần tử từ collection có sẵn
        List<String> myList2 = new ArrayList<>();
        myList2.add("e");
        myList2.add("f");
        myList1.addAll(myList2);
//      get(): Lấy giá trị phần tử theo index
        System.out.println(myList1.get(0));
//      set(): Cập nhật lại giá trị của phần tử
        myList1.set(0, "new element");
//      indexOf(): trả về index của phần tử cần tìm
        System.out.println(myList1.indexOf("b"));
//      LastIndexOf(): trả về index cuối cùng của phần tử cần tìm
        myList1.add("b");
        System.out.println(myList1.lastIndexOf("b"));
//      remove(): xóa phần tử khỏi danh sách
        myList1.remove(2);
//      clear(): xóa toàn bộ phần tử trong tập hợp
        myList1.clear();
//      contains(): kiểm tra xem phần tử cần tìm có trong tập hợp hay không
        System.out.println(myList1.contains("z"));
//      subList(): tạo tập hợp mới từ tập hợp cho trước
        List<String> newList = myList1.subList(1,3);
//      toArray(): chuyển tập hợp ArrayList thành tập hợp Array
        myList1.toArray();
//      asList(): chuyển Array thành ArrayList
        System.out.println();
        for (String element: myList1){
            System.out.println(element+"\t");
        }
        System.out.println();
        for (String element: newList){
            System.out.println(element+"\t");
        }
//    }
    }
}
