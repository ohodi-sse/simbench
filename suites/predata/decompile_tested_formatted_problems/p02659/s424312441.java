import java.util.Scanner;
import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static BigDecimal MAX;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Long.valueOf(scanner.next().replace(".", "")) / 100L);
        scanner.close();
    }
    
    static {
        Main.MAX = new BigDecimal(1000000000000000000L);
    }
}
