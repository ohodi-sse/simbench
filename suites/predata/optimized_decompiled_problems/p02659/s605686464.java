import java.util.Scanner;
import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static String solve(final BigDecimal bigDecimal, final BigDecimal multiplicand) {
        final String string;
        final int index;
        if ((index = (string = bigDecimal.multiply(multiplicand).toString()).indexOf(46)) == -1) {
            return string;
        }
        return string.substring(0, index);
    }
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final String string;
        final int index;
        System.out.println(((index = (string = new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).toString()).indexOf(46)) == -1) ? string : string.substring(0, index));
    }
}
