package src.queue;
import java.util.NoSuchElementException;

import src.singlyNode.SinglyNode;
/**
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
public class Queue<T> implements IQueue<T> {
    /**
     * Dummy heeder.
     */
    private SinglyNode<T> header;
    /**
     * Rear point to the last element in the queue.
     */
    private SinglyNode<T> rear;
    /**
     * The queue size.
     */
    private int size;

    /**
     * Constructs a new instance of the queue with a Dummy header, rear pointing to the Dummy header and size zero.
     */
    public Queue(){
        this.header = new SinglyNode<T>(null,null);
        this.rear = this.header;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        SinglyNode<T> newSinglyNode = new SinglyNode<T>(element, null);
        this.rear.setNext(newSinglyNode);
        this.rear = newSinglyNode;
        this.size++;
    }

    @Override
    public T dequeue() throws NoSuchElementException{
        if (this.size() == 0) throw new NoSuchElementException();
        T data = this.header.getNext().getData();
        this.header.setNext(this.header.getNext().getNext());
        this.size--;
        return data;
    }

    @Override
    public T peek() throws NoSuchElementException{
        if (this.size==0) throw new NoSuchElementException();
        return this.header.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }
    /**
     * Represents the queue elements as a single string.
     * @return the String representation of this queue element.
     */
    public String toString(){
        SinglyNode<T> pointer = this.header;
        String string = "";

        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            string += pointer.getData();
        }

        return string;
    }
}
