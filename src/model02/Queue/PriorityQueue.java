package model02.Queue;

import java.util.Arrays;
import java.util.Stack;

public class PriorityQueue {

    private int[] items; //1, 2, 3, 4
    private int count;

    public PriorityQueue(int n) {
       items = new int[n];
    }



    public int poll(){
        //delete first element
        //2, 3, 4
        return -1;
    }

//    public void add(int item){
//        /**
//         * o'sish tartibida arrayga elementni joylaydi
//         */
//    }

    public void enqueue(int item){
        /**
         * o'sish tartibida arrayga elementni joylaydi
         */
    }

    public int dequeue(){

        return -1;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void print(){
        System.out.println(Arrays.toString(items));
    }

}
