package com.skoryk.data.structures.Stack;

/**
 * Stack build on array with fixed sized of 5
 */
public class StackFixedSize implements Stack{

    int[] stack = new int[5];
    int top = 0;

    /**
     * Push element at the top of the stack
     * time: O(1)
     * @param data data to be stored
     */
    public void push(int data){
        if(top == 5){
            System.out.println("Stack is full");
        } else {
            stack[top] = data;
            top++;
        }
    }

    /**
     * Pop the data ot the top of the stack
     * time: O(1)
     * @return data from the top
     */
    public Integer pop(){
        if(this.isEmpty())
            return null;
        return stack[--top];
    }

    /**
     * Peek the top of the stack
     * time: O(1)
     * @return value at the top of the stack
     */
    public Integer peek(){
        if(this.isEmpty())
            return null;
        return stack[top - 1];
    }

    /**
     * Get the size of the stack
     * time: O(1)
     * @return size of the stack
     */
    public int size(){
        return top;
    }

    /**
     * Function returns if stack is empty
     * time: O(1)
     * @return boolean value if stack is empty or not
     */
    public boolean isEmpty(){
        return top == 0;
    }

    /**
     * Function returns String representation of the Stack
     * @return String representation of the Stack
     */
    @Override
    public String toString(){
        if(this.isEmpty()) return "[]";

        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < top - 1; i++){
            result.append(stack[i]).append(", ");
        }
        result.append(stack[top - 1]).append("]");
        return result.toString();
    }
}
