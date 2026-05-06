import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] split = scanner.nextLine().split(" ");
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).longValue());
        scanner.close();
    }
}
