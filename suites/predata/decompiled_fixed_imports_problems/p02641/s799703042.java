import java.io.IOException;
import java.util.HashSet;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = bufferedReader.readLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        if (int2 == 0) {
            System.out.print(int1);
            return;
        }
        final String[] split2 = bufferedReader.readLine().split(" ");
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        if (!set.contains(int1)) {
            System.out.print(int1);
            return;
        }
        int n;
        for (n = 1; set.contains(int1 - n); ++n) {
            if (!set.contains(int1 + n)) {
                System.out.print(int1 + n);
                return;
            }
        }
        System.out.print(int1 - n);
    }
}