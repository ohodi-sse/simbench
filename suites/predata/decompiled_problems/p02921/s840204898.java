import java.io.IOException;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    public static long myMod(final long n, final long n2) {
        long n3 = n % n2;
        if (n3 < 0L) {
            n3 += n2;
        }
        return n3;
    }
    
    public static long myModPow(long n, long n2, final long n3) {
        long n4 = 1L;
        if (n2 == 0L) {
            return 1L;
        }
        if (n3 == 0L) {
            while (n2 > 0L) {
                if (n2 % 2L == 0L) {
                    n *= n;
                    n2 /= 2L;
                }
                else {
                    n4 *= n;
                    --n2;
                }
            }
            return n4;
        }
        while (n2 > 0L) {
            if (n2 % 2L == 0L) {
                n *= myMod(n, n3);
                n2 /= 2L;
            }
            else {
                n4 *= myMod(n, n3);
                --n2;
            }
        }
        return myMod(n4, n3);
    }
}