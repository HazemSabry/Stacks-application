package src.queue;

import java.util.NoSuchElementException;

/**
 * A basic interface representing a queue data structure.
 *
 * @param <T> The type of elements stored in the queue.
 */
public interface IQueue<T> {
    /**
     * Adds an element to the rear of the queue.
     *
     * @param element The element to be added to the queue.
     */
    void enqueue(T element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @throws java.util.NoSuchElementException If the queue is empty.
     */
    T dequeue() throws NoSuchElementException;

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return The element at the front of the queue.
     * @throws java.util.NoSuchElementException If the queue is empty.
     */
    T peek() throws NoSuchElementException;

    /**
     * Checks if the queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the size of the queue.
     *
     * @return The size of the queue.
     */
    int size();
}
