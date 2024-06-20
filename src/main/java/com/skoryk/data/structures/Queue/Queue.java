package com.skoryk.data.structures.Queue;

public interface Queue {

    int getSize();
    void enqueue(int data);
    Integer dequeue();
    boolean isEmpty();
}
