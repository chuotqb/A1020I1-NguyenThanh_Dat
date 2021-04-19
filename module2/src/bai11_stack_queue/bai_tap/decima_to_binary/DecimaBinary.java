package bai11_stack_queue.bai_tap.decima_to_binary;

import java.util.Stack;

public class DecimaBinary {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        int number=25;
        while(number>0){
            int a=number%2;
            stack.push(a);
            number /= 2;
        }
        while(!(stack.isEmpty()))
        {
            System.out.print(stack.pop());
        }
    }
}
