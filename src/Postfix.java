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

    @Override
    public String infixToPostfix(String expression) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'infixToPostfix'");
    }

    @Override
    public int evaluate(String expression) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
    }

}
