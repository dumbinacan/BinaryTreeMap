import java.util.Collection; import java.util.Map;
import java.util.Set;

/**
 * This class is an implementation of the map interface using a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */

public class BinaryTreeMap<K, V> implements Map<K extends Comparable<K>, V> {
	
    private MapNode<K, V> root;
    private int size;

    /**
     * Constructs a BinaryTreeMap
     */
    public BinaryTreeMap(){
        this.clear();
    }

    /**
     * Removes all of the mappings from this map
     */
    public void clear() {
	    size = 0;
	    root = null;
    }

    /**
     * @return the number of key-value mappings in this map
     */
    public int size(){return size;}

    /**
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty(){return (root == null);}

    /**
     * @return true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {return this.get((K) key) != null;}

    /**
     * @return true if this map maps one or more keys to the specified value.
     */
    @SuppressWarnings("unchecked")
    public boolean containsValue(Object value){return recCV(root, (V) value);}
    private boolean recCV(MapNode<K, V> it, V value){
        if(it.value() == value){return true;}
        if(it.left() != null){recCV(it.left(), value);}
        if(it.right() != null){recCV(it.right(), value);}
        return false;
    }

    /**
     * @return V if this map contains a value for the specified key else return null
     */
    @SuppressWarnings("unchecked")
    public V get(Object k){
        MapNode<K, V> node;
        K key = (K) k;
        if(root == null){return null;}
        node = findNode(root, key);
        return node.value();
    }
    private MapNode<K, V> findNode(MapNode<K, V> it, K key){
        if ( it.key().equals(key) ) { return it; }
        if ( key.compareTo( it.key() ) < 0 ) {
            if ( it.left() == null ) { return null; }
            findNode(it.left(), key);
        }
        if ( key.compareTo( it.key() ) > 0 ) {
            if ( it.right() == null ) { return null; }
            findNode(it.right(), key);
        }
        return null;
    }

    public V put(K key, V value){

        MapNode<K, V> node;
        V value = null;

        if(root == null){
            root = new MapNode<K,V>(key, value);
            ++size;
            return null;
        }

        node = findParentNode(root, key);

        if ( key.compareTo( it.key() ) < 0 ) {
            if ( it.left() != null ) { value = it.left().value(); }
            it.setLeft( new MapNode<K, V> (key, value) ); // maybe don't create a new one if you don't have to?
        }

        if ( key.compareTo( it.key() ) > 0 ) {
            if ( it.right() != null ) { value = it.right().value(); }
            it.setRight( new MapNode<K, V> (key, value) ); // maybe don't create a new one if you don't have to?
        }

        return value;
    }

    private V findParentNode(MapNode<K, V> it, K key){
        if ( it.key().equals(key) ) { return it; } // root node

        if ( key.compareTo( it.key() ) < 0 ) {
            if ( it.left() == null || key.equals( it.left().key() ) ) { return it; }
            findParentNode(it.left(), key);
        }

        if ( key.compareTo( it.key() ) > 0 ) {
            if ( it.right() == null || key.equals( it.right().key() ) ) { return it; }
            findParentNode(it.right(), key);
        }

        return null;
    }
 
    @SuppressWarnings("unchecked")
    public V remove(Object k) {
        V value;
        MapNode<K, V> tmp, tmpParent, replacement;
        K key = (K) k;

        if(root == null) { return null; }
        if(root.isLeaf() && root.key() == key) {
            value = root.value();
            this.clear;
            return value;
        }

        tmp = findNode(root, key);

        if ( tmp == null ) { return null; } // key not found

        value = tmp.value(); // store value before removal
        --size; // update the size

        /* find the replacement node */
        if ( tmp.left() == null ) { replacement == tmp.right(); }
        else {
            replacement = tmp.left();
            while ( replacement.right() != null ) { replacement = replacement.right(); }
        } 

        /* replace the node */
        tmp.setKey( replacement.key() );
        tmp.setValue( replacement.value() );
        if ( replacement.left() != null ) {
            replacement.setKey( replacement.left().key() );
            replacement.setValue( replacement.left().value() );
            replacement.setLeft( replacement.left().left() );
        }

        return value;
    }
   @SuppressWarnings("unchecked")
    public Set<Map.Entry<K, V>> entrySet(){ return null;}//for now just to get all the methods here and shit
    public Collection<V> values(){return null;}//for now just to get all the methods here and shit
    public Set<K> keySet(){return null;}//for now just to get all the methods here and shit
    public void putAll(Map<? extends K, ? extends V> m){}//for now just to get all the methods here and shit
}
