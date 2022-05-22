import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * This class is an implementation of the map interface using a binary tree
 * Revisted 05-22-2022
 * @author Marco Antonio Santana <marco.santana69@qmail.cuny.edu>
 * @version 0.2022
 */

public class BinaryTreeMap<K, V> implements Map<K, V>{
	
/********Data Members******************************/
    private MapNode<K, V> root;
    private int size;

    /**
     * Constructs a BinaryTreeMap
     */
    public BinaryTreeMap(){
        root = null;
        size = 0;
    }
    /**
     * Removes all of the mappings from this map
     */
    public void clear() {
	    size = 0;
	    root = null;
    }
    /**
     * @return true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {
	    return false;
    }
    /**
     * @return true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(Object Value) {
	    return false;
    }
    /****/
    @SuppressWarnings("unchecked")
    public V get(Object k){
        K key = (K) k;
        if(root == null)
            return null;
        if(root.key().equals(key))
            return root.value();
        return recGet(root, key);
    }
    private V recGet(MapNode<K, V> it, K key){
        if(it.left() != null){
            recGet(it.left(), key);
        }
        if(it.right() != null){
            recGet(it.right(), key);
        }
        if(it.key().equals(key)){
            return it.value();
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public V remove(Object k){
        V value;
        MapNode<K, V> tmp, tmpParent, right;
        K key = (K) k;
        if(root == null)
            return null;
        if(root.//is leaf and also the key is root... the rest should be the same whether root or not right????
        if(root.key() == key){
            value = root.value();
            if(root.left() != null){// check if right is null after that
                tmp = getVictim(root);
                tmpParent = getVictimParent(root);
                right = root.right();
                if(tmpParent.right() == tmp)
                    tmpParent.setRight(null);
                else if(tmpParent.left() == tmp)
                    tmpParent.setLeft(null);
                root = tmp;
                root.setRight(right);
                --size;
            }
            else if(root.right() != null){
                root = root.right();
                --size;
            }
            else{
                root = null;
                --size;
            }
        }
        return value;
    }
    private MapNode<K, V> getVictim(MapNode<K, V> start){goRight(start.left());}
    private MapNode<K, V> goRight(MapNode<K, V> node){
        if(node.right() != null)
            goRight(node.right());
        else if(node.left() != null)
            goRight(node.left());
        else
            return node;
    }
    private MapNode<K, V> getVictimParent(MapNode<K, V> start){goRightParent(start.left(), start);}
    private MapNode<K, V> goRightParent(MapNode<K, V> node, MapNode<K, V> prev){
        if(node.right() != null){
            goRightParent(node.right(), node);
        }
        else if(node.left() != null){
            goRightParent(node.left(), node);
        }
        else
            return prev;
    }
    public V put(K key, V value){
        if(root == null){
            root = new MapNode<K,V>(key, value);
            ++size;
            return null;
        }
        else
            return recPut(root, key, value);
    }
    private V recPut(MapNode<K, V> it, K key, V value){
        V tmp = null;
        if(it.key() == key){
            tmp = it.value();
            it.setValue(value);
            return tmp;
        }
        if(key < it.key()){
            if(it.left() != null)
                recPut(it.left(), key, value);
            else{
                it.setLeft(new MapNode<K, V>(key, value));
                ++size;
                return null;
            }
        }
        if(key > it.key()){
            if(it.right() != null)
                recPut(it.right(), key, value);
            else{
                it.setRight(new MapNode<K, V>(key, value));
                ++size;
                return null;
            }
        }
    }
    public int size(){return size;}
    public boolean isEmpty(){return (root == null);}
    @SuppressWarnings("unchecked")
    public boolean containsValue(Object value){return recCV(root, (V) value);}
    private boolean recCV(MapNode<K, V> it, V value){
        if(it.left() != null){
            recCV(it.left(), value);
        }
        if(it.right() != null){
            recCV(it.right(), value);
        }
        if(it.value() == value){
            return true;
        }
        return false;
    }
            
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key){return get((K) key) != null;}
    public Set<Map.Entry<K, V>> entrySet(){ return null;}//for now just to get all the methods here and shit
    public Collection<V> values(){return null;}//for now just to get all the methods here and shit
    public Set<K> keySet(){return null;}//for now just to get all the methods here and shit
    public void clear(){}//for now just to get all the methods here and shit
    public void putAll(Map<? extends K, ? extends V> m){}//for now just to get all the methods here and shit
}
