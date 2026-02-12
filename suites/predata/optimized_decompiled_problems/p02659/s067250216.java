import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String[] split;
        long n;
        if ((split = scanner.next().replace(".", "A").split("A", 0)).length == 1) {
            n = 100L * Long.parseLong(split[0]);
        }
        else {
            n = 100L * Long.parseLong(split[0]) + Long.parseLong(split[1]);
        }
        System.out.println(nextLong / 100L * n + nextLong % 100L * n / 100L);
    }
}
