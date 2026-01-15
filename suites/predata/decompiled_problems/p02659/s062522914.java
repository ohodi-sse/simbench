import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
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
