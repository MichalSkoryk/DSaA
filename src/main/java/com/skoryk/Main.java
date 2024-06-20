package com.skoryk;


import com.skoryk.data.structures.Queue.Queue;
import com.skoryk.data.structures.Queue.QueueOnArray;

public class Main {
    public static void main(String[] args) {
        Queue q = new QueueOnArray();
        q.enqueue(34);
        q.enqueue(3);
        System.out.println(q);
    }
}