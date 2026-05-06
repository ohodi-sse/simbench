import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split(" ", 0);
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1]).multiply(BigDecimal.valueOf(100L))).divide(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.DOWN));
    }
}
