import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String string = scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).toString();
            for (int n = 0; n < string.length() && string.charAt(n) != '.'; ++n) {
                System.out.print(string.charAt(n));
            }
            System.out.println();
        }
        scanner.close();
    }
}
