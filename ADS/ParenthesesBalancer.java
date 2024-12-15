// Write a program for balancing the parentheses using Stack.

import java.util.Scanner;
import java.util.Stack;
public class ParenthesesBalancer {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression with parentheses: ");
        String expression = scanner.nextLine();
        if (isBalanced(expression)) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
        scanner.close();
    }
}