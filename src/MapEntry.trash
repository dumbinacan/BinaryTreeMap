package BinaryTreeMap;
import java.util.Map;
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

    public static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey() {

        // Comparator<MapEntry> cmp = (me1, me2) -> ( me1.getKey() > me2.getKey() ) ? 1 : -1;

        /* Comparator<MapEntry> com = new Comparator<MapEntry>() {
         *     public int compare(MapEntry me1, MapEntry me2) { 
         *         if ( me1.getKey() > me2.getKey() ) { return 1; }
         *         else { return -1; }
         *     }
         * };
         */

        return (me1, me2) -> ( me1.getKey() > me2.getKey() ) ? 1 : -1;
    }

    public static <K,V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
        return (me1, me2) -> ( me1.getValue() > me2.getValue() ) ? 1 : -1;
    }
// take a comparator for K or V and return a compartor for MapEntry
    public static <K,V> Comparator<Map.Entry<K,V>> comparingByKey(Comparator<? super K> cmp) {
        return (me1, me2) -> cmp.compare( me1.getKey(), me2.getKey() ) ? 1 : -1;
    }
    public static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp) {
        return (me1, me2) -> cmp.compare( me1.getValue(), me2.getValue() ) ? 1 : -1;
    }
}
