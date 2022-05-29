/**
 * This class is a node being used to implement a map interface through a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
import java.util.Map;
public class MapNode<K, V> { // implements Map.Entry<K, V> {
    private K key;
    private V value;
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

    public K getKey() {return key;}
    public V getValue() {return value;}
    public MapNode<K, V> left() {return left;}
    public MapNode<K, V> right() {return right;}
    public boolean isLeaf() {return (left == null && right == null);}

    public void setKey(K key) {this.key = key;}
    public void setValue(V value) {this.value = value;}
    public void setLeft(MapNode<K, V> left) {this.left = left;}
    public void setRight(MapNode<K, V> right) {this.right = right;}
}
