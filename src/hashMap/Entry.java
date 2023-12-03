package src.hashMap;

public class Entry<K, V> implements IEntry<K, V> {
    /**
     * The key of the entry.
     */
    private K key;
    /**
     * The value of the entry.
     */
    private V value;

    /**
     * Constructs a new entry with the given key and value.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

}
