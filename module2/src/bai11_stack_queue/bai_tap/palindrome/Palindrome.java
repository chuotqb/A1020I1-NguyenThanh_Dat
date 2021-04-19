package bai11_stack_queue.bai_tap.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        Scanner scanner=new Scanner(System.in);
        String inputString= scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
            queue.add(inputString.charAt(i));
        }
        String beforeString="";
        String afterString="";


        for (int i=0;!stack.empty();i++){
            beforeString += stack.pop();
        }
        for (int i=0;!queue.isEmpty();i++){
            afterString += queue.poll();
        }

        if (beforeString.equals(afterString)){
            System.out.println("Chuỗi vừa nhập  là chuỗi Palindrome");
        }else{
            System.out.println("Chuỗi vừa nhập không phải là chuỗi Palindrome");
        }

    }
}
