import java.util.HashSet;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int j = nextInt;
        int a = 0;
        while (j > 0) {
            if (!set.contains(j)) {
                a = j;
                break;
            }
            --j;
        }
        int k = nextInt;
        int a2 = 101;
        while (k <= 100) {
            if (!set.contains(k)) {
                a2 = k;
                break;
            }
            ++k;
        }
        int x;
        if (Math.abs(a) == Math.abs(a2)) {
            if (a > a2) {
                x = a2;
            }
            else {
                x = a;
            }
        }
        else if (Math.abs(nextInt - a) > Math.abs(nextInt - a2)) {
            x = a2;
        }
        else {
            x = a;
        }
        System.out.println(x);
    }
}