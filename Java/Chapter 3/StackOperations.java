package ChapterThree;

public class StackOperations {

    // Method to reverse a stack
    public static LinkedListStack reverseStack(LinkedListStack stack) {
        LinkedListStack tempStack = new LinkedListStack();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        return tempStack;
    }

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        LinkedListStack stack = new LinkedListStack();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Method to check if parentheses are balanced
    public static boolean isBalancedParentheses(String expression) {
        LinkedListStack stack = new LinkedListStack();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = (char) stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Testing Reverse Stack
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Original Stack:");
        stack.displayStack();

        stack = reverseStack(stack);
        System.out.println("Reversed Stack:");
        stack.displayStack();

        // Testing Postfix Expression Evaluation
        String postfixExpression = "53+82-*"; // (5 + 3) * (8 - 2) = 48
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Postfix Evaluation Result: " + result);

        // Testing Parentheses Matching
        String expr1 = "{[()]}"; // Balanced
        String expr2 = "{[(])}"; // Not Balanced
        System.out.println("Is Balanced: " + isBalancedParentheses(expr1)); // true
        System.out.println("Is Balanced: " + isBalancedParentheses(expr2)); // false
    }
}

