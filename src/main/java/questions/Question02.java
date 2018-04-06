package questions;

import java.util.Stack;

/**
 * 题目：编写一个类，用两个棧来实现一个队列，支持队列基本操作(add,poll,peek)
 */
public class Question02 {

    //压入数据的栈
    public Stack<Integer> stackPush;
    //弹出数据的栈
    public Stack<Integer> stackPop;

    Question02(){
        this.stackPush = new Stack<Integer>();
        this.stackPop  = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }


    public int peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


}
