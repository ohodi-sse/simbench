public final class Main
{
    private static StringBuilder builder;
    
    private static void main$3231c38a() {
        final int int1 = readInt();
        final int int2 = readInt();
        final ArrayList list = new ArrayList<Integer>(int2);
        for (int i = 0; i < int2; ++i) {
            list.add(readInt());
        }
        int n;
        for (n = 0; list.contains(int1 - n); ++n) {
            if (!list.contains(int1 + n)) {
                System.out.print(int1 + n);
                return;
            }
            list.remove((Object)(int1 - n));
            list.remove((Object)(int1 + n));
            if (int1 + n == Integer.MAX_VALUE || int1 - n == Integer.MIN_VALUE) {
                return;
            }
        }
        System.out.print(int1 - n);
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
    
    private static BigInteger readBigInteger() {
        read();
        return new BigInteger(Main.builder.toString());
    }
    
    private static BigInteger readBigInteger(final int radix) {
        read();
        return new BigInteger(Main.builder.toString(), radix);
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
        Main.builder = new StringBuilder();
    }
}