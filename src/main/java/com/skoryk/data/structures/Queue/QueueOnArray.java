package com.skoryk.data.structures.Queue;

public class QueueOnArray implements Queue{

    int[] queue = new int[5];
    int size = 0;
    int front = 0;
    int rear = 0;

    /**
     * Get number of elements in the queue
     * @return number of elements in queue
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Insert data on the end of the queue
     * time: O(1)
     * @param data data to be inserted
     */
    @Override
    public void enqueue(int data) {
        if(isFull()) return;

        queue[(rear) % 5] = data;
        rear++;
        size++;
    }

    /**
     * Remove first data in the queue
     * time: O(1)
     * @return first data in the queue
     */
    @Override
    public Integer dequeue() {
        if(isEmpty()) return null;

        int data = queue[front % 5];
        front++;
        size--;
        return data;
    }

    /**
     * Returns if the queue is empty
     * @return true if the queue is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Returns if the queue is full
     * @return true if the queue is full, otherwise false
     */
    public boolean isFull() {
        return getSize() == 5;
    }

    /**
     * Builds simple String representation of the queue
     * @return String representation of the queue
     */
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder result = new StringBuilder("[");
        for(int i = 0;i < size - 1;i++){
            result.append(queue[(front + i) % 5]).append(", ");
        }
        result.append(queue[(rear - 1) % 5]).append("]");
        return result.toString();
    }
}
