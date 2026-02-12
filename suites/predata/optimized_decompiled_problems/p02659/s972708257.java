import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final Long value;
        if ((value = (scanner = new Scanner(System.in)).nextLong()) == 0L) {
            System.out.println("0");
            return;
        }
        final Long value2;
        if ((value2 = value * Long.valueOf(scanner.next().replace(".", ""))) < 100L) {
            System.out.println("0");
            return;
        }
        final String value3 = String.valueOf(value2);
        System.out.println(value3.substring(0, value3.length() - 2));
    }
}
