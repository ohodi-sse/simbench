import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int x = 1;
        int n = 0;
        int n2 = 0;
        for (int i = nextInt; i > 0; --i) {
            final int n3 = i;
            while (i % 2 == 0) {
                ++n2;
                i /= 2;
            }
            i = n3;
            if (n2 > n) {
                x = n3;
                n = n2;
            }
            n2 = 0;
        }
        System.out.println(x);
        scanner.close();
    }
}