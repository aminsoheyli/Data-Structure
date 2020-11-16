package Data_Structure.linear;

import java.util.Arrays;

public class TwoStacks {
    private int top1;
    private int top2;
    private int[] items;

    public TwoStacks(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }


    public void push1(int item) {
        if (isFull1())
            resize();

        items[++top1] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[top1--];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isFull1() {
        return top1 + 1 == top2;
    }

    public void push2(int item) {
        if (isFull2())
            resize();

        items[--top2] = item;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return items[top2++];
    }

    public boolean isEmpty2() {
        return top2 == items.length;
    }

    private void resize() {
        var length = items.length;
        var newItems = new int[length + length / 2];
        for (int i = 0; i <= top1; i++)
            newItems[i] = items[i];

        var length2 = length - top2;
        var index = newItems.length - length2;
        for (int i = top2; i < items.length; i++)
            newItems[index++] = items[i];

        top2 = top2 == items.length ? newItems.length : newItems.length - length2;
        items = newItems;
    }

    public boolean isFull2() {
        return top2 - 1 == top1;
    }

    @Override
    public String toString() {
        if (isFull1() || isFull2())
            return Arrays.toString(items);

        var arr1 = Arrays.copyOfRange(items, 0, top1 + 1);
        var arr2 = Arrays.copyOfRange(items, top2, items.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        return Arrays.toString(items);
    }
}
