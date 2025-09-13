import java.util.Comparator;



public abstract class AbstractSortedMap<K,V> extends AbstractMap<K,V> {
    private Comparator<K> comp; // comparator defining the ordering of keys
    protected AbstractSortedMap() { 
        super(); 
        comp = null; // or set a default comparator
    }

    protected AbstractSortedMap(Comparator<K> c) { 
        super(); 
        comp = c; 
    }   
    public Entry<K,V> firstEntry(){
        if (isEmpty()) return null;
        Entry<K,V> min = null;
        for (Entry<K,V> entry : entrySet()) {
            if (min == null || compare(entry.getKey(), min.getKey()) < 0) {
                min = entry;
            }
        }
        return min;
    }
    public Entry<K,V> lastEntry(){
        if (isEmpty()) return null;
        Entry<K,V> max = null;
        for (Entry<K,V> entry : entrySet()) {
            if (max == null || compare(entry.getKey(), max.getKey()) > 0) {
                max = entry;
            }
        }
        return max;
    }
    public Entry<K,V> ceilingEntry(K key){
        checkKey(key); // may throw IllegalArgumentException
        Entry<K,V> ceil = null;
        for (Entry<K,V> entry : entrySet()) {
            if (compare(entry.getKey(), key) >= 0) {
                if (ceil == null || compare(entry.getKey(), ceil.getKey()) < 0) {
                    ceil = entry;
                }
            }
        }
        return ceil;
    }
    public Entry<K,V> floorEntry(K key){
        checkKey(key); // may throw IllegalArgumentException
        Entry<K,V> floor = null;
        for (Entry<K,V> entry : entrySet()) {
            if (compare(entry.getKey(), key) <= 0) {
                if (floor == null || compare(entry.getKey(), floor.getKey()) > 0) {
                    floor = entry;
                }
            }
        }
        return floor;
    }
    public Entry<K,V> lowerEntry(K key){
        checkKey(key); // may throw IllegalArgumentException
        Entry<K,V> lower = null;
        for (Entry<K,V> entry : entrySet()) {
            if (compare(entry.getKey(), key) < 0) {
                if (lower == null || compare(entry.getKey(), lower.getKey()) > 0) {
                    lower = entry;
                }
            }
        }
        return lower;
    }
    public Entry<K,V> higherEntry(K key){
        checkKey(key); // may throw IllegalArgumentException
        Entry<K,V> higher = null;
        for (Entry<K,V> entry : entrySet()) {
            if (compare(entry.getKey(), key) > 0) {
                if (higher == null || compare(entry.getKey(), higher.getKey()) < 0) {
                    higher = entry;
                }
            }
        }
        return higher;
    }
    public abstract Iterable<Entry<K,V>> subMap(K fromKey, K toKey);

    // Removed duplicate constructors
    private void checkKey(K key) throws IllegalArgumentException {
        try {
            @SuppressWarnings("unused")
            int temp = compare(key, key); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

protected int compare(K a, K b) {
    if (comp != null) return comp.compare(a, b);
    if (a instanceof Comparable) {
        @SuppressWarnings("unchecked")
        Comparable<K> comparableA = (Comparable<K>) a;
        return comparableA.compareTo(b);
    } else {
        throw new IllegalArgumentException("Key does not implement Comparable");
    }
}
}
