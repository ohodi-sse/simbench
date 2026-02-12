import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int int1 = Integer.parseInt(scanner.next());
            final int int2;
            final Integer[] a = new Integer[int2 = Integer.parseInt(scanner.next())];
            for (int i = 0; i < int2; ++i) {
                a[i] = Integer.parseInt(scanner.next());
            }
            Boolean b = Boolean.TRUE;
            if (!Arrays.asList(a).contains(int1)) {
                System.out.println(int1);
                b = Boolean.FALSE;
            }
            if (b) {
                for (int j = 1; j < int2 + 2; ++j) {
                    final int n = int1 - j;
                    if (!Arrays.asList(a).contains(n)) {
                        System.out.println(n);
                        break;
                    }
                    final int n2 = int1 + j;
                    if (!Arrays.asList(a).contains(n2)) {
                        System.out.println(n2);
                        break;
                    }
                }
            }
        }
        catch (final Exception ex) {
            System.out.println("\u30a8\u30e9\u30fc");
        }
    }
    
    private static void c() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int int1 = Integer.parseInt(scanner.next());
            final int int2;
            final Integer[] a = new Integer[int2 = Integer.parseInt(scanner.next())];
            for (int i = 0; i < int2; ++i) {
                a[i] = Integer.parseInt(scanner.next());
            }
            Boolean b = Boolean.TRUE;
            if (!Arrays.asList(a).contains(int1)) {
                System.out.println(int1);
                b = Boolean.FALSE;
            }
            if (b) {
                for (int j = 1; j < int2 + 2; ++j) {
                    final int n = int1 - j;
                    if (!Arrays.asList(a).contains(n)) {
                        System.out.println(n);
                        break;
                    }
                    final int n2 = int1 + j;
                    if (!Arrays.asList(a).contains(n2)) {
                        System.out.println(n2);
                        break;
                    }
                }
            }
        }
        catch (final Exception ex) {
            System.out.println("\u30a8\u30e9\u30fc");
        }
    }
}
