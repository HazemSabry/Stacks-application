package src.singlyNode;
/**
 *Represents a single linked list node.
 *
 * @param  <T> The type of elements stored in the node.
 */
public class SinglyNode<T> implements ISinglyNode<T> {
    /**
     * The data stored in the node.
     */
    private T data;
    /**
     * The Next node in the list.
     */
    private SinglyNode<T> next;
    /**
     * Constructs a new instance of the SinglyNode class with the given data and next node.
     * @param data
     * @param next
     */
    public SinglyNode(T data, SinglyNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public T getData() {
        return this.data;
    }
    @Override
    public void setData(T data) {
        this.data = data;
    }
    @Override
    public SinglyNode<T> getNext() {
        return this.next;
    }
    @Override
    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }
}

