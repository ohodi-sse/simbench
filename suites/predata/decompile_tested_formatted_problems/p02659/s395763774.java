import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(scanner.next())).toBigInteger());
    }
}
