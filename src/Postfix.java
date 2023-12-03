package src;

import src.stack.Stack;
import src.queue.Queue;
import src.hashMap.HashMap;

public class Postfix implements IPostfix {
    private Stack<String> stack;
    private Queue<String> queue;
    private HashMap<String, Integer> priorityHashMap;

    public Postfix(){
        stack = new Stack<String>();
        queue = new Queue<String>();
        priorityHashMap = new HashMap<String, Integer>();
        priorityHashMap.put("+",1);
        priorityHashMap.put("-",1);
        priorityHashMap.put("*",2);
        priorityHashMap.put("/",2);
        priorityHashMap.put("^",3);
    }

    private boolean isCharacter(String s){
        return Character.isLetter(s.charAt(0));
    }

    @Override
    public String infixToPostfix(String expression) {
        String[] infixTerms = expression.split("");
    }

    @Override
    public int evaluate(String expression) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
    }

}
