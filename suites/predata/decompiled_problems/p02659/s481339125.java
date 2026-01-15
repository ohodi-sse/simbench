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
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        final char[] charArray = BigDecimal.valueOf(nextDouble).multiply(BigDecimal.valueOf(nextLong)).toPlainString().toCharArray();
        final StringBuilder sb = new StringBuilder();
        for (int n = 0; n < charArray.length && charArray[n] != '.'; ++n) {
            sb.append(charArray[n]);
        }
        System.out.println(sb.toString());
    }
}
