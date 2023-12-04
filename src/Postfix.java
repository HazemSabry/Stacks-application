package src;

import src.stack.Stack;
import src.queue.Queue;
import src.hashMap.HashMap;

import java.util.NoSuchElementException;

/**
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
public class Postfix implements IPostfix {
    private Stack<String> stack;
    private Queue<String> queue;
    private HashMap<String, Integer> priorityHashMap;
    private HashMap<String, Integer> variableValuesHashMap;


    /**
     * Construct a new postfix with new Stack<String> and new Queue<String> and new PriorityHashMap<Integer> containing the priority of the mathematics operations.
     */
    public Postfix(){
        this.stack = new Stack<String>();
        this.queue = new Queue<String>();
        this.priorityHashMap = new HashMap<String, Integer>();
        this.priorityHashMap.put("+",1);
        this.priorityHashMap.put("-",1);
        this.priorityHashMap.put("*",2);
        this.priorityHashMap.put("/",2);
        this.priorityHashMap.put("^",3);
        this.priorityHashMap.put("(",0);
        this.variableValuesHashMap = new HashMap<String, Integer>();
    }

    /**
     * Checks if the given one digit string is a letter or not.
     * @param s one digit string.
     * @return true if the given one digit string is a letter, false otherwise.
     */
    private boolean isCharacter(String s){
        return Character.isLetter(s.charAt(0));
    }

    /**
     * Checks if the given one digit string is one of + or - or * or / or ^;
     * @param s one digit string.
     * @return true if the string is one of + or - or * or / or ^ , false otherwise.
     */
    private boolean isOperant(String s){
        return (s.equals("+") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^"));
    }

    /**
     *
     * @param expression string as"a=4"
     * @throws IllegalArgumentException
     */
    public void setVariableValue(String ...expression)throws IllegalArgumentException{
        for (String string : expression) {
            String[] tempArrString = string.split("=");
            this.variableValuesHashMap.put(tempArrString[0], Integer.parseInt(tempArrString[1]));
        }
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

                    while (termPriority < this.priorityHashMap.get(this.stack.peek())) tempStack.push(this.stack.pop());

                    String temp = this.stack.pop();
                    if(temp.equals("+")) this.stack.push("-");
                    else if(temp.equals("-")) {
                        if(this.queue.size() > 0)this.stack.push("+");
                    }else{
                        this.stack.push(temp);
                        this.stack.push("-");
                    }

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

            }else if(term.equals("(")){
                this.stack.push(term);
            }else if(term.equals(")")){
                while (!this.stack.peek().equals("(")) this.queue.enqueue(this.stack.pop());
                this.stack.pop();
            }else throw new IllegalArgumentException();
        }

        while (!this.stack.isEmpty()) this.queue.enqueue(this.stack.pop());

        return this.queue.toString();
    }

    @Override
    public int evaluate(String expression) throws NoSuchElementException, IllegalArgumentException {
        Stack<Integer> tempStack = new Stack<Integer>();

        String[] operants = expression.split("");
        for (String operant : operants) {
            if(this.isCharacter(operant)) tempStack.push(this.variableValuesHashMap.get(operant));
            else if(this.isOperant(operant)){
                int second = tempStack.pop();
                int first;

                if(operant.equals("+")){
                    if(tempStack.isEmpty()) first =0;
                    else first = tempStack.pop();
                    tempStack.push(first + second);
                }else if(operant.equals("-")){
                    if(tempStack.isEmpty()) first =0;
                    else first = tempStack.pop();
                    tempStack.push(first - second);
                }else if(operant.equals("*")){
                    if(tempStack.isEmpty()) throw new IllegalArgumentException();
                    else first = tempStack.pop();
                    tempStack.push(first * second);
                }else if(operant.equals("/")){
                    if(tempStack.isEmpty()) throw new IllegalArgumentException();
                    else first = tempStack.pop();
                    tempStack.push(first / second);
                }else if(operant.equals("^")){
                    if(tempStack.isEmpty()) throw new IllegalArgumentException();
                    else first = tempStack.pop();
                    tempStack.push((int)Math.pow(first, second));
                }

           } else throw new IllegalArgumentException();
        }

        if(tempStack.size() > 1) throw new IllegalArgumentException();

        return tempStack.pop();
    }

}
