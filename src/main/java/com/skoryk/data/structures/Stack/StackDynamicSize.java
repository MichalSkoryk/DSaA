package com.skoryk.data.structures.Stack;

public class StackDynamicSize implements Stack{



    private int capacity = 2;
    int[] stack = new int[capacity];
    int top = 0;

    /**
     * Used for testing purpose mainly
     * @return capacity of the stack
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Push element at the top of the stack
     * time: O(1)
     * @param data data to be stored
     */
    @Override
    public void push(int data){
        if(size() == capacity)
            expand();
        stack[top] = data;
        top++;
    }

    /**
     * Expand capacity to the double of the current
     * time: O(n) because of array coping, where n is the current capacity
     */
    private void expand(){
        int length = size();
        capacity *= 2;
        int[] newStack = new int [capacity];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    /**
     * Pop the data ot the top of the stack
     * time: O(1)
     * @return data from the top
     */
    @Override
    public Integer pop(){
        if(this.isEmpty())
            return null;
        int data = stack[--top];
        stack[top] = 0;
        shrink();
        return data;
    }

    /**
     * Function deletes allocated space for the array
     * time: O(n) where n is the current capacity divided be 2, because of coping array
     */
    private void shrink(){
        int length = size();
        if(capacity == 2) return;
        if(length - 1 <= (capacity/2)/2)
            capacity /= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    /**
     * Peek the top of the stack
     * time: O(1)
     * @return value at the top of the stack
     */
    @Override
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
    @Override
    public int size(){
        return top;
    }

    /**
     * Function returns if stack is empty
     * time: O(1)
     * @return boolean value if stack is empty or not
     */
    @Override
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
