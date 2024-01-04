package BinaryTreeMap;
/**
 * This class is a node being used to implement a map interface through a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Map;
public class MapNode<K extends Comparable<K>, V> { 
    private Entry entry;
    private MapNode<K, V> left, right;

    public MapNode(K k, V v) {
        entry = new Entry(k, v);
        left = null;
        right = null;
    }

    public K getKey() {return entry.getKey();}
    public V getValue() {return entry.getValue();}
    public MapNode<K, V> left() {return left;}
    public MapNode<K, V> right() {return right;}
    public boolean isLeaf() {return (left == null && right == null);}

    public void setKey(K key) {entry.setKey(key);} // TODO remove this method
    public V setValue(V value) {return entry.setValue(value);}
    public void setLeft(MapNode<K, V> left) {this.left = left;}
    public void setRight(MapNode<K, V> right) {this.right = right;}

    private class Entry implements Map.Entry<K,V> {
        private K k;
        private V v;

        public Entry(K key, V value) {
            k = key;
            v = value;
        }

        public K getKey() { return k; }
        public K setKey(K key) { // TODO remove this method
            K oldkey = k;
            k = key;
            return oldkey;
        }
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

            return (me1, me2) -> (me1.getKey().compareTo(me2.getKey()) <= 0) ? 1 : -1;
        }

        public static <K,V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
            return (me1, me2) -> (me1.getValue().compareTo(me2.getValue()) <= 0) ? 1 : -1;
        }

        public static <K,V> Comparator<Map.Entry<K,V>> comparingByKey(Comparator<? super K> cmp) {
            return (me1, me2) -> cmp.compare(me1.getKey(), me2.getKey()) <= 0 ? 1 : -1;
        }

        public static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp) {
            return (me1, me2) -> cmp.compare(me1.getValue(), me2.getValue()) <= 0 ? 1 : -1;
        }
    }
}

