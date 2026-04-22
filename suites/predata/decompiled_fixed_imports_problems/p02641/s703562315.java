import java.util.HashSet;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) {
        new Main().solve();
    }
    
    public void solve() {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= 101; ++j) {
            if (!set.contains(j)) {
                final int abs = Math.abs(j - nextInt);
                if (abs < n) {
                    x = j;
                    n = abs;
                }
            }
        }
        System.out.println(x);
    }
}