import java.util.ArrayList;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final ArrayList list = new ArrayList();
        for (String s = bufferedReader.readLine(); s != null; s = bufferedReader.readLine()) {
            list.add(s);
        }
        final String s2 = (String)list.get(0);
        final String s3 = (String)list.get(1);
        int x = 0;
        for (int i = 0; i < s2.length(); ++i) {
            if (s2.substring(i, i + 1).equals(s3.substring(i, i + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}