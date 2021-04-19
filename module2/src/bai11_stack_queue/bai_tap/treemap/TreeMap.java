package bai11_stack_queue.bai_tap.treemap;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class TreeMap {
    public static void main(String[] args) {
// a b a c a
        System.out.println("Nhập vào chuỗi kiểm tra: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        String[] arr = input.split(" ");
        System.out.println(Arrays.toString(arr));

        Map<String, Integer> map = new java.util.TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.size() == 0) {
                map.put(arr[i], 1);
            } else {
//                Set<String> keySet = map.keySet();
//                boolean flag = false;
//                for (String key : keySet) {
//                    if (arr[i].equals(key)) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag){
//                    map.put(arr[i], map.get(arr[i])+1);
//                }else {
//                    map.put(arr[i], 1);
//                }
                if (map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i])+1);
                }else {
                    map.put(arr[i], 1);
                }
            }
        }

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }

    }
}
