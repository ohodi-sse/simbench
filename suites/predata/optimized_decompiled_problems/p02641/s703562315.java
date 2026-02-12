import java.util.HashSet;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        new Main();
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (!set.contains(j) && (abs = Math.abs(j - nextInt)) < n) {
                x = j;
                n = abs;
            }
        }
        System.out.println(x);
    }
    
    private static void solve() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (!set.contains(j) && (abs = Math.abs(j - nextInt)) < n) {
                x = j;
                n = abs;
            }
        }
        System.out.println(x);
    }
}
