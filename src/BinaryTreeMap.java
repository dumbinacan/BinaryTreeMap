package BinaryTreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import BinaryTreeMap.MapNode;

/**
 * This class is an implementation of the map interface using a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */

public class BinaryTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	
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
   @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {return this.get((K) key) != null;}

    /**
     * @return true if this map maps one or more keys to the specified value.
     */
    @SuppressWarnings("unchecked")
    public boolean containsValue(Object value) {
        if ( root == null ) { return false; }
        return recCV(root, (V) value);
    }

    private boolean recCV(MapNode<K, V> it, V value) {
        boolean containsValue = false;
        if (it.getValue() == value) { containsValue = true; }
        if (it.left() != null) { containsValue = recCV(it.left(), value); }
        if (it.right() != null) { containsValue = recCV(it.right(), value); }
        return containsValue;
    }

    /**
     * @return V if this map contains a value for the specified key else return null
     */
    @SuppressWarnings("unchecked")
    public V get(Object k){
        MapNode<K, V> node;
        K key = (K) k;
        if (root == null) {return null;}
        node = findNode(root, key);
        if (node == null) {return null;}
        return node.getValue();
    }

    private MapNode<K, V> findNode(MapNode<K, V> it, K key){
        if ( key.equals( it.getKey() ) ) { return it; }
        if ( key.compareTo( it.getKey() ) < 0 ) {
            if ( it.left() == null ) { return null; }
            it = it.left();
        }
        if ( key.compareTo( it.getKey() ) > 0 ) {
            if ( it.right() == null ) { return null; }
            it = it.right();
        }
        return findNode(it, key);
    }

    public V put(K key, V value){

        MapNode<K, V> node;
        V tmp = null;

        if(root == null){
            root = new MapNode<K,V>(key, value);
            ++size;
            return null;
        }

        node = findParentNode(root, key);

        if ( key.compareTo( node.getKey() ) < 0 ) {
            if ( node.left() != null ) { tmp = node.left().getValue(); --size; }
            node.setLeft( new MapNode<K, V> (key, value) ); // maybe don't create a new one if you don't have to?
        }

        if ( key.compareTo( node.getKey() ) > 0 ) {
            if ( node.right() != null ) { tmp = node.right().getValue(); --size; }
            node.setRight( new MapNode<K, V> (key, value) ); // maybe don't create a new one if you don't have to?
        }

        ++size;
        return tmp;
    }

    private MapNode<K, V> findParentNode(MapNode<K, V> it, K key){
        if ( it.getKey().equals(key) ) { return it; } // root node

        if ( key.compareTo( it.getKey() ) < 0 ) {
            if ( it.left() == null || key.equals( it.left().getKey() ) ) { return it; }
            it = it.left();
        }

        if ( key.compareTo( it.getKey() ) > 0 ) {
            if ( it.right() == null || key.equals( it.right().getKey() ) ) { return it; }
            it = it.right();
        }

        return findParentNode(it, key);
    }
 
    @SuppressWarnings("unchecked")
    public V remove(Object k) {
        V value;
        MapNode<K, V> tmp, tmpParent, replacement;
        K key = (K) k;

        if(root == null) { return null; }

        tmp = findNode(root, key);

        if ( tmp == null ) { return null; } // key not found

        value = tmp.getValue(); // store value before removal
        --size; // update the size

        if ( tmp.isLeaf() ) {
            replacement = findParentNode(root, key);
            if (key.compareTo( replacement.getKey() ) < 0) { replacement.setLeft(null); }
            else replacement.setRight(null);
            return value;
        }

        /* find the replacement node */
        if ( tmp.left() == null ) { replacement = tmp.right(); }
        else {
            replacement = tmp.left();
            while ( replacement.right() != null ) { replacement = replacement.right(); }
        } 

        /* replace the node */

        tmp.setKey( replacement.getKey() );
        tmp.setValue( replacement.getValue() );
        if ( replacement.left() != null ) {
            replacement.setKey( replacement.left().getKey() );
            replacement.setValue( replacement.left().getValue() );
            replacement.setLeft( replacement.left().left() );
        }

        return value;
    }

    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<V>();
        grabVals( root, values );
        return values;
    }
    private void grabVals(MapNode<K, V> it, ArrayList<V> vals) {
        if ( it.left() != null ) { grabVals( it.left(), vals ); }
        if ( it.right() != null ) { grabVals( it.right(), vals ); }
        vals.add( it.getValue() );
    }

    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<K>();
        grabKeys( root, keys );
        return keys;
    }
    private void grabKeys(MapNode<K, V> it, HashSet<K> keys) {
        if ( it.left() != null ) { grabKeys( it.left(), keys ); }
        if ( it.right() != null ) { grabKeys( it.right(), keys ); }
        keys.add( it.getKey() );
    }

    public Set<Map.Entry<K, V>> entrySet(){ return null;}//for now just to get all the methods here and shit
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> m) {
        // Set<Map.Entry<? extends K, ? extends V>> entries = m.entrySet();
        for (Map.Entry  entry : m.entrySet()) { this.put( (K) entry.getKey(), (V) entry.getValue() ); }
    }
}
