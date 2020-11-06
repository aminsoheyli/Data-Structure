package linear;

/**
 * This class can retrieve the min/max in constant time of O(1).
 */
public class MinMaxStack {

    private final Stack stack = new Stack();
    private final Stack minStack = new Stack();
    private final Stack maxStack = new Stack();

    public void push(int item) {
        stack.push(item);
        if (minStack.isEmpty())
            minStack.push(item);
        else if (item <= minStack.peek())
            minStack.push(item);

        if (maxStack.isEmpty())
            maxStack.push(item);
        else if (item >= maxStack.peek())
            maxStack.push(item);
    }

    public int pop() {
        if (stack.isEmpty())
            throw new IllegalStateException();

        var top = stack.pop();

        if (top == minStack.peek())
            minStack.pop();

        if (top == maxStack.peek())
            maxStack.pop();

        return top;
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public int max() {
        return maxStack.peek();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
