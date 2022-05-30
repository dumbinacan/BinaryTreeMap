import java.util.Map;

/**
 * This class is a node being used to implement a map interface through a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
public class MapNode<K, V> {
//  map node will have a private member MapEntry instead
    private class MapEntry implements Map.Entry<K,V> {
        private K key;
        private V value;

        public K getKey() {return this.key;}
        public V getValue() {return this.value;}

        public void setKey(K key) {this.key = key;}
        public void setValue(V value) {this.value = value;}

        static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey();
    }
    private MapNode<K, V> left, right;

    private MapNode() {
        key = null;
        value = null;
        left = null;
        right = null;
    }
    public MapNode(K k, V v) {
        key = k;
        value = v;
        left = null;
        right = null;
    }

    public K key() {return MapEntry.getKey();}
    public V value() {return MapEntry.getValue();}
    public MapNode<K, V> left() {return left;}
    public MapNode<K, V> right() {return right;}
    public boolean isLeaf() {return (left == null && right == null);}

    public void setKey(K key) {MapEntry.setKey(key);}
    public void setValue(V value) {MapEntry.setValue(value);}
    public void setLeft(MapNode<K, V> left) {this.left = left;}
    public void setRight(MapNode<K, V> right) {this.right = right;}
}
