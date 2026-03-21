import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = nextInt;
        int n2 = nextInt;
        for (int j = nextInt; j >= nextInt - 200; --j) {
            if (!list.contains(j)) {
                n = j;
                break;
            }
        }
        for (int k = nextInt; k <= nextInt + 200; ++k) {
            if (!list.contains(k)) {
                n2 = k;
                break;
            }
        }
        int x = n;
        if (Math.abs(n - nextInt) > Math.abs(n2 - nextInt)) {
            x = n2;
        }
        System.out.println(x);
    }
}