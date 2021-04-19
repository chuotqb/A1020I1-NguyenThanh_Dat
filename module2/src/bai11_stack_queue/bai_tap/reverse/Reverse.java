package bai11_stack_queue.bai_tap.reverse;

import java.util.Arrays;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Stack<Integer> intStack=new Stack<>();
        for (int i=0;i<arr.length;i++){
            intStack.push(arr[i]);
        }
       for (int j=0;!intStack.isEmpty();j++){
           arr[j]=intStack.pop();
       }

        System.out.println(Arrays.toString(arr));
    }
}
