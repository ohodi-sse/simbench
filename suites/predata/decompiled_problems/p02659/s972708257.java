import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final Long value = scanner.nextLong();
        if (value == 0L) {
            System.out.println("0");
            return;
        }
        final Long value2 = value * Long.valueOf(scanner.next().replace(".", ""));
        if (value2 < 100L) {
            System.out.println("0");
            return;
        }
        final String value3 = String.valueOf(value2);
        System.out.println(value3.substring(0, value3.length() - 2));
    }
}
