import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int int1 = Integer.parseInt(stringTokenizer.nextToken());
        if (Integer.parseInt(stringTokenizer.nextToken()) == 0) {
            printWriter.println(int1);
            bufferedReader.close();
            printWriter.close();
            return;
        }
        final String[] split = bufferedReader.readLine().split(" ");
        final HashSet set = new HashSet();
        final String[] array2 = split;
        for (int length = array2.length, i = 0; i < length; ++i) {
            set.add(Integer.parseInt(array2[i]));
        }
        int n = int1;
        int n2 = int1;
        final int n3 = 1;
        if (!set.contains(int1)) {
            printWriter.println(int1);
            bufferedReader.close();
            printWriter.close();
            return;
        }
        while (n != 100 || n2 != 0) {
            n += n3;
            n2 -= n3;
            if (!set.contains(n2)) {
                printWriter.println(n2);
                break;
            }
            if (!set.contains(n)) {
                printWriter.println(n);
                break;
            }
        }
        bufferedReader.close();
        printWriter.close();
    }
}