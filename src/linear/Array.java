package linear;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        count = 0;
        items = new int[length];
    }

    public Array() {
        count = 0;
        items = new int[1];
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[count + count + 1 / 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = item;
    }

    public void insertAt(int index, int item) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public int get(int index) {
        if (index < 0 || index > count - 1)
            throw new IllegalArgumentException();
        return items[index];
    }

    public void removeAt(int index) {
        if (index < 0 || index > count - 1)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++) {
            if (i + 1 == count) {
                items[i] = 0;
                break;
            }

            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public int max() {
        int max = 0;
        for (int item : items)
            if (item > max)
                max = item;
        return max;
    }

    public Array intersect(Array array) {
        Array common = new Array(1);
        for (int item : this.items)
            for (int innerItem : array.items)
                if (innerItem == item)
                    common.insert(item);
        return common;
    }

    public void reverse() {
        int start = 0;
        int end = count - 1;


        for (int i = 0; i < items.length; i++) {
            if (start >= end) return;

            int temp = items[start];
            items[start] = items[end];
            items[end] = temp;
            start++;
            end--;
        }
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String itemsStr = "[";
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                itemsStr += items[i];
                break;
            }
            itemsStr += items[i] + ", ";
        }
        itemsStr += "]";
        return "linear.Array{" +
                "items=" + itemsStr +
                ", count=" + count +
                '}';
    }
}
