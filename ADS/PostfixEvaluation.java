// Write a program to evaluate the Postfix expression using Stack.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
public class PostfixEvaluation {
    public static int evaluatePostfix(String expression, Map<Character, Integer> operandValues) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (operandValues.containsKey(c)) {
                    stack.push(operandValues.get(c));
                } else {
                    throw new IllegalArgumentException("Operand value for '" + c + "' not provided.");
                }
            }
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push((int) Math.pow(a, b));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a postfix expression: ");
        String postfixExpression = scanner.nextLine();
        Map<Character, Integer> operandValues = new HashMap<>();
        for (char c : postfixExpression.toCharArray()) {
            if (Character.isLetter(c) && !operandValues.containsKey(c)) {
                System.out.print("Enter value for " + c + ": ");
                operandValues.put(c, scanner.nextInt());
            }
        }
        try {
            int result = evaluatePostfix(postfixExpression, operandValues);
            System.out.println("The result of the postfix evaluation is: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}