import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String string = scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).toString();
        System.out.println(string.substring(0, string.indexOf(46)));
    }
}
