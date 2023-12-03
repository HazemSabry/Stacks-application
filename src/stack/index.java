package src.stack;

import java.util.Scanner;

public class Index {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            Stack<Integer> stack = new Stack<Integer>();

            String inputLine = scanner.nextLine().replaceAll("\\[|\\]", "").trim();
            if (!inputLine.isEmpty()) {
                String[] elementsString = inputLine.split(", ");
                for (int i = elementsString.length-1; i>=0; i--)stack.push(Integer.parseInt(elementsString[i]));
            }

            while (scanner.hasNextLine()){
                switch (scanner.nextLine()) {
                    case "push":
                        stack.push(Integer.parseInt(scanner.nextLine()));
                        stack.printStack();
                        break;

                    case "pop":
                        stack.pop();
                        stack.printStack();
                        break;

                    case "peek":
                        System.out.println(stack.peek());
                        break;

                    case "isEmpty":
                        if (stack.isEmpty()) System.out.println("True");
                        else System.out.println("False");
                        break;

                    case "size":
                        System.out.println(stack.size());
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
