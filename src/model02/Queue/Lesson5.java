package model02.Queue;

public class Lesson5 {

    public static void main(String[] args) {
//        ArrayQueue queue = new ArrayQueue(3);
//        queue.enqueue(1);
//        queue.enqueue(2);
//
//        queue.print();
//        queue.dequeue();
//        queue.print();
//
//        CircleQueue queue1 = new CircleQueue(3);
//        queue1.enqueue(1);
//        queue1.enqueue(2);
//        queue1.enqueue(3);
//
//        queue1.print();
//        queue1.enqueue(4);
//        queue1.print();
//        queue1.dequeue();
//        queue1.print();

//        StackQueue queue2 = new StackQueue();
//        queue2.enqueue(1);
//        queue2.enqueue(2);
//        queue2.enqueue(3);
//
//        queue2.print();
//        queue2.dequeue();
//        queue2.print();


        LinkedQueue queue3 = new LinkedQueue();
        queue3.enqueue(1);
        queue3.enqueue(2);
        queue3.enqueue(3);
        queue3.enqueue(4);

        queue3.print();
        System.out.println(queue3.dequeue());
        queue3.print();


    }
}
