import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next;
        printWriter.println(BigInteger.ONE.multiply(BigInteger.valueOf(Long.parseLong(scanner.next()))).multiply(BigInteger.valueOf(((next = scanner.next()).charAt(0) - 48L) * 1000L + 100L * (next.charAt(2) - 48L) + (next.charAt(3) - 48L) * 10L)).divide(BigInteger.valueOf(1000L)));
        printWriter.flush();
    }
}
