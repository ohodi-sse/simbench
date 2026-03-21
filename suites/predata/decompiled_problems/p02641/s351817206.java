import java.util.HashSet;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            set.add(array2[i]);
        }
        int n = 0;
        while (true) {
            final int n2 = nextInt - n;
            if (!set.contains(n2)) {
                System.out.println(n2);
                return;
            }
            final int n3 = nextInt + n;
            if (!set.contains(n3)) {
                System.out.println(n3);
                return;
            }
            ++n;
        }
    }
}