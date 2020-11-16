package Data_Structure.linear;

import kotlin.UninitializedPropertyAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private String expression;
    private static final List<Character> leftBrackets =
            Arrays.asList('(', '<', '[', '{');
    private static final List<Character> rightBrackets =
            Arrays.asList(')', '>', ']', '}');

    public Expression(String exp) {
        this.expression = exp;
    }

    public boolean isBalanced() {
        if (expression == null)
            throw new UninitializedPropertyAccessException();

        var stack = new Stack<Character>();

        for (char ch : expression.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            else if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    private static boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private static boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private static boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }
}
