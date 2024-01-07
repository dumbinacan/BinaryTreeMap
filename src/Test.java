import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import BinaryTreeMap.BinaryTreeMap;
/**
 * Test class to test this stuff
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
public class Test{
    final static int MAP_SIZE = 999999;
    public static void main(String [] args){
        System.out.println("containsKey: " + containsKey());
    /*
        Map<Integer, Character> test = new BinaryTreeMap<Integer, Integer();
        System.out.println("Map initialize, size is " + test.size());
        System.out.println("adding some values to the map");

        for(int i = 0; i < 26; ++i){
            char c = (char) (i+65);
            test.put(i, c);
            System.out.println("put(" + i + ", " + c + ")");
            System.out.println("size: " + test.size());
        }

        System.out.println("printing the values in map via get() method");
        for(int i = 0; i < 26; ++i){
            System.out.println("Key: " + i + " Value: " + test.get(i));
        }

        ArrayList<Character> values = (ArrayList<Character>) test.values();
        System.out.println( "printing values from calling values() which is size: " + values.size() );
        for(int i = 0; i < values.size(); ++i){
            System.out.println( " Value: " + values.get(i));
        }

        System.out.println("removing some values");
        for(int i = 0; i < 13; ++i){
            System.out.println("Removing " + i + "Value: " + test.remove(i));
            System.out.println("Updated size: " + test.size());
        }
        System.out.println("addding new values to also test replacing values");
        for(int i = 0; i < 26; ++i){
            char c = (char) (91 - i);
            Character old = test.put(i, c);
            if(old != null)
                System.out.println("previous value for " + i + ": " + old);
            System.out.println("size: " + test.size());
        }
        System.out.println("containsValue('$'): " +test.containsValue('$'));
        System.out.println("containsValue('$'): " +test.containsValue('$'));
        System.out.println("containsValue('$'): " +test.containsValue('$'));
        System.out.println("containsValue('$'): " +test.containsValue('$'));
        System.out.println("containsValue('$'): " +test.containsValue('$'));
        System.out.println("puting $ in this map");
        test.put(454289, '$');
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println(test.remove(454289));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsValue('$'): " + test.containsValue('$'));
        System.out.println("containsKey(0): " + test.containsKey(0));
        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("clear()");
        test.clear();
        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("one last add to manual remove");
        for(int i = 0; i < 26; ++i){
            char c = (char) (i+65);
            test.put(i, c);
            System.out.println("put(" + i + ", " + c + ")");
            System.out.println("size: " + test.size());
        }
        System.out.println("Remove everything!");
        for(int i = 0; i < 26; ++i){
            System.out.println("Removing " + i + "Value: " + test.remove(i));
            System.out.println("Updated size: " + test.size());
        }
    */
    }

    public static boolean containsKey() {
        Map <Double, Double> test = new BinaryTreeMap<Double, Double>();
        double key = Math.random() * MAP_SIZE;
        double value = Math.random() * MAP_SIZE;
        if (test.containsKey(key) ) { return false; }
        test.put(key, value);
        return test.containsKey(key);
    }
/*
    Map <Integer, Integer> = new BinaryTreeMap<Integer, Integer>();
    Map <Integer, Integer> = new HashMap<Integer, Integer>();
    for (int i = 0; i < MAP_SIZE;
*/
}
