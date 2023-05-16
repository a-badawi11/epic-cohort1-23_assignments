import java.util.*;
import java.util.function.BiConsumer;

public class CHashMap<K, V> {
    private int size;

    private LinkedList<Node>[] buckets;

    final int DEFAULT_INITIAL_CAPACITY = 16;


    public CHashMap() {
        initBucket();
        size = 0;
    }

    private void initBucket() {
        buckets = new LinkedList[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }


    public void put(K key, V value) {
        int hi = hash(key);
        int i = getIndexWithinBucket(key,hi);
        if(i!=-1){
            Node node = buckets[hi].get(i);
            node.val = value;
        }
        else{
            Node node = new Node(key,value);
            buckets[hi].add(node);
            size++;
        }
    }

    public V get(K key) throws Exception {
        int hi = hash(key);
        int i = getIndexWithinBucket(key,hi);
        if(i !=- 1){
            Node node = buckets[hi].get(i);
            return node.val;
        }
        else{
            return null;
        }
    }

    public boolean containsKey(K key) {
        int hi = hash(key);
        int i = getIndexWithinBucket(key,hi);
        return i != -1;
    }

    public V remove(K key) {
        int hi = hash(key);
        int i = getIndexWithinBucket(key,hi);
        if(i != -1){
            Node node = buckets[hi].remove(i);
            size--;
            return node.val;
        }
        else{
            return null;
        }
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (LinkedList<Node> bucket : buckets) {
            for (Node node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (LinkedList<Node> bucket : buckets) {
            for (Node node : bucket) {
                values.add(node.val);
            }
        }
        return values;
    }

    public int size() {
        return size;
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        for (LinkedList<Node> bucket : buckets) {
            for (Node node : bucket) {
                action.accept(node.key, node.val);
            }
        }
    }

    private int getIndexWithinBucket(K key, int hi){
        int i = 0;
        for(Node node : buckets[hi]){
            if(node.key.equals(key)){
                return i;
            }
            i++;
        }
        return -1;
    }

    private int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    class Node {
        K key;
        V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
