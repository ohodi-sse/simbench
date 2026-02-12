import java.util.List;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long mod;
    private static String alpha;
    
    private static void main$3231c38a() throws IOException {
        final Scanner scanner = new Scanner(System.in);
        long n = 1L;
        while (n-- > 0L) {
            final int[] array = new int[1000];
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(scanner.nextInt());
                final int[] array2 = array;
                final int abs = Math.abs(nextInt - list.get(i));
                ++array2[abs];
            }
            int n2 = 0;
            int x = 0;
            if (array[0] != 1) {
                System.out.println(nextInt);
            }
            else {
                for (int j = 1; j < array.length; ++j) {
                    if (array[j] < 2) {
                        n2 = nextInt - j;
                        x = nextInt + j;
                        break;
                    }
                }
                if (list.indexOf(n2) >= 0) {
                    System.out.println(x);
                }
                else {
                    System.out.println(n2);
                }
            }
        }
        scanner.close();
    }
    
    private static ArrayList factors(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 1; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {
                if (i == Math.sqrt(n)) {
                    list.add(i);
                }
                else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        Collections.sort((List<Comparable>)list);
        return list;
    }
    
    private static boolean isPrime(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 1; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {
                if (i == Math.sqrt(n)) {
                    list.add(i);
                }
                else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        Collections.sort((List<Comparable>)list);
        return list.size() == 2;
    }
    
    private static long GCD(long n, long n2) {
        while (n != 0L) {
            if (n2 == 0L) {
                return n;
            }
            if (n == n2) {
                return n;
            }
            if (n > n2) {
                n -= n2;
            }
            else {
                final long n3 = n;
                n2 -= n;
                n = n3;
            }
        }
        return n2;
    }
    
    private static long LCM(final long n, final long n2) {
        final long n3 = n * n2;
        long n4 = n2;
        long n5 = n;
        while (n5 != 0L) {
            long n6;
            if (n4 == 0L) {
                n6 = n5;
            }
            else if (n5 == n4) {
                n6 = n5;
            }
            else {
                if (n5 > n4) {
                    n5 -= n4;
                    continue;
                }
                final long n7 = n5;
                n4 -= n5;
                n5 = n7;
                continue;
            }
            return n3 / n6;
        }
        long n6 = n4;
        return n3 / n6;
    }
    
    private static String rev(final String s) {
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < (s.length() + 1) / 2; ++i) {
            final char c = charArray[i];
            charArray[i] = charArray[s.length() - i - 1];
            charArray[s.length() - i - 1] = c;
        }
        return new String(charArray);
    }
    
    private static long pow(final long n, final long n2) {
        if (n2 == 0L) {
            return 1L;
        }
        if (n2 == 1L) {
            return n;
        }
        final long pow = pow(n, n2 / 2L);
        if (n2 % 2L == 0L) {
            final long n3 = pow;
            return n3 * n3;
        }
        final long n4 = pow;
        return n4 * n4 * n;
    }
    
    private static long powMod(final long n, final long n2) {
        if (n2 == 0L) {
            return 1L;
        }
        if (n2 == 1L) {
            return n % Main.mod;
        }
        final long n3 = powMod(n, n2 / 2L) % Main.mod;
        long n4 = n3 * n3 % Main.mod;
        if (n2 % 2L == 1L) {
            n4 = n4 * n % Main.mod;
        }
        return n4 % Main.mod;
    }
    
    static {
        Main.mod = (long)(Math.pow(10.0, 9.0) + 7.0);
    }
}
