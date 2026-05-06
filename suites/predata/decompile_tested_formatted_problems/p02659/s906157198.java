import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final long nextLong = scanner.nextLong();
            final String[] split = scanner.next().split("[.]");
            System.out.println(nextLong * (Long.parseLong(split[0]) * 100L + Long.parseLong(split[1])) / 100L);
        }
    }
}
