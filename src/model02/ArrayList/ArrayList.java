package model02.ArrayList;

import java.util.EmptyStackException;

public class ArrayList {

    private int[] items;
    private int count;

    public ArrayList(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void add(int item) {
        //resize array
        if (items.length == count) {
            resizeItems();
        }
        items[count++] = item;
    }

    private void resizeItems() {
        int[] newItems = new int[count * 2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    public void insert(int item) {
        if (items.length == count) {
            resizeItems();
        }
        items[count++] = item;
    }

    public void insertAt(int index, int item) {
        isValid(index);

        if (count == items.length) {
            resizeItems();
        }

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];

            count++;
            items[index] = item;
        }
    }

    /**
     // 1 2 3 4 5
     * 3 - o'chiramiz
     // 1 2 4 5 5
     * Xotirada o'chirilmasdan qolib ketadi
     */
    public void removeAt(int index) {
        isValid(index);

        for (int i = index; i < count-1; i++) {
            items[i] = items[i+1];
        }
        count--;
    }

    public void printAt(int index) {
        isValid(index);
        System.out.println(items[index]);
    }

    public void isValid(int index){
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
    }

    public int max(){
        if (count == 0) throw new EmptyStackException();
        int maxItem = items[0];
        for (int i = 1; i < count; i++)
            if (maxItem < items[i]) maxItem = items[i];
        return maxItem;
    }

    public int min(){
        if (count == 0) throw new EmptyStackException();
        int minItem = items[0];
        for (int i = 1; i < count; i++)
            if (minItem > items[i]) minItem = items[i];
        return minItem;
    }

    public int[] reverse(){
        if (count < 2){
            return items;
        }
        for (int i = 0; i < count/2; i++){
            int buff = items[i];
            items[i] = items[count-1 - i];
            items[count - 1 - i] = buff;
        }
        return items;
    }
}
