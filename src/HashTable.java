import javax.swing.*;
import java.util.Hashtable;
import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 5;
    private LinkedList<Entry>[] entries = new LinkedList[SIZE];

    public void put(int key, String value) {
        int index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket)
            if (entry.key == key) {
                entry.value = value;
                return;
            }

        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);
        var bucket = entries[index];

        if (bucket != null)
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry.value;

        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        var bucket = entries[index];

        if (bucket == null)
            throw new IllegalStateException();

        for (Entry entry : bucket)
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }

        throw new IllegalStateException();
    }


    private int hash(int key) {
        return key % entries.length;
    }

    public static void main(String[] args) {
        var table = new HashTable();
        table.put(0, "0");
        table.put(1, "1");
        table.put(2, "2");
        table.put(3, "3");
        table.put(4, "4");
        table.put(5, "5");
        table.put(2, "12");
        System.out.println();
    }
}
