import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {

    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void add(int index, int item) {
        if (index > size || index < 0)
            throw new IllegalArgumentException();

        var node = new Node(item);
        if (index == 0) {
            node.next = first;
            first = node;
            size++;
            return;
        }

        var i = 0;
        var previous = first;
        while (i < index - 1) {
            previous = previous.next;
            i++;
        }
        var current = previous.next;
        previous.next = node;
        node.next = current;

        size++;
    }

    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void remove(int index) {
        if (index > size - 1 || index < 0)
            throw new IllegalArgumentException();

        if (index == 0) {
            var temp = first;
            first = first.next;
            temp.next = null;
            size--;
            return;
        }


        var i = 0;
        var previous = first;
        while (i < index - 1) {
            previous = previous.next;
            i++;
        }
        var current = previous.next;
        previous.next = current.next;
        current.next = null;

        size--;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var preOfLast = getPrevious(last);
            last = preOfLast;
            last.next = null;
        }
        size--;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;


        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }

    public int getKthFromTheEnd(int k) {
        // [10 -> 20 -> 30 -> 40 -> 50]
        //  *           *
        // k = 3
        // distance = k - 1 = 2;

        if (isEmpty() || k <= 0 || k > size)
            throw new IllegalArgumentException();

        var first = this.first;
        var second = first;
        var distance = k - 1;
        for (int i = 0; i < distance; i++)
            second = second.next;

        while (second != last) {
            first = first.next;
            second = second.next;
        }

        return first.value;
    }

    public void printMiddle() {
        if (isEmpty()) throw new IllegalStateException();

        var a = this.first;
        var b = this.first;

        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last)
            System.out.println("Odd -> The middle of this LinkedList is: " + a.value);
        else
            System.out.println("Even -> The middle of this LinkedList are: " + a.value + ", " + a.next.value);
    }

    public boolean hasLoop() {
        var a = this.first;
        var b = this.first;

        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        return last.next == a;


    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current.next != node)
            current = current.next;
        return current;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        if (first == null)
            return new int[0];
        var array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public static void main(String[] args) {
        var list = new LinkedList();
        System.out.println(Arrays.toString(list.toArray()));
    }
}


