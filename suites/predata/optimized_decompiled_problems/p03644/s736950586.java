import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        Integer n;
        Integer n2;
        for (n = new Integer(scanner.next()), n2 = 2; n >= n2; n2 <<= 1) {}
        System.out.println(n2 / 2);
        scanner.close();
    }
}
