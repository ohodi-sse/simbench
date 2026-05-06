import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * ((scanner.nextDouble() + 0.001) * 100.0).longValue() / 100L);
    }
}
