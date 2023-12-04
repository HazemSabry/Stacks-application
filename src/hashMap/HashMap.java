package src.hashMap;

import java.util.NoSuchElementException;

import src.singlyNode.SinglyNode;
/**
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
public class HashMap<K, V> implements IHashMap<K, V> {
    /**
     * Dummy header.
     */
    private SinglyNode<Entry<K, V>> header;
    /**
     * The siz of the HashMap.
     */
    private int size;

    /**
     * Constructs a new instance of the hashMap with a Dummy header and the size zero.
     */
    public HashMap(){
        this.header = new SinglyNode<Entry<K, V>>(null, null);
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        SinglyNode<Entry<K, V>> pointer = this.header;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            if (pointer.getData().getKey().equals(key)) {
                pointer.getData().setValue(value);
                return;
            }
        }
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        SinglyNode<Entry<K, V>> newSinglyNode = new SinglyNode<Entry<K, V>>(newEntry, null);
        pointer.setNext(newSinglyNode);
    }

    @Override
    public V get(K key) throws NoSuchElementException{
        SinglyNode<Entry<K, V>> pointer = this.header;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            if (pointer.getData().getKey().equals(key)) return pointer.getData().getValue();
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove(K key) throws NoSuchElementException{
        SinglyNode<Entry<K, V>> pointer = this.header;
        while (pointer.getNext() != null) {
            if (pointer.getNext().getData().getKey().equals(key)) pointer.setNext(pointer.getNext().getNext());
            pointer = pointer.getNext();
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return this.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public void clear() {
        this.header.setNext(null);
    }

}
