package model02.ArrayList;

public class Lesson2 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList(3);
        list.add(1);
        list.add(2);

        list.print();
        list.insert(3);
        list.print();
        System.out.println(list.max());
        System.out.println(list.min());
        list.reverse();
        list.print();

    }
}
