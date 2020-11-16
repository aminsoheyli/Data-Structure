package Data_Structure.linear;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[20];
    private int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();
        return items[count - 1];
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    public void push(int item) {
        resizeIfNeeded();
        items[count++] = item;
    }

    private void resizeIfNeeded() {
        var length = items.length;
        if (count == length) {
            var newValues = new int[length + length / 2];
            for (int i = 0; i < length; i++)
                newValues[i] = items[i];
            items = newValues;
        }
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
