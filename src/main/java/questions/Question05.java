package questions;


import java.util.Stack;

public class Question05 {

    public static void sortStackByStack(Stack<Integer> integerStack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!integerStack.isEmpty()) {
            int current = integerStack.pop();
            while (!help.isEmpty() && help.peek() < current) {
                integerStack.push(help.pop());
            }
            help.push(current);
        }
        while (!help.isEmpty()) {
            integerStack.push(help.pop());
        }
    }


}
