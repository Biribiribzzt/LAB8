public interface Entry<K, V> {
    K getKey();
    V getValue();
    V setValue(V value);

    @Override
    String toString();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();


}
    



    