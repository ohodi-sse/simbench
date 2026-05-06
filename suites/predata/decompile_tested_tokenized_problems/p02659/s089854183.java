import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        System.out.println(Long.parseLong(split[0]) * convertToLong(split[1]) / 100L);
    }
    
    private static long convertToLong(final String s) {
        long n = 0L;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n = n * 10L + (s.charAt(i) - '0');
            }
        }
        return n;
    }
}
