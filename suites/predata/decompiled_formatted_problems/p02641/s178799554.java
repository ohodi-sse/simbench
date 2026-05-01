import java.util.HashMap;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < nextInt2; ++i) {
            hashMap.put(scanner.nextInt(), 1);
        }
        int n = 0;
        int x;
        while (true) {
            final int j = nextInt - n;
            final int k = nextInt + n;
            if (hashMap.get(j) == null) {
                x = j;
                break;
            }
            if (hashMap.get(k) == null) {
                x = k;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}