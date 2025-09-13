import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
    /** Underlying storage for the map of entries. */
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    // Nested MapEntry class implementing Map.Entry<K,V>
    private static class MapEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        public MapEntry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V val) {
            V old = value;
            value = val;
            return old;
        }
    }

    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int n = table.size( );
        for (int j=0; j < n; j++)
        if (table.get(j).getKey( ).equals(key)){
            return j;
        }
        return -1; // special value denotes that key was not found
    }

    public int size( ) { return table.size( ); }

    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null; // not found
        return table.get(j).getValue( );
     }

     public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(new MapEntry<>(key, value)); // add new entry
            return null;
        } 
        else // key already exists
        return table.get(j).setValue(value); // replaced value is returned
     }

    public V remove(K key) {
        int j = findIndex(key);
        int n = table.size( );
        if (j == -1) return null; // not found
        V answer = table.get(j).getValue( );
        if (j != n-1)
        table.set(j, table.get(n-1)); // relocate last entry to 'hole'
        table.remove(n-1); // remove last entry of table
        return answer;
    }

    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int j = 0; // index of the next entry to report
        public boolean hasNext( ) { return j < table.size( ); }
        public Entry<K,V> next( ) {
            if (j == table.size( )) throw new NoSuchElementException( );
            return table.get(j++);
        }
        public void remove( ) { throw new UnsupportedOperationException( ); }
    } //----------- end of nested EntryIterator class -----------


    private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator( ) { return new EntryIterator( ); }
    } //----------- end of nested EntryIterable class -----------

    public Iterable<Entry<K,V>> entrySet( ) { return new EntryIterable( ); }
}