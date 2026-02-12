import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String[] array = new String[3];
        int x = 0;
        scanner.useDelimiter("");
        array[0] = scanner.next();
        array[1] = scanner.next();
        array[2] = scanner.next();
        scanner.next();
        for (int i = 0; i < 3; ++i) {
            if (array[i].equals(scanner.next())) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
