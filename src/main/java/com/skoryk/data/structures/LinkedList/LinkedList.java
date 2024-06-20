package com.skoryk.data.structures.LinkedList;

public class LinkedList {
    Node head;

    /**
     * Function returns status of the list
     * time: O(1)
     * @return if the list is empty or not
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Function appends the data at the end of the list
     * time: O(n) where n is length of list
     * @param data data to be stored
     */
    public void append(int data){
        Node node = new Node(data);

        if(this.isEmpty())
            head = node;
        else {
            Node n = head;
            while(n.next != null)
                n = n.next;
            n.next = node;
        }
    }

    /**
     * Function appends data at the front of the list
     * time: O(1)
     * @param data data to be stored
     */
    public void shift(int data){
        if(this.isEmpty())
            this.head = new Node(data);
        else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    /**
     * Insert data in the desired place
     * time: O(n) where n is length of list to index of data to delete
     * @param data data to be stored
     * @param index index where to insert data
     */
    public void insert(int data, int index){
        if(this.isEmpty())
            this.head = new Node(data);
        else if(index == 0){
            this.shift(data);
        } else {
            Node node = new Node(data);
            Node n = head;
            for(int i = 0; i < index - 1; i++){
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    /**
     * Function deletes data from linked list
     * time: O(n) where n is length of list to index of data to delete
     * @param index index of data to delete
     */
    public void delete(int index){
        if(this.isEmpty()) return;
        if(index == 0) {
            this.head = this.head.next;
        } else {
            Node n = head;
            for(int i = 0; i < index - 1; i++){
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    /**
     * Iterates through list and writes the values out
     * time: O(n) where n is the length of the list
     * @return string representation of linked list
     */
    @Override
    public String toString(){
        if(this.isEmpty()) return "[]";
        StringBuilder result = new StringBuilder("[");
        Node node = head;
        while(node.next != null){
            result.append(node.data).append(", ");
            node = node.next;
        }
        result.append(node.data).append("]");
        return result.toString();
    }
}
