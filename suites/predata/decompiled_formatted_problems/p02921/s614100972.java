import java.util.Iterator;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;





public class Main
{
    public static <T> List<List<T>> zip(final List<T>... array) {
        final ArrayList list = new ArrayList();
        for (final List<T> list2 : array) {
            for (int j = 0; j < list2.size(); ++j) {
                Object o;
                if (j >= list.size()) {
                    list.add(o = new ArrayList<T>());
                }
                else {
                    o = list.get(j);
                }
                ((List<T>)o).add(list2.get(j));
            }
        }
        return list;
    }
    
    static List<Character> toCharacterList(final String s) {
        if (s == null) {
            return null;
        }
        final int length = s.length();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < length; ++i) {
            list.add(s.charAt(i));
        }
        return list;
    }
    
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<List<Object>> zip = zip(toCharacterList(bufferedReader.readLine()), toCharacterList(bufferedReader.readLine()));
        int x = 0;
        for (final List list : zip) {
            if (((Character)list.get(0)).equals(list.get(1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}