import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            int n = 0;
            int x = 0;
            for (int i = 1; i <= nextInt; ++i) {
                final int returnEvenCnt = returnEvenCnt(i, 0);
                if (n <= returnEvenCnt) {
                    x = i;
                    n = returnEvenCnt;
                }
            }
            System.out.println(x);
        }
    }
    
    private static int returnEvenCnt(int n, int n2) {
        if (n % 2 == 1) {
            return n2;
        }
        n /= 2;
        ++n2;
        return returnEvenCnt(n, n2);
    }
}