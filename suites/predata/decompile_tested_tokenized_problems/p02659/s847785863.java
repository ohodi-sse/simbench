import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final long long1 = Long.parseLong(scanner.next().replace(".", ""));
        scanner.close();
        System.out.println(nextLong * long1 / 100L);
    }
}
