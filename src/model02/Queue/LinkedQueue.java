package model02.Queue;

import model02.LinkedList.LinkedList;

import java.util.Arrays;

public class LinkedQueue {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public LinkedQueue() {
        this.first = null;
        this.last = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Dequeue qildanda o'chirilgan element qaytarilmayabdi
     */
    public int dequeue() {
        if (isEmpty()) return -1;
        Node second;
        int value = first.value;
        if (first == last) {
            second = first;
            first = last = null;
        } else {
            second = first.next;
            first = first.next;
        }
        size--;
        return second.value;
    }

}
