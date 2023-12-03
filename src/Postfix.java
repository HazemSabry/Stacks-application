package src;

import src.stack.Stack;
import src.queue.Queue;
import src.hashMap.HashMap;

public class Postfix implements IPostfix {
    private Stack<String> stack;
    private Queue<String> queue;
    private HashMap<String, Integer> priorityHashMap;

    public Postfix(){
        this.stack = new Stack<String>();
        this.queue = new Queue<String>();
        this.priorityHashMap = new HashMap<String, Integer>();
        this.priorityHashMap.put("+",1);
        this.priorityHashMap.put("-",1);
        this.priorityHashMap.put("*",2);
        this.priorityHashMap.put("/",2);
        this.priorityHashMap.put("^",3);
    }

    private boolean isCharacter(String s){
        return Character.isLetter(s.charAt(0));
    }

    private boolean isOperant(String s){
        return (s.equals("+") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^"));
    }

    @Override
    public String infixToPostfix(String expression) throws IllegalArgumentException {
        String[] infixTerms = expression.split("");
        boolean character = false;
        boolean operant = false;

        for (String term : infixTerms) {
            if(this.isCharacter(term)){
                if(character) throw new IllegalArgumentException();
                character = true;
                operant = false;

                queue.enqueue(term);

            }else if(this.isOperant(term)){
                final int termPriority = this.priorityHashMap.get(term);

                if(operant && !term.equals("-")) throw new IllegalArgumentException();
                else if (operant && term.equals("-")) {
                    Stack<String> tempStack = new Stack<String>();

                    while (termPriority != this.priorityHashMap.get(this.stack.peek())) tempStack.push(this.stack.pop());

                    String temp = this.stack.pop();
                    if(temp.equals("+")) this.stack.push("-");
                    else if(temp.equals("-")) this.stack.push("+");

                    while(!tempStack.isEmpty()) this.stack.push(tempStack.pop());
                    continue;
                }
                operant = true;
                character = false;


                while(!this.stack.isEmpty()){
                    int topPriority = this.priorityHashMap.get(this.stack.peek());
                    if (termPriority > topPriority) break;
                    this.queue.enqueue(this.stack.pop());
                }
                this.stack.push(term);

            }else throw new IllegalArgumentException();
        }

        while (!this.stack.isEmpty()) this.queue.enqueue(this.stack.pop());

        return this.queue.toString();
    }

    @Override
    public int evaluate(String expression) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
    }

}
