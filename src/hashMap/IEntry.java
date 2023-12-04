package src.hashMap;
/**
 * An interface of Entry containing the key and its value.
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
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
