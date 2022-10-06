package stacks;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        final Stack<String> stack = new LinkedListStack<String>();

        final Scanner conIn = new Scanner(System.in);
        conIn.useDelimiter("\n");
        try {
            System.out.println("This program reverses a sequence of strings.");
            System.out.println("Enter one or more strings, pressing <return> or <enter> between them.");
            System.out.println("Enter a single '.' to stop.");
            String string = conIn.next();

            while (!string.equals(".")) {
                stack.push(string);
                System.out.println("The last string entered was: " + stack.peek());
                System.out.println("Enter another string, or '.' to stop and print the reversed strings:");
                string = conIn.next();
            }

        } finally {
            conIn.close();
        }
        System.out.println("Input terminated. Reversed strings follow:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}