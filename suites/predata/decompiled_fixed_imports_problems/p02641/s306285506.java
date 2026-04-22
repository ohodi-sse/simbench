import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int int1 = Integer.parseInt(stringTokenizer.nextToken());
        final int int2 = Integer.parseInt(stringTokenizer.nextToken());
        final HashSet set = new HashSet();
        if (int2 == 0) {
            System.out.println(int1);
        }
        else {
            final StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < int2; ++i) {
                set.add(Integer.parseInt(stringTokenizer2.nextToken()));
            }
            for (int j = 0; j < int2 + 1; ++j) {
                final int n = int1 + j;
                final int n2 = int1 - j;
                if (!set.contains(n2)) {
                    System.out.println(n2);
                    break;
                }
                if (!set.contains(n)) {
                    System.out.println(n);
                    break;
                }
            }
        }
    }
}