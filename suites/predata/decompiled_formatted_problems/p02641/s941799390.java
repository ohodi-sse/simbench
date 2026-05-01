import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;





public class Main
{
    int mod;
    
    void solve(final int n, final int[] array) {
        final HashSet set = new HashSet();
        for (int length = array.length, i = 0; i < length; ++i) {
            set.add(array[i]);
        }
        int n2;
        for (n2 = 0; set.contains(n - n2); ++n2) {
            if (!set.contains(n + n2)) {
                System.out.println(n + n2);
                return;
            }
        }
        System.out.println(n - n2);
    }
    
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = bufferedReader.readLine().split(" ");
        final Main main = new Main();
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final int[] array2 = new int[int2];
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < int2; ++i) {
            array2[i] = Integer.parseInt(split2[i]);
        }
        main.solve(int1, array2);
    }
}