import java.util.EmptyStackException;

/**
 * An interface representing a stack data structure.
 */
public interface IStack<T> {

    /**
     * Removes the element at the top of the stack and returns that element.
     *
     * @return The top of the stack element.
     * @throws EmptyStackException If the stack is empty.
     */
    public T pop() throws EmptyStackException;

    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return The top of the stack element.
     * @throws EmptyStackException If the stack is empty.
     */
    public T peek() throws EmptyStackException;

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param element The object to insert.
     */
    public void push(T element);

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Gets the size of the stack.
     *
     * @return The size of the stack.
     */
    public int size();
}
