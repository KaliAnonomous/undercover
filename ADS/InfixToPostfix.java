// Write a program to convert Infix to Postfix expression using Stack

import java.util.Stack;
public class InfixToPostfix {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println("Invalid expression");
                    return null;
                }
            }
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Invalid expression");
                return null;
            }
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infixExpression);
        String postfixExpression = infixToPostfix(infixExpression);
        if (postfixExpression != null) {
            System.out.println("Postfix Expression: " + postfixExpression);
        }
    }
}
