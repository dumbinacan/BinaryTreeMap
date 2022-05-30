import java.util.Comparator;
import java.util.Map;

/**
 * This class is a node being used to implement a map interface through a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
public class MapNode<K, V> {
    private class MapEntry implements Map.Entry<K,V> {
        private K key;
        private V value;

        public MapEntry() { key = null; value = null; }
        public MapEntry(K key, V value) { this.key = key; this.value = value; }
        public K getKey() {return this.key;}
        public V getValue() {return this.value;}

        public void setKey(K key) {this.key = key;}
        public V setValue(V value) {
            V tmp = this.value;
            this.value = value;
            return tmp;
        }

        /* here Comparator class for MapEntry can be nested */
        static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey() { return null; }
        static <K,V> Comparator<Map.Entry<K,V>> comparingByKey(Comparator<? super K> cmp) { return null; }
        static <K,V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() { return null; }
        static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp) { return null; }
    }
    private MapEntry mappy;
    private MapNode<K, V> left, right;

    private MapNode() {
        mappy = new MapEntry();
        left = null;
        right = null;
    }
    public MapNode(K k, V v) {
        mappy = new MapEntry(k, v);
        left = null;
        right = null;
    }

    public K key() {return mappy.getKey();}
    public V value() {return mappy.getValue();}
    public MapNode<K, V> left() {return left;}
    public MapNode<K, V> right() {return right;}
    public boolean isLeaf() {return (left == null && right == null);}

    public void setKey(K key) {mappy.setKey(key);}
    public void setValue(V value) {mappy.setValue(value);}
    public void setLeft(MapNode<K, V> left) {this.left = left;}
    public void setRight(MapNode<K, V> right) {this.right = right;}
}
