import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String[] split = scanner.next().replace(".", "A").split("A", 0);
        long n;
        if (split.length == 1) {
            n = 100L * Long.parseLong(split[0]);
        }
        else {
            n = 100L * Long.parseLong(split[0]) + Long.parseLong(split[1]);
        }
        System.out.println(nextLong / 100L * n + nextLong % 100L * n / 100L);
    }
}
