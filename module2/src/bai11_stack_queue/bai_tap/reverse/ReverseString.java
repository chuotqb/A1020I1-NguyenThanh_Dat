package bai11_stack_queue.bai_tap.reverse;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        char[] reverseString = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
//        int i=0;
//        while (!stack.isEmpty()) {
//            reverseString[i++] = stack.pop();
//        }
        for (int j=0;!stack.isEmpty();j++){
            reverseString[j]=stack.pop();
        }
        System.out.println(reverseString);

    }

}
