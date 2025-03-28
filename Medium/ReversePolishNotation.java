import java.util.Stack;

public class ReversePolishNotation {
    public int calculate(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return a / b;
        }
    }

    public boolean isOperator(char token) {
        return (token == '+' || token == '-' || token == '*' || token == '/');
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i].charAt(0))) {
                int a = nums.pop();
                int b = nums.pop();

                // Swap to preserve division ordering (a / b)
                int result = calculate(b, a, tokens[i]);
                nums.push(result);
            }
            else {
                nums.push(Integer.valueOf(tokens[i]));
            }
        }
        return nums.pop();
    }
}
