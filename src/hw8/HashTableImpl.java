package hw8;

import java.util.HashSet;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Item<K,V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

        public Item<K, V> getNext() {
            return next;
        }

        public void setNext(Item<K, V> next) {
            this.next = next;
        }
    }

    private final HashSet<Item<K, V>>[] data;
//    private final LinkedList<Item<K,V>> chain;

    private final Item<K, V> emptyItem;

    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data =  new HashSet[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) return false;

        int index = hashFunc(key);

        if(data[index] == null) {
            data[index] = new HashSet<>();
        }
        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    protected int getStep(K key) {
        return 1;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            HashSet<Item<K, V>> item = data[index];
            if (item == null) {
                break;
            } else{
                for(Item<K,V> i : item){
                    if(isKeysEquals(i, key)) return index;
                }
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        try {
            if (data[index] == null) return null;
            else {
                HashSet<Item<K, V>> item = data[index];
                for (Item<K, V> i : item) {
                    if (i.getKey() == key) return i.getValue();
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (index == -1) return null;

        HashSet<Item<K,V>> item = data[index];
        Item<K,V> tmp = search(key, item);
        data[index].remove(tmp);
        return tmp == null ? null : tmp.getValue();
    }

    private Item<K,V> search(K key, HashSet<Item<K,V>> item){
        for(Item<K,V> i: item){
            if(i.getKey().equals(key)) return i;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("---------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("---------------");
    }
}
