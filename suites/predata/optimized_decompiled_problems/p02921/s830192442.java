import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final String[] split = next.split("");
        final String[] split2 = next2.split("");
        int x = 0;
        if (split[0].equals(split2[0])) {
            x = 1;
        }
        if (split[1].equals(split2[1])) {
            ++x;
        }
        if (split[2].equals(split2[2])) {
            ++x;
        }
        System.out.println(x);
    }
}
