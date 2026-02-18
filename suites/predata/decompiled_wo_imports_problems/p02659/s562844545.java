public final class Main
{
    private static final StringBuilder builder;
    
    private static void main$3231c38a() {
        System.out.print(readBigDecimal().multiply(readBigDecimal()).toBigInteger());
    }
    
    private static void read() {
        Main.builder.setLength();
        try {
            int read;
            while ((read = System.in.read()) != 32 && read != 10 && read != -1) {
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
            while ((read = System.in.read()) != 10 && read != -1) {}
        }
        catch (final IOException ex) {}
    }
    
    private static void skip() {
        try {
            int read;
            while ((read = System.in.read()) != 32 && read != 10 && read != -1) {}
        }
        catch (final IOException ex) {}
    }
    
    static {
        builder = new StringBuilder();
    }
}