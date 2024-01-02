package BinaryTreeMap;
public class MapEntry implements Map.Entry<K,V> {
    private K k;
    private V v;

    public MapEntry(K key, V value) {
        k = key;
        v = value;
    }

    public K getKey() { return k; }
    public V getValue() { return v; }
    public V setValue(V value) {
        V oldval = v;
        v = value;
        return oldval;
    }

public static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey() {}
public static <K,V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {}
public static <K,V> Comparator<Map.Entry<K,V>> comparingByKey(Comparator<? super K> cmp) {}
public static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp) {}
}
