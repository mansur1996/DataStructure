package model02.LinkedList;

public class Lesson3 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addEnd(1);
        list.addEnd(2);
        list.addStart(0);
        list.addEnd(2);
        list.addEnd(1);

        list.print();
        System.out.println(list.contains(10));
        System.out.println(list.lastIndexOf(2));
    }
}
