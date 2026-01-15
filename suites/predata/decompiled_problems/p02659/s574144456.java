import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final BigDecimal value = BigDecimal.valueOf(scanner.nextDouble());
        value.multiply(BigDecimal.valueOf(nextLong));
        System.out.println(value.multiply(BigDecimal.valueOf(nextLong)).longValue());
    }
}
