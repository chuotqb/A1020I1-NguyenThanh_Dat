package bai11_stack_queue.bai_tap.bracket;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String chuoi = "(– b + (b2 – 4*a*c)^0.5) / 2*a ";
        if (isFullBracket(chuoi)){
            System.out.println("Well");
        }else {
            System.out.println("???");
        }
    }
    private static boolean isFullBracket(String input){
        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char sym = input.charAt(i);
            if (sym == '(') {
                bStack.push(sym);
            } else if (sym == ')') {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    bStack.pop();
                }
            }
        }
        if (bStack.empty()){
            return true;
        }else {
            return false;
        }
    }


}
