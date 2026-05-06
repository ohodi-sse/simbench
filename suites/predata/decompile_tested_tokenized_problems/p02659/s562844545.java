import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static final StringBuilder builder;
    
    public static void main(final String[] array) {
        System.out.print(readBigDecimal().multiply(readBigDecimal()).toBigInteger());
    }
    
    private static void read() {
        Main.builder.setLength();
        try {
            while (true) {
                final int read = System.in.read();
                if (read == 32 || read == 10 || read == -1) {
                    break;
                }
                Main.builder.appendCodePoint(read);
            }
        }
        catch (final IOException ex) {}
    }
    
    private static int readInt() {
        read();
        return Integer.parseInt(Main.builder.toString());
    }
    
    private static int readInt(final int radix) {
        read();
        return Integer.parseInt(Main.builder.toString(), radix);
    }
    
    private static long readLong() {
        read();
        return Long.parseLong(Main.builder.toString());
    }
    
    private static long readLong(final int radix) {
        read();
        return Long.parseLong(Main.builder.toString(), radix);
    }
    
    private static double readDouble() {
        read();
        return Double.parseDouble(Main.builder.toString());
    }
    
    private static BigInteger readBigInteger() {
        read();
        return new BigInteger(Main.builder.toString());
    }
    
    private static BigInteger readBigInteger(final int radix) {
        read();
        return new BigInteger(Main.builder.toString(), radix);
    }
    
    private static BigDecimal readBigDecimal() {
        read();
        return new BigDecimal(Main.builder.toString());
    }
    
    private static void skipLine() {
        try {
            int read;
            do {
                read = System.in.read();
            } while (read != 10 && read != -1);
        }
        catch (final IOException ex) {}
    }
    
    private static void skip() {
        try {
            int read;
            do {
                read = System.in.read();
            } while (read != 32 && read != 10 && read != -1);
        }
        catch (final IOException ex) {}
    }
    
    static {
        builder = new StringBuilder();
    }
}
