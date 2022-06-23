package model02.HashTable;

import java.util.HashMap;

public class Lesson6 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");
        hashTable.put(2, "Four");

        System.out.println(hashTable);
        hashTable.remove(1);
        System.out.println(hashTable);

    }
}
