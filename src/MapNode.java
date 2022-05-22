/**
 * This class is a node being used to implement a map interface through a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco.santana69@qmail.cuny.edu>
 * @version 0.2022
 */
public class MapNode<K, V>{
/*********Data Members*****************************/
    private K key;
    private V value;
    private MapNode<K, V> left, right;
/*********Constructors*****************************/
    private MapNode(){
        key = null;
        value = null;
        left = null;
        right = null;
    }
    public MapNode(K k, V v){
        key = k;
        value = v;
        left = null;
        right = null;
    }
/*********Accessors********************************/
    public K key(){return key;}
    public V value(){return value;}
    public MapNode<K, V> left(){return left;}
    public MapNode<K, V> right(){return right;}
    public boolean isLeaf(){return (left == null && right == null);}
/*********Mutators*********************************/
    public void setKey(K key){this.key = key;}
    public void setValue(V value){this.value = value;}
    public void setLeft(MapNode<K, V> left){this.left = left;}
    public void setRight(MapNode<K, V> right){this.right = right;}
}
