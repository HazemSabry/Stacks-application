package src.hashMap;

public interface IEntry<K, V> {
    /**
     * Returns the key corresponding to this entry.
     *
     * @return the key corresponding to this entry.
     */
    K getKey();

    /**
     * Returns the value corresponding to this entry.
     *
     * @return the value corresponding to this entry.
     */
    V getValue();

    /**
     * Sets the value corresponding to this entry.
     *
     * @param value
     */
    void setValue(V value);
}
