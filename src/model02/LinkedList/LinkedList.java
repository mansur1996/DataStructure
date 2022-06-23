package model02.LinkedList;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    // O(1)
    public int size(){
        return size;
    }

    // O(n)
    public int[] toArray(){
        int[] array = new int [size];
        var current = first;
        int index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    //O(1)
    public void removeStart(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last) first = last = null;
        else{
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    //O(n)
    public void removeEnd(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
        }else{
            last = getPrevious(last);
            last.next = null;
        }
        size--;
    }

    // O(n)
    private Node getPrevious(Node last) {
        Node current  = first;

        while (current != null){
            if (current.next == last){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    //O(n)
    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    //O(n)
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while (current != null){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    //O(1)
    public void addEnd(int item){
        var note = new Node(item);
        if(isEmpty()){
            first = last = note;
        }else{
            last.next = note;
            last = note;
        }
        size++;
    }

    //O(1)
    public void addStart(int item){
        var note = new Node(item);
        if(isEmpty()){
            first = last = note;
        }else{
             note.next = first;
             first = note;
        }
        size++;
    }

    private boolean isEmpty(){
        return first == null;
    }

    // O(n)
    public void print(){
        Node temp = first;

        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // O(n)
    public boolean search(int item){
        Node current = first;
        while (current != null){
            if (current.value == item) return true;
            current = current.next;
        }
        return false;
    }

    // O(n)
    public int lastIndexOf(int item){
        int lastIndex = -1;
        int index = 0;
        Node current = first;
        while (current != null){
            if(current.value == item) lastIndex = index;
            index++;
            current = current.next;
        }

        return lastIndex;
    }

    // O(n)
    public int getMiddleElement(){
        if (first == null) throw new EmptyStackException();
        int index = 0;
        int midItem = 0;
        Node current = first;
        while (current != null){
            if (index == size/2) midItem = current.value;
            index++;
            current = current.next;
        }
        return midItem;
    }

    // O()
    public int getKthFromEnd(int k){
        if (k < 0 && k >= size) throw new IllegalArgumentException();
        if (first == null) throw new EmptyStackException();
        int index = 0;
        int KthItem = 0;
        Node current = first;
        while (current != null){
            if (index == size - k) KthItem = current.value;
            index++;
            current = current.next;
        }
        return KthItem;
    }

    // O()
    public void reverse(){

    }
}
