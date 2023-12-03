import java.util.EmptyStackException;
/**
 *  Represents a stack data structure implemented using a singly linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class Stack<T> implements IStack<T> {
    /**
     * Dummy header node.
     */
    private SinglyNode<T> header;
    /**
     * The size of the stack.
     */
    private int size;
    /**
     * Constructs a new instance of the stack with the size zero and a Dummy header.
     */
    public Stack(){
        this.header = new SinglyNode<T>(null,null);
        this.size = 0;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.size == 0) throw new EmptyStackException();
        T popElement = this.header.getNext().getData();
        this.header.setNext(this.header.getNext().getNext());
        return popElement;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (this.size==0) throw new EmptyStackException();
        return this.header.getNext().getData();
    }

    @Override
    public void push(T element) {
        SinglyNode<T> newSinglyNode = new SinglyNode<T>(element, this.header.getNext());
        this.header.setNext(newSinglyNode);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

}
