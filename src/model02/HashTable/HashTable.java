package model02.HashTable;

import java.util.LinkedList;

public class HashTable {

    class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable() {
        entries = new LinkedList[5];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (LinkedList<Entry> list : entries){
            if (list != null){
                for (Entry entry : list){
                    str.append(entry.key).append(" : ").append(entry.value).append(" ");
                }
                str.append("\n");
            }
        }
        return str.toString();
    }

    private int hash(int key){
        return key % entries.length;
    }

    public void put(int key, String value){
        int index = hash(key);

        if (entries[index] == null) entries[index] = new LinkedList<>();

        LinkedList<Entry> list = entries[index];

        for (Entry entry : list){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }

        Entry entry = new Entry(key, value);
        list.addLast(entry);
    }

    public String get(int key){
        Entry entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    private Entry getEntry(int key) {
        int index = hash(key);
        LinkedList<Entry> list = entries[index];
        if (list != null){
            for (Entry entry : list){
                if (entry.key == key){
                    return entry;
                }
            }
        }
        return null;
    }

    public boolean remove(int key){
        int index = hash(key);

        Entry entry = getEntry(key);
        if (entry != null){
            entries[index].remove(entry);
            return true;
        }
        return false;
    }

    public int size(){
        int size = 0;
        for(LinkedList<Entry> list : entries){
            if (list != null) size+= list.size();
        }
        return size;
    }

}
