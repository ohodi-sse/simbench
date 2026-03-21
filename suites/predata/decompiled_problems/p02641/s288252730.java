import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        System.out.println(run());
    }
    
    private static ArrayList<Integer> nScan(final Scanner scanner, final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < n; ++i) {
            list.add(scanner.nextInt());
        }
        return list;
    }
    
    private static Object run() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            if (nextInt2 == 0) {
                final Integer value = nextInt;
                scanner.close();
                return value;
            }
            ArrayList<Integer> nScan;
            int i;
            for (nScan = nScan(scanner, nextInt2), i = nextInt; nScan.contains(i); ++i) {}
            int j = i;
            int k;
            for (k = nextInt; nScan.contains(k); --k) {}
            if (j - nextInt >= nextInt - k) {
                j = k;
            }
            return j;
        }
    }
}