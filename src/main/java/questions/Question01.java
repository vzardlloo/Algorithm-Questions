package questions;

import java.util.Stack;

/**
 * 题目：设计一个栈,它有栈的基本功能并且有返回栈中最小元素的功能
 *
 * 要求：pop,push,getMin操作的时间复杂度都是O(1)
 *
 */

public class Question01 {

    //存放数据的栈
    private Stack<Integer> stackData;
    //存放当前最小数据的栈
    private Stack<Integer> stackMin;

    Question01(){
        stackData = new Stack<Integer>();
        stackMin  = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        //如果该值刚好是最小值，则将stackMin中的弹出
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException(" your stack is empty");
        }
        return this.stackMin.peek();
    }

}
