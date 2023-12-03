package src;

public class Index {
    public static void main (String[] args) {
        Postfix postfix = new Postfix();

        try {
            System.out.println(postfix.infixToPostfix("a-g^f/b*-c/f"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
