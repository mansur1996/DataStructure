package model02.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;

    public ArrayQueue(int n){
        items = new int[n];
    }

    public void enqueue(int item){
        if(rear == items.length){
            throw new StackOverflowError();
        }
        items[rear++] = item;
    }

    public int dequeue(){
        int item = items[front];
        items[front] = 0;
        front++;
        return item;
    }

    public void print(){
        var content = Arrays.copyOfRange(items, front, rear);
        System.out.println(Arrays.toString(content));
    }

}
