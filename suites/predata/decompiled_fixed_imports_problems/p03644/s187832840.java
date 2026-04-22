import java.io.IOException;
import java.util.Scanner;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        final Scanner scanner = new Scanner(System.in);
        final long n = (long)(Math.pow(10.0, 9.0) + 7.0);
        final int nextInt = scanner.nextInt();
        long n2 = 0L;
        int n3 = 0;
        for (int i = 0; i <= nextInt; ++i) {
            int n4 = 0;
            for (int n5 = i; n5 > 1 && n5 % 2 == 0; n5 /= 2) {
                if (n5 % 2 == 0) {
                    ++n4;
                }
            }
            if (n4 > n2) {
                n3 = i;
                n2 = n4;
            }
        }
        System.out.println((n3 == 0) ? 1 : n3);
        bufferedWriter.flush();
    }
    
    static void forl_0(final int n, final int[] array, final Scanner scanner) {
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }
    }
    
    static void forl_1(final int n, final int[] array, final Scanner scanner) {
        for (int i = 1; i <= n; ++i) {
            array[i] = scanner.nextInt();
        }
    }
    
    static void two_d(final int n, final int n2, final int[][] array, final Scanner scanner) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = scanner.nextInt();
            }
        }
    }
    
    static boolean isPrime(final long n) {
        if (n < 2L) {
            return false;
        }
        if (n == 2L || n == 3L) {
            return true;
        }
        if (n % 2L == 0L || n % 3L == 0L) {
            return false;
        }
        for (long n2 = (long)Math.sqrt((double)n) + 1L, n3 = 6L; n3 <= n2; n3 += 6L) {
            if (n % (n3 - 1L) == 0L || n % (n3 + 1L) == 0L) {
                return false;
            }
        }
        return true;
    }
    
    public static long gcd(final long n, final long n2) {
        return (n2 == 0L) ? n : gcd(n2, n % n2);
    }
    
    public static long lcm(final long n, final long n2) {
        return n / gcd(n, n2) * n2;
    }
    
    static class Pair implements Comparable<Pair>
    {
        int a;
        int b;
        
        public Pair(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(final Pair pair) {
            return this.a - pair.a;
        }
    }
}