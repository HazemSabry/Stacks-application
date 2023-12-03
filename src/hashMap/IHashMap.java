package src.hashMap;

import java.util.NoSuchElementException;

/**
 * A basic interface representing a hashmap data structure.
 *
 * @param <K> The type of key stored in the hashmap.
 * @param <V> The type of value stored in the hashmap.
 */
public interface IHashMap<K, V> {

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated.
     * @param value the value to be associated with the specified key.
     */
    void put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped, or {@code null} if no mapping exists.
     */
    V get(K key)throws NoSuchElementException;

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key the key whose mapping is to be removed from the map.
     */
    void remove(K key)throws NoSuchElementException;

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map.
     */
    int size();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings.
     */
    boolean isEmpty();

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    void clear();
}

