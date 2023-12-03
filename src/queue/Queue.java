package src.queue;
import java.util.NoSuchElementException;

import src.singlyNode.SinglyNode;

public class Queue<T> implements IQueue<T> {
    private SinglyNode<T> header;
    private SinglyNode<T> rear;
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

}
