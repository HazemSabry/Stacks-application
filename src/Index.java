package src;

import java.util.Scanner;

public class Index {
    public static void main (String[] args) {
        Postfix postfix = new Postfix();
        try (Scanner scanner = new Scanner(System.in)) {
            String prefixString = postfix.infixToPostfix(scanner.nextLine());
            System.out.println(prefixString);
            while (scanner.hasNext()) postfix.setVariableValue(scanner.nextLine());
            System.out.println(postfix.evaluate(prefixString));
        }catch(Exception e){
            System.out.println("Error");
        }

        // try {
        //     String prefixString = postfix.infixToPostfix("");
        //     postfix.setVariableValue("a=-2", "b=8", "c=-3");
        //     System.out.println(prefixString);
        //     System.out.println(postfix.evaluate(prefixString));
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }
}
