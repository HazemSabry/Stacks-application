package src.singlyNode;
/**
 * Single Linked List Node with containing data element and next element.
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
public interface ISinglyNode<T> {
    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    T getData();

    /**
     * Sets the data for the node.
     *
     * @param data The data to be set in the node.
     */
    void setData(T data);

    /**
     * Gets the next node in the linked list.
     *
     * @return The next node in the linked list, or null if there is no next node.
     */
    SinglyNode<T> getNext();

    /**
     * Sets the next node in the linked list.
     *
     * @param next The next node to be set.
     */
    void setNext(SinglyNode<T> next);
}
