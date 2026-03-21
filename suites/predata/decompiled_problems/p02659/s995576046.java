import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.Map;





public class Main
{
    static Map<BigInteger, Integer> memo;
    
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal().multiply(new BigDecimal(scanner.nextBigInteger())).toBigInteger());
    }
    
    static int lowerBound(final int[] array, final int n) {
        int i = 0;
        int n2 = array.length - 1;
        while (i <= n2) {
            final int n3 = i + (n2 - i) / 2;
            if (array[n3] <= n) {
                i = n3 + 1;
            }
            else {
                n2 = n3 - 1;
            }
        }
        return n2;
    }
    
    static boolean isPalindrome(final String s) {
        int i = 0;
        int n = s.length() - 1;
        while (i <= n) {
            if (s.charAt(i++) != s.charAt(n--)) {
                return false;
            }
        }
        return true;
    }
    
    static String longestPalindrome(final String[] array, final String s, final int n) {
        if (n >= array.length) {
            if (isPalindrome(s)) {
                return s;
            }
            return "";
        }
        else {
            if (s.length() > 0 && isPalindrome(s)) {
                return s;
            }
            final String longestPalindrome = longestPalindrome(array, s + array[n], n + 1);
            final String longestPalindrome2 = longestPalindrome(array, s, n + 1);
            if (longestPalindrome.length() > 0) {
                return longestPalindrome;
            }
            return longestPalindrome2;
        }
    }
    
    static int solve(final int[] array, final int n, final int n2, final int n3) {
        if (n == n2 && array[n] <= n3) {
            return 1;
        }
        int n4 = 0;
        int n5 = 0;
        if (array[n] <= n3) {
            n4 = solve(array, n + 1, n2, n3) + 1;
        }
        else if (array[n2] <= n3) {
            n5 = solve(array, n, n2 - 1, n3) + 1;
        }
        return n4 + n5;
    }
    
    static int minMove(final BigInteger bigInteger, final int n) {
        if (bigInteger.equals(BigInteger.ONE)) {
            return n;
        }
        int minMove = Integer.MAX_VALUE;
        int minMove2 = Integer.MAX_VALUE;
        int minMove3 = Integer.MAX_VALUE;
        if (bigInteger.mod(BigInteger.valueOf(2L)).compareTo(BigInteger.ZERO) == 0) {
            minMove = minMove(bigInteger.divide(BigInteger.valueOf(2L)), n + 1);
        }
        else if (bigInteger.mod(BigInteger.valueOf(3L)).compareTo(BigInteger.ZERO) == 0) {
            minMove2 = minMove(bigInteger.multiply(BigInteger.valueOf(2L)).divide(BigInteger.valueOf(3L)), n + 1);
        }
        else if (bigInteger.mod(BigInteger.valueOf(5L)).compareTo(BigInteger.ZERO) == 0) {
            minMove3 = minMove(bigInteger.multiply(BigInteger.valueOf(4L)).divide(BigInteger.valueOf(5L)), n + 1);
        }
        if (Main.memo.containsKey(bigInteger)) {
            return Main.memo.get(bigInteger);
        }
        Main.memo.put(bigInteger, Math.min(minMove, Math.min(minMove2, minMove3)));
        return Math.min(minMove, Math.min(minMove2, minMove3));
    }
}