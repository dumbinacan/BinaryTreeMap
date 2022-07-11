import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
/**
 * Test class to test this stuff
 * @author Marco Antonio Santana <marco@santana.nyc>
 * @version 0.2022
 */
public class Test{
    public static void main(String [] args) {

        BinaryTreeMap<Integer, Character> test = new BinaryTreeMap<Integer, Character>();
        System.out.println("Map initialize, size is " + test.size());

        System.out.println("populating the map");
        for(int i = 0; i < 26; ++i) {
            char c = (char) (i+65);
            test.put(i, c);
            System.out.print("test.put(" + i + ", " + c + "), ");
            System.out.println("test.size(): " + test.size());
        }

        System.out.println("printing the values in map via get() method");
        for(int i = 0; i < test.size(); ++i) {
            System.out.println(" test.get(" + i + "): " + test.get(i) );
        }

        System.out.println("removing some values");
        for(int i = 0; i < 13; ++i) {
            System.out.print( "test.remove(" + i + "): " + test.remove(i) );
            System.out.println(", test.size(): " + test.size());
        }

        System.out.println("adding and replacing values");
        for(int i = 0; i < 26; ++i) {
            char c = (char) (91 - i);
            System.out.print( "test.put(" + i + ", " + c + "): " + test.put(i, c) );
            System.out.println(", test.size(): " + test.size());
        }

        Collection<Character> values = test.values();
        Iterator<Character> valterator = values.iterator();
        System.out.println( "printing Collection of values() who's size is " + values.size() );
        int f = 0;
        while ( valterator.hasNext() ) {
            System.out.println( f++ + ") value: " + valterator.next() );
        }

        for(int i = 0; i < values.size(); ++i) {
            System.out.println(" test.get(" + i + "): " + test.get(i) );
        }

        Set<Integer> keys = test.keySet();
        Iterator<Integer> keyterator = keys.iterator();
        while ( keyterator.hasNext() ) {
            System.out.println( "key: " + keyterator.next() );
        }

        System.out.println("Testing containsValue");
        System.out.println("containsValue('$'): " +test.containsValue('$'));

        System.out.println("test.put(454289, '$')");  test.put(454289, '$');
        System.out.println("containsValue('$'): " + test.containsValue('$'));

        System.out.println( "test.remove(454289): " + test.remove(454289) );
        System.out.println("containsValue('$'): " + test.containsValue('$'));


        System.out.println("containsKey(0): " + test.containsKey(0));

        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("test.clear()");  test.clear();
        System.out.println("isEmpty(): " + test.isEmpty());

        System.out.println("Repopulating to individually remove");
        for(int i = 0; i < 26; ++i) {
            char c = (char) (i+65);
            test.put(i, c);
            System.out.print("test.put(" + i + ", " + c + "), ");
            System.out.println("size: " + test.size());
        }

        System.out.println("Remove everything!");
        for(int i = 0; i < test.size(); ++i) {
            System.out.print( "test.remove(" + i + "): " + test.remove(i) );
            System.out.println( ", test.size(): " + test.size() );
        }

    }
}
