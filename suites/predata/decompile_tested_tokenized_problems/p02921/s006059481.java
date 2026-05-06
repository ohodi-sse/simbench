import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        System.out.println(solve(new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
    }
    
    public static String solve(final Scanner scanner) {
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        return String.valueOf(i);
    }
}
